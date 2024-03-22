package pl.pw.mini.minispace.daos;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.pw.mini.minispace.entities.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {
    List<Event> findByNameContainsIgnoreCase(String matchName, Pageable pageable);
}
