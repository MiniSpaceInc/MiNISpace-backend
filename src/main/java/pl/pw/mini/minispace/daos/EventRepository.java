package pl.pw.mini.minispace.daos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.pw.mini.minispace.entities.Event;
import java.time.LocalDateTime;

public interface EventRepository extends JpaRepository<Event, Long> {
    Page<Event> findByNameContainsAndOrganizerContains(String matchName,
                                                       String matchOrganizer,
                                                       Pageable pageable);

    Page<Event> findByNameContainsAndOrganizerContainsAndDateAfter(String matchName,
                                                                  String matchOrganizer,
                                                                  LocalDateTime from,
                                                                  Pageable pageable);

    Page<Event> findByNameContainsAndOrganizerContainsAndDateBefore(String matchName,
                                                                   String matchOrganizer,
                                                                   LocalDateTime to,
                                                                   Pageable pageable);

    Page<Event> findByNameContainsAndOrganizerContainsAndDateBetween(String matchName,
                                                                     String matchOrganizer,
                                                                     LocalDateTime from,
                                                                     LocalDateTime to,
                                                                     Pageable pageable);
}
