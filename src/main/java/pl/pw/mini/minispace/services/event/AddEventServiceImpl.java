package pl.pw.mini.minispace.services.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.EventRepository;
import pl.pw.mini.minispace.entities.Event;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AddEventServiceImpl implements AddEventService{
    private final EventRepository eventRepository;

    @Override
    public Event addEvent(Event event) {
        if (Objects.isNull(event.getDate())) {
            event.setDate(LocalDateTime.now());
        }
        return eventRepository.save(event);
    }
}
