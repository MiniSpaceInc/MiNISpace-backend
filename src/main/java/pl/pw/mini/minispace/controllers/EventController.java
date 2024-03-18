package pl.pw.mini.minispace.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.services.EventService;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path="/events")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventController {

    private final EventService eventService;
    @Bean
    public void Test2()
    {
        System.out.println("123");
        Event e=new Event();
        e.setDescription("Lorem Lipsum");
        e.setName("ABC");
        e.setOrganizer("WRS");
        //e.setUuid(UUID.randomUUID());
        e.setDate(LocalDateTime.now());
        eventService.SaveEvent(e);
    }
    @GetMapping("")
    public ResponseEntity<EventDto> Test()
    {
        var evs=eventService.GetEvents(1);
        Event e=(Event) evs.toArray()[0];
        return  ResponseEntity.ok(EventDto.valueFrom(e));
    }

}
