package pl.pw.mini.minispace.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.dtos.EventSearchDetailsDto;
import pl.pw.mini.minispace.services.event.EventServiceFacade;

import java.util.Collection;

@RestController
@RequestMapping(path="/api/events")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventController {

    private final EventServiceFacade eventService;

    @PostMapping("")
    public ResponseEntity<Collection<EventDto>> getEvents(@RequestBody EventSearchDetailsDto eventSearchDetails) {
        var eventDtos = eventService.getFilteredEvents(eventSearchDetails);
        return ResponseEntity.ok(eventDtos);
    }
}
