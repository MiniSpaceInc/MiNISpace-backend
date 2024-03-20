package pl.pw.mini.minispace.controllers.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.mini.minispace.dtos.oauth.OAuthRequest;
import pl.pw.mini.minispace.services.auth.OAuthAuthorizationService;

@RequestMapping("/auth")
@RequiredArgsConstructor
@RestController
public class AuthorizationController {

    private final OAuthAuthorizationService authorizationService;

    @GetMapping("/usos")
    public ResponseEntity<String> authorizeUser() {
        return ResponseEntity.ok(authorizationService.getAuthorizationUrl("http://localhost:8080/auth/temporary"));
    }

    @PostMapping("/usos")
    public ResponseEntity<String> getAccessToken(@RequestBody OAuthRequest request) {
        return ResponseEntity.ok(authorizationService.getAccessToken(request));
    }

    @GetMapping("/temporary")
    public ResponseEntity temporaryEndpoint() {
        return ResponseEntity.ok("TEMPORARY MESSAGE - for testing purposes");
    }
}
