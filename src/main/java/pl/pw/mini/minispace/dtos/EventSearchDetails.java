package pl.pw.mini.minispace.dtos;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record EventSearchDetails(String Name, String Organizer, LocalDateTime Date,int Page,int ItemsOnPage,
                                 int SortBy) {

}
