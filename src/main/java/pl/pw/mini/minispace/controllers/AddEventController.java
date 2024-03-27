package pl.pw.mini.minispace.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.services.event.EventServiceFacade;

@RestController
@RequestMapping(path = "/api/event")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddEventController {

    private final EventServiceFacade eventService;

    @PostMapping("")
    public ResponseEntity<EventDto> addEvent(@RequestBody EventDto eventDto) {
        eventService.addEvent(eventDto);
        return ResponseEntity.ok(eventDto);
    }
}
