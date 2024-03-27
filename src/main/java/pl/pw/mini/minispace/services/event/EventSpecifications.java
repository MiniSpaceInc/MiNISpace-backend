package pl.pw.mini.minispace.services.event;

import org.springframework.data.jpa.domain.Specification;
import pl.pw.mini.minispace.entities.Event;

import java.time.LocalDateTime;

public class EventSpecifications {

    public static Specification<Event> hasName(String name) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
    }

    public static Specification<Event> hasOrganizer(String organizer) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("organizer")), "%" + organizer.toLowerCase() + "%"));
    }

    public static Specification<Event> hasDateFrom(LocalDateTime dateFrom) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("date"), dateFrom));
    }

    public static Specification<Event> hasDateTo(LocalDateTime dateTo) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("date"), dateTo));
    }
}
