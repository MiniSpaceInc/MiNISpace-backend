package pl.pw.mini.minispace.dtos;
import  pl.pw.mini.minispace.entities.Event;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public record EventDto(int id, UUID uud, String name, String Organizer, LocalDateTime date, String description) {
    public static EventDto valueFrom(Event e)
    {
        return new EventDto(e.getId(), e.getUuid(),e.getName(),e.getOrganizer(),e.getDate(),e.getDescription());
    }
    public static Event ConvertToEvent(EventDto eDto)
    {
        Event e=new Event();
        e.setId(eDto.id);
        e.setDate(eDto.date);
        e.setUuid(eDto.uud);
        e.setOrganizer(eDto.Organizer);
        e.setName(eDto.name);
        e.setDescription(eDto.description);
        return e;
    }
}
