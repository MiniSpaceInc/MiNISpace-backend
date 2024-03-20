package pl.pw.mini.minispace.dtos.oauth;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OAuthRequest {
    private @NonNull String token;
    private @NonNull String verifier;
    private @NonNull String userSecret;
}
