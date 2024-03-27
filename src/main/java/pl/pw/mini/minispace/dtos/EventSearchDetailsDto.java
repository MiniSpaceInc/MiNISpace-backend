package pl.pw.mini.minispace.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventSearchDetailsDto {
    private String name;
    private String organizer;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private int page;
    private int itemsPerPage;
    private int sortBy;
}
