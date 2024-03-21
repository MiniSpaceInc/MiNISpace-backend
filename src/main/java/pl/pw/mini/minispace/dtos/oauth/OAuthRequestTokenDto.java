package pl.pw.mini.minispace.dtos.oauth;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OAuthRequestTokenDto {
    private @NonNull String callbackUrl;
}
