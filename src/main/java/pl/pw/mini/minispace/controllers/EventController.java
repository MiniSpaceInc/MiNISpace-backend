package pl.pw.mini.minispace.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.dtos.EventSearchDetailsDto;
import pl.pw.mini.minispace.services.event.EventServiceFacade;

@RestController
@RequestMapping(path="/api")
@RequiredArgsConstructor
public class EventController {

    private final EventServiceFacade eventService;

    @PostMapping("/events")
    public ResponseEntity<Page<EventDto>> getEvents(@RequestBody EventSearchDetailsDto eventSearchDetails) {
        var eventDtos = eventService.getEventsPage(eventSearchDetails);
        return ResponseEntity.ok(eventDtos);
    }

    @PostMapping("event")
    public ResponseEntity<EventDto> addEvent(@RequestBody EventDto eventDto) {
        eventDto = eventService.addEvent(eventDto);
        return ResponseEntity.ok(eventDto);
    }
}
