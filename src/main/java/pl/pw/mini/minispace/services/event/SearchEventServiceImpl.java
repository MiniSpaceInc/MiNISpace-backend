package pl.pw.mini.minispace.services.event;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.EventRepository;
import pl.pw.mini.minispace.dtos.EventSearchDetailsDto;
import java.util.Collection;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.mappers.EventMapper;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityNotFoundException;


@Service
@RequiredArgsConstructor
public class SearchEventServiceImpl implements SearchEventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public Collection<EventDto> getFilteredEvents(EventSearchDetailsDto eventSearchDetails) {
        Pageable pageable = PageRequest.of(eventSearchDetails.page(), eventSearchDetails.itemsOnPage());

        return eventRepository.findByNameContainsIgnoreCaseAndOrganizerContainsIgnoreCaseAndDateBetween(
                        eventSearchDetails.name(),
                        eventSearchDetails.organizer(),
                        eventSearchDetails.dateFrom(),
                        eventSearchDetails.dateTo(),
                        pageable).stream()
                .map(eventMapper::toDto).toList();
    }

    public Event findById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format(MiniSpaceMessages.ENTITY_NOT_FOUND_MESSAGE.getMessage(), "Event", id)));
    }


}
