package pl.pw.mini.minispace.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.EventRepository;
import pl.pw.mini.minispace.entities.Event;

import java.util.Collection;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final int PAGE_SIZE=10;
    public EventService(EventRepository eventRepository) {
        this.eventRepository=eventRepository;
    }
    public Collection<Event> GetEvents(int page) {
        Pageable pageable= PageRequest.of(page,PAGE_SIZE);
        return eventRepository.findAll();
    }
    public Event SaveEvent(Event e){
        return eventRepository.save(e);
    }

}
