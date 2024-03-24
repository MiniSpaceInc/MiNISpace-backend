package pl.pw.mini.minispace.services.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.dtos.EventSearchDetailsDto;
import pl.pw.mini.minispace.entities.Event;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class EventServiceFacadeImpl implements EventServiceFacade {

    private final SearchEventService searchEventService;

    @Override
    public Collection<EventDto> getFilteredEvents(EventSearchDetailsDto eventSearchDetails) {
        return searchEventService.getFilteredEvents(eventSearchDetails);
    }

    @Override
    public Event findById(Long id) {
        return searchEventService.findById(id);
    }
}
