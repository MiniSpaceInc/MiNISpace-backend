package pl.pw.mini.minispace.daos;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.pw.mini.minispace.entities.Event;
import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
  
    List<Event> findByNameContainsIgnoreCaseAndOrganizerContainsIgnoreCaseAndDateBetween(String matchName,String matchOrganizer
            ,LocalDateTime from,LocalDateTime to, Pageable pageable);
}
