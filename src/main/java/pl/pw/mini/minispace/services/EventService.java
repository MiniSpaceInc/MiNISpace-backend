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


@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Collection<EventDto> GetFilteredEvents(EventSearchDetails eventSearchDetails) {
        Pageable pageable= PageRequest.of(eventSearchDetails.Page(),
                eventSearchDetails.ItemsOnPage());
        String order;
        switch (eventSearchDetails.SortBy())
        {
            case 0:
                order="";
                break;
            default:
                order="A";
        }
        System.out.println(order);
        return eventRepository.findAll(pageable).stream()
                .map(EventMapper::ToDto).toList();
    }
}
