package pl.pw.mini.minispace.dtos;

import java.time.LocalDateTime;

public record PostDto(Long id, String content, LocalDateTime datePosted) {
}
