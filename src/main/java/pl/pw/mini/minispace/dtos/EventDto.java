package pl.pw.mini.minispace.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class EventDto {
    private int id;
    private UUID uuid;
    private String name;
    private String organizer;
    private LocalDateTime date;
    private String description;
}
