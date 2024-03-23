package pl.pw.mini.minispace.services.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.PostRepository;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityNotFoundException;

@Slf4j
@RequiredArgsConstructor
@Service
public class SearchPostServiceImpl implements SearchPostService {

    private final PostRepository postRepository;

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(MiniSpaceMessages.ENTITY_NOT_FOUND_MESSAGE.getMessage(), "Post", id)));
    }
}
