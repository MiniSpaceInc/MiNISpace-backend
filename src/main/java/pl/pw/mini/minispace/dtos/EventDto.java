package pl.pw.mini.minispace.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventDto(int id, UUID uuid, String name, String organizer, LocalDateTime date, String description) {

}
