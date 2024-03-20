package pl.pw.mini.minispace.services.auth;

import pl.pw.mini.minispace.dtos.oauth.OAuthRequest;

public interface OAuthAuthorizationService {
    String getAuthorizationUrl(String callbackUrl);
    String getAccessToken(OAuthRequest request);
}
