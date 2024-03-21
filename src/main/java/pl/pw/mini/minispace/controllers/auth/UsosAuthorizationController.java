package pl.pw.mini.minispace.controllers.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.mini.minispace.dtos.oauth.OAuthAccessTokenDto;
import pl.pw.mini.minispace.dtos.oauth.OAuthRequestTokenDto;
import pl.pw.mini.minispace.dtos.oauth.OAuthRequestTokenResponse;
import pl.pw.mini.minispace.services.auth.OAuthAuthorizationService;

@RequestMapping("/api/auth/usos")
@RequiredArgsConstructor
@RestController
public class UsosAuthorizationController {

    private final OAuthAuthorizationService authorizationService;

    @PostMapping("/request_token")
    public ResponseEntity<OAuthRequestTokenResponse> getRequestToken(@RequestBody OAuthRequestTokenDto requestTokenDto) {
        return ResponseEntity.ok(authorizationService.getRequestToken(requestTokenDto));
    }

    @PostMapping("/access_token")
    public ResponseEntity<String> getAccessToken(@RequestBody OAuthAccessTokenDto request) {
        return ResponseEntity.ok(authorizationService.getAccessToken(request));
    }

    @GetMapping("/temporary")
    public ResponseEntity temporaryEndpoint() {
        return ResponseEntity.ok("TEMPORARY MESSAGE - for testing purposes");
    }
}
