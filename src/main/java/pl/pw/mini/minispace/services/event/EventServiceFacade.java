package pl.pw.mini.minispace.services.event;

import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.dtos.EventSearchDetailsDto;
import pl.pw.mini.minispace.entities.Event;

import java.util.Collection;

public interface EventServiceFacade {
    Collection<EventDto> getFilteredEvents(EventSearchDetailsDto eventSearchDetails);
    Event findById(Long id);
}
