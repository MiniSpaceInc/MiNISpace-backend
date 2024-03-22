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


@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final ModelMapper mapper;
    public Collection<Event> GetFilteredEvents(EventSearchDetails eventSearchDetails) {
        Pageable pageable= PageRequest.of(0,2);
        return eventRepository.findByNameContainsIgnoreCase("A",pageable);
    }
}
