package pl.pw.mini.minispace.services.event;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.dtos.EventSearchDetailsDto;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.mappers.EventMapper;

@Service
@RequiredArgsConstructor
public class EventServiceFacadeImpl implements EventServiceFacade {

    private final EventMapper eventMapper;
    private final SearchEventService searchEventService;
    private final AddEventService addEventService;

    @Override
    public Page<EventDto> searchEvents(EventSearchDetailsDto eventSearchDetails) {
        return searchEventService.searchEvents(eventSearchDetails).map(eventMapper::toDto);
    }

    @Override
    public Event findById(Long id) {
        return searchEventService.findById(id);
    }

    @Override
    public EventDto addEvent(EventDto eventDto) {
        Event event = eventMapper.fromDto(eventDto);
        return eventMapper.toDto(addEventService.addEvent(event));
    }
}
