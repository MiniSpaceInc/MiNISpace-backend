package pl.pw.mini.minispace.dtos;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record EventSearchDetails(String Name, String Organizer, LocalDateTime DateFrom,LocalDateTime DateTo,
                                 int Page,int ItemsOnPage, int SortBy) {

}
