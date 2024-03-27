package pl.pw.mini.minispace.daos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.pw.mini.minispace.entities.Event;
import java.time.LocalDateTime;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {

}
