package pl.pw.mini.minispace.services.auth;

import pl.pw.mini.minispace.dtos.oauth.OAuthAccessTokenDto;
import pl.pw.mini.minispace.dtos.oauth.OAuthRequestTokenDto;
import pl.pw.mini.minispace.dtos.oauth.OAuthRequestTokenResponse;

public interface OAuthAuthorizationService {
    OAuthRequestTokenResponse getRequestToken(OAuthRequestTokenDto oAuthRequestTokenDto);
    String getAccessToken(OAuthAccessTokenDto oAuthAccessTokenDto);
}
