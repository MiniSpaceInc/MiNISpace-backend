package pl.pw.mini.minispace.dtos;

import java.time.LocalDateTime;

public record EventSearchDetailsDto(String name, String organizer, LocalDateTime dateFrom, LocalDateTime dateTo,
                                    int page, int itemsOnPage, int sortBy) {

}
