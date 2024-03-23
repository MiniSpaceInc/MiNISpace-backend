package pl.pw.mini.minispace.dtos.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {
    private Long id;
    private Long eventId;
    private String content;
    private LocalDateTime datePosted;
}
