package pl.pw.mini.minispace.dtos.post;

import lombok.Getter;
import lombok.Setter;
import pl.pw.mini.minispace.dtos.PageableDto;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostSearchDetailsDto {
    private Long eventId;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private PageableDto pageable;
}
