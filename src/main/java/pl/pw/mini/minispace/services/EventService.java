package pl.pw.mini.minispace.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.EventRepository;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event findById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format(MiniSpaceMessages.ENTITY_NOT_FOUND_MESSAGE.getMessage(), "Event", id)));
    }

}
