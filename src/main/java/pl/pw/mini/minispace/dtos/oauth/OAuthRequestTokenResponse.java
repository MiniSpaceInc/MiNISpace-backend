package pl.pw.mini.minispace.dtos.oauth;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OAuthRequestTokenResponse {
    private @NonNull String requestToken;
    private @NonNull String requestTokenSecret;
    private @NonNull String redirectUrl;
}
