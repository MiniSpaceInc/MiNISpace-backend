package pl.pw.mini.minispace.services.event;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.EventRepository;

import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityNotFoundException;
import pl.pw.mini.minispace.model.EventSearchDetails;


@Service
@RequiredArgsConstructor
public class SearchEventServiceImpl implements SearchEventService {

    private final EventRepository eventRepository;

    public Page<Event> getEventsPage(EventSearchDetails eventSearchDetails) {
        Pageable pageable = PageRequest.of(eventSearchDetails.getPage(), eventSearchDetails.getItemsPerPage());

        if (eventSearchDetails.getDateFrom() == null && eventSearchDetails.getDateTo() == null) {
            return eventRepository.findByNameContainsAndOrganizerContains(
                    eventSearchDetails.getName(),
                    eventSearchDetails.getOrganizer(),
                    pageable);
        }

        if (eventSearchDetails.getDateFrom() != null && eventSearchDetails.getDateTo() != null) {
            return eventRepository.findByNameContainsAndOrganizerContainsAndDateBetween(
                    eventSearchDetails.getName(),
                    eventSearchDetails.getOrganizer(),
                    eventSearchDetails.getDateFrom(),
                    eventSearchDetails.getDateTo(),
                    pageable);
        }

        if (eventSearchDetails.getDateFrom() != null) {
            return eventRepository.findByNameContainsAndOrganizerContainsAndDateAfter(
                    eventSearchDetails.getName(),
                    eventSearchDetails.getOrganizer(),
                    eventSearchDetails.getDateFrom(),
                    pageable);
        }

        return eventRepository.findByNameContainsAndOrganizerContainsAndDateBefore(
                eventSearchDetails.getName(),
                eventSearchDetails.getOrganizer(),
                eventSearchDetails.getDateTo(),
                pageable);
    }

    public Event findById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format(MiniSpaceMessages.ENTITY_NOT_FOUND_MESSAGE.getMessage(), "Event", id)));
    }
}
