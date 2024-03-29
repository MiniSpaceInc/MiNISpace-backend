package pl.pw.mini.minispace.services.event;

import org.springframework.data.domain.Page;
import pl.pw.mini.minispace.dtos.EventSearchDetailsDto;
import pl.pw.mini.minispace.entities.Event;

public interface SearchEventService {
    Page<Event> searchEvents(EventSearchDetailsDto eventSearchDetailsDto);
    Event findById(Long id);
}
