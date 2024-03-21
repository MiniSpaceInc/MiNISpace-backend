package pl.pw.mini.minispace.dtos.oauth;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OAuthAccessTokenDto {
    private @NonNull String token;
    private @NonNull String tokenSecret;
    private @NonNull String verifier;
}
