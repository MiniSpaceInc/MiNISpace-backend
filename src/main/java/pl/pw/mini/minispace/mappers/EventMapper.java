package pl.pw.mini.minispace.mappers;

import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.entities.Event;

public  class EventMapper {
    public static EventDto ToDto(Event e)
    {
        return new EventDto(e.getId(),e.getUuid(),e.getName(),e.getOrganizer(),e.getDate(),e.getDescription());
    }
    public static Event ValueFrom(EventDto eventDto)
    {
        Event e=new Event();
        e.setId(eventDto.id());
        e.setUuid(eventDto.uuid());
        e.setOrganizer(eventDto.organizer());
        e.setDate(eventDto.date());
        e.setName(eventDto.name());
        e.setDescription(eventDto.description());
        return  e;
    }
}
