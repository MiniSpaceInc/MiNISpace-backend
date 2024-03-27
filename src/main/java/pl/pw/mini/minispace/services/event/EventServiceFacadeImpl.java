package pl.pw.mini.minispace.services.event;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.dtos.EventSearchDetailsDto;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.mappers.EventMapper;
import pl.pw.mini.minispace.mappers.EventSearchDetailsMapper;

@Service
@RequiredArgsConstructor
public class EventServiceFacadeImpl implements EventServiceFacade {

    private final EventMapper eventMapper;
    private final EventSearchDetailsMapper eventSearchDetailsMapper;
    private final SearchEventService searchEventService;
    private final EventMapper eventMapper;

    @Override
    public Page<EventDto> getEventsPage(EventSearchDetailsDto eventSearchDetails) {
        var mappedSearchDetails = eventSearchDetailsMapper.fromDto(eventSearchDetails);
        var page = searchEventService.getEventsPage(mappedSearchDetails);
        return page.map(eventMapper::toDto);
    }

    @Override
    public Event findById(Long id) {
        return searchEventService.findById(id);
    }

    @Override
    public void addEvent(EventDto eventDto) {
        Event event = eventMapper.fromDto(eventDto);
        eventRepository.save(event);
    }
}
