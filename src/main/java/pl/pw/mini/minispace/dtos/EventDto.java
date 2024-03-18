package pl.pw.mini.minispace.dtos;
import  pl.pw.mini.minispace.entities.Event;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventDto(int id, UUID uud, String name, String Organizer, LocalDateTime date, String description) {
    public static EventDto valueFrom(Event event) {
        return new EventDto(event.getId(), event.getUuid(), event.getName(), event.getOrganizer(), event.getDate(), event.getDescription());
    }
    public static Event convertToEvent(EventDto eventDto) {
        Event event = new Event();
        event.setId(eventDto.id);
        event.setDate(eventDto.date);
        event.setUuid(eventDto.uud);
        event.setOrganizer(eventDto.Organizer);
        event.setName(eventDto.name);
        event.setDescription(eventDto.description);
        return event;
    }
}
