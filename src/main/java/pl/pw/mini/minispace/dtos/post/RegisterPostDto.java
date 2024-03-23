package pl.pw.mini.minispace.dtos.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RegisterPostDto {
    private Long eventId;
    private String content;
    private LocalDateTime datePosted;
    private LocalDateTime dateCreated;
}
