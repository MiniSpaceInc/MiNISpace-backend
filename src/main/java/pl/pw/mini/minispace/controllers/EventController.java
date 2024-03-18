package pl.pw.mini.minispace.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pw.mini.minispace.services.EventService;

@RestController
@RequestMapping(path="/events")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventController {

    private final EventService eventService;

}
