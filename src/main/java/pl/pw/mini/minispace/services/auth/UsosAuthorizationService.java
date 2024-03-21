package pl.pw.mini.minispace.services.auth;

import com.google.api.client.auth.oauth.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.dtos.oauth.OAuthAccessTokenDto;
import pl.pw.mini.minispace.dtos.oauth.OAuthRequestTokenDto;
import pl.pw.mini.minispace.dtos.oauth.OAuthRequestTokenResponse;

@Slf4j
@Service
public class UsosAuthorizationService implements OAuthAuthorizationService {

    private final static String SYSTEM = "USOS";

    @Value("${usos.request.token.url}")
    private String requestTokenUrl;

    @Value("${usos.authorize.url}")
    private String authorizeUrl;

    @Value("${usos.access.token.url}")
    private String accessTokenUrl;

    @Value("${usos.consumer.key}")
    private String usosConsumerKey;

    @Value("${usos.consumer.secret}")
    private String usosConsumerSecret;

    @Override
    public OAuthRequestTokenResponse getRequestToken(OAuthRequestTokenDto oAuthRequestTokenDto) {
        log.info("Authorizing user...");
        OAuthHmacSigner signer = prepareOAuthSigner(usosConsumerSecret, null);
        OAuthGetTemporaryToken getTemporaryToken = prepareOAuthGetTemporaryToken(oAuthRequestTokenDto.getCallbackUrl(), signer);

        OAuthCredentialsResponse temporaryTokenResponse = requestToken(getTemporaryToken);

        OAuthAuthorizeTemporaryTokenUrl authorizeTemporaryTokenUrl = new OAuthAuthorizeTemporaryTokenUrl(authorizeUrl);
        authorizeTemporaryTokenUrl.temporaryToken = temporaryTokenResponse.token;
        String authorizationUrl = authorizeTemporaryTokenUrl.build();

        log.info(String.format("Authorization URL is: %s", authorizationUrl));
        log.info(String.format("Request token: %s", temporaryTokenResponse.token));
        log.info(String.format("Request token secret: %s", temporaryTokenResponse.tokenSecret));

        OAuthRequestTokenResponse requestTokenResponse = new OAuthRequestTokenResponse();
        requestTokenResponse.setRequestToken(temporaryTokenResponse.token);
        requestTokenResponse.setRequestTokenSecret(temporaryTokenResponse.tokenSecret);
        requestTokenResponse.setRedirectUrl(authorizationUrl);

        return requestTokenResponse;
    }

    @Override
    public String getAccessToken(OAuthAccessTokenDto request) {
        log.info("Exchanging request token for access token...");
        OAuthHmacSigner signer = prepareOAuthSigner(usosConsumerSecret, request.getTokenSecret());
        OAuthGetAccessToken getAccessToken = prepareOAuthAccessToken(request, signer);

        OAuthCredentialsResponse accessTokenResponse = requestToken(getAccessToken);
        log.info("Successfully retrieved access token");
        return accessTokenResponse.token;
    }

    private OAuthCredentialsResponse requestToken(AbstractOAuthGetToken oAuthGetToken) {
        OAuthCredentialsResponse oAuthCredentialsResponse;
        try {
            oAuthCredentialsResponse = oAuthGetToken.execute();
        }
        catch (Exception ex) {
            log.error(String.format("Error when trying to request for a token from %s: %s", SYSTEM, ex.getMessage()));
            throw new RuntimeException(ex);
        }
        return oAuthCredentialsResponse;
    }

    private OAuthGetTemporaryToken prepareOAuthGetTemporaryToken(String callbackUrl, OAuthHmacSigner signer) {
        OAuthGetTemporaryToken oAuthGetTemporaryToken = new OAuthGetTemporaryToken(requestTokenUrl);
        oAuthGetTemporaryToken.callback = callbackUrl;
        oAuthGetTemporaryToken.consumerKey = usosConsumerKey;
        oAuthGetTemporaryToken.signer = signer;
        oAuthGetTemporaryToken.transport = new NetHttpTransport();
        return oAuthGetTemporaryToken;
    }

    private OAuthHmacSigner prepareOAuthSigner(String clientSecret, String tokenSecret) {
        OAuthHmacSigner signer = new OAuthHmacSigner();
        signer.clientSharedSecret = clientSecret;
        signer.tokenSharedSecret = tokenSecret;
        return signer;
    }

    private OAuthGetAccessToken prepareOAuthAccessToken(OAuthAccessTokenDto request, OAuthHmacSigner signer) {
        OAuthGetAccessToken oAuthGetAccessToken = new OAuthGetAccessToken(accessTokenUrl);
        oAuthGetAccessToken.temporaryToken = request.getToken();
        oAuthGetAccessToken.consumerKey = usosConsumerKey;
        oAuthGetAccessToken.signer = signer;
        oAuthGetAccessToken.verifier = request.getVerifier();
        oAuthGetAccessToken.transport = new NetHttpTransport();
        return oAuthGetAccessToken;
    }
}
