package pl.pw.mini.minispace.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pw.mini.minispace.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
