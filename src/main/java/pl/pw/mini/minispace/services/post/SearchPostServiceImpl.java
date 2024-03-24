package pl.pw.mini.minispace.services.post;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.PostRepository;
import pl.pw.mini.minispace.dtos.post.PostSearchDetailsDto;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityNotFoundException;

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
    public Page<Post> searchPosts(PostSearchDetailsDto postSearchDetailsDto) {
        throw new UnsupportedOperationException();
    }
}
