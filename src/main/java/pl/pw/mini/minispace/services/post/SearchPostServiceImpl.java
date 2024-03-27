package pl.pw.mini.minispace.services.post;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.PostRepository;
import pl.pw.mini.minispace.dtos.SortDto;
import pl.pw.mini.minispace.dtos.post.PostSearchDetailsDto;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityNotFoundException;
import pl.pw.mini.minispace.utils.SortUtils;

@Slf4j
@AllArgsConstructor
@Service
public class SearchPostServiceImpl implements SearchPostService {

    private PostRepository postRepository;

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(MiniSpaceMessages.ENTITY_NOT_FOUND_MESSAGE.getMessage(), "Post", id)));
    }

    @Override
    public Page<Post> searchPosts(PostSearchDetailsDto searchDetailsDto) {
        Specification<Post> specification = buildSpecification(searchDetailsDto);
        Sort sort = SortUtils.buildSort(searchDetailsDto.getPageable().getSort());
        Pageable pageable = PageRequest.of(searchDetailsDto.getPageable().getPage(), searchDetailsDto.getPageable().getSize(), sort);
        return postRepository.findAll(specification, pageable);
    }

    public Specification<Post> buildSpecification(PostSearchDetailsDto searchDetailsDto) {
        Specification<Post> specification = Specification.where(null);

        if (searchDetailsDto.getEventId() != null) {
            specification = specification.and(PostSpecifications.hasEqualEventId(searchDetailsDto.getEventId()));
        }
        if (searchDetailsDto.getDateFrom() != null) {
            specification = specification.and(PostSpecifications.hasDatePostedFrom(searchDetailsDto.getDateFrom()));
        }
        if (searchDetailsDto.getDateTo() != null) {
            specification = specification.and(PostSpecifications.hasDatePostedTo(searchDetailsDto.getDateTo()));
        }

        return specification;
    }

}
