package pl.pw.mini.minispace.services.event;

import lombok.RequiredArgsConstructor;
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


@Service
@RequiredArgsConstructor
public class SearchEventServiceImpl implements SearchEventService {

    private final EventRepository eventRepository;

    @Override
    public Page<Event> searchEvents(EventSearchDetailsDto searchDetailsDto) {
        Specification<Event> specification = buildSpecification(searchDetailsDto);
        Sort sort = SortUtils.buildSort(searchDetailsDto.getPageable().getSort());
        Pageable pageable = PageRequest.of(searchDetailsDto.getPageable().getPage(), searchDetailsDto.getPageable().getSize(), sort);
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
            specification = specification.and(EventSpecifications.hasEqualName(searchDetailsDto.getName()));
        }
        if (searchDetailsDto.getDateFrom() != null) {
            specification = specification.and(EventSpecifications.hasDateFrom(searchDetailsDto.getDateFrom()));
        }
        if (searchDetailsDto.getDateTo() != null) {
            specification = specification.and(EventSpecifications.hasDateTo(searchDetailsDto.getDateTo()));
        }

        return specification;
    }
}
