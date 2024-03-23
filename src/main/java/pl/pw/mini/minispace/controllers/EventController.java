package pl.pw.mini.minispace.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pw.mini.minispace.dtos.EventDto;
import pl.pw.mini.minispace.dtos.EventSearchDetails;
import pl.pw.mini.minispace.services.EventService;

import java.util.Collection;

@RestController
@RequestMapping(path="/events")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventController {

    private final EventService eventService;
    @GetMapping("")
    public ResponseEntity<Collection<EventDto>> GetEvents(@RequestBody EventSearchDetails eventSearchDetails) {
        var eventDtos= eventService.GetFilteredEvents(eventSearchDetails);
        return ResponseEntity.ok(eventDtos);
    }
}
