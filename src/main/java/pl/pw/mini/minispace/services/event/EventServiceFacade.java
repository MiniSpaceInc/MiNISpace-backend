package pl.pw.mini.minispace.services.event;

import org.springframework.data.domain.Page;
import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.dtos.EventSearchDetailsDto;
import pl.pw.mini.minispace.entities.Event;

public interface EventServiceFacade {
    Page<EventDto> getEventsPage(EventSearchDetailsDto eventSearchDetails);
    Event findById(Long id);
    void addEvent(EventDto eventDto);
}
