package pl.pw.mini.minispace.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.EventRepository;
import pl.pw.mini.minispace.dtos.EventSearchDetails;
import java.util.Collection;
import java.util.Collections;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.mappers.EventMapper;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityNotFoundException;


@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;


    public Collection<EventDto> GetFilteredEvents(EventSearchDetails eventSearchDetails) {
        Pageable pageable = PageRequest.of(eventSearchDetails.Page(),
                eventSearchDetails.ItemsOnPage());
        return eventRepository.findByNameContainsIgnoreCaseAndOrganizerContainsIgnoreCaseAndDateBetween(
                        eventSearchDetails.Name(),
                        eventSearchDetails.Organizer(),
                        eventSearchDetails.DateFrom(),
                        eventSearchDetails.DateTo(),
                        pageable).stream()
                .map(EventMapper::ToDto).toList();
    }

    public Event findById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format(MiniSpaceMessages.ENTITY_NOT_FOUND_MESSAGE.getMessage(), "Event", id)));
    }


}
