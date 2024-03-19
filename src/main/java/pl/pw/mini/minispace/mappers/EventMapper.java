package pl.pw.mini.minispace.mappers;

import org.mapstruct.Mapper;
import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.entities.Event;

@Mapper
public interface EventMapper {
    EventDto toDto(Event event);

    Event fromDto(EventDto eventDto);
}
