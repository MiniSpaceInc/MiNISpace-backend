package pl.pw.mini.minispace.daos;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.pw.mini.minispace.entities.Event;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event,Integer> {
    Collection<Event> findAllByIdAndDateAndName(int id, LocalDateTime date,String name);
    
}
