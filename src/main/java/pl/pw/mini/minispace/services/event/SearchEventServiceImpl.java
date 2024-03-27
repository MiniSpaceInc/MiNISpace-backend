package pl.pw.mini.minispace.services.event;

import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.EventRepository;
import pl.pw.mini.minispace.dtos.EventSearchDetailsDto;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityNotFoundException;
import pl.pw.mini.minispace.utils.SortUtils;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class SearchEventServiceImpl implements SearchEventService {

    private final EventRepository eventRepository;

    @Override
    public Page<Event> searchEvents(EventSearchDetailsDto searchDetailsDto) {
        Specification<Event> specification = buildSpecification(searchDetailsDto);

        Pageable pageable;
        if(searchDetailsDto.getPageable().getSort().getSortBy().length > 0) {
            Sort sort = SortUtils.buildSort(searchDetailsDto.getPageable().getSort());
            pageable = PageRequest.of(searchDetailsDto.getPageable().getPage(), searchDetailsDto.getPageable().getSize(), sort);
        } else {
            pageable = PageRequest.of(searchDetailsDto.getPageable().getPage(), searchDetailsDto.getPageable().getSize());
        }

        return eventRepository.findAll(specification, pageable);
    }

    public Event findById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format(MiniSpaceMessages.ENTITY_NOT_FOUND_MESSAGE.getMessage(), "Event", id)));
    }

    private Specification<Event> buildSpecification(EventSearchDetailsDto searchDetailsDto) {
        Specification<Event> specification = Specification.where(null);

        if (searchDetailsDto.getName() != null) {
            specification = specification.and(EventSpecifications.hasName(searchDetailsDto.getName()));
        }
        if (searchDetailsDto.getOrganizer() != null) {
            specification = specification.and(EventSpecifications.hasOrganizer(searchDetailsDto.getOrganizer()));
        }
        if (searchDetailsDto.getDateFrom() != null) {
            LocalDateTime dateFrom = searchDetailsDto.getDateFrom().toLocalDate().atStartOfDay();
            specification = specification.and(EventSpecifications.hasDateFrom(dateFrom));
        }
        if (searchDetailsDto.getDateTo() != null) {
            LocalDateTime dateTo = searchDetailsDto.getDateTo().toLocalDate().plusDays(1).atStartOfDay().minusNanos(1);
            specification = specification.and(EventSpecifications.hasDateTo(dateTo));
        }

        return specification;
    }
}
