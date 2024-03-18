package pl.pw.mini.minispace.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.EventRepository;
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

}
