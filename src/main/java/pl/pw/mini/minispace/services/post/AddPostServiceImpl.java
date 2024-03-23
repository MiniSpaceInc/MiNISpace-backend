package pl.pw.mini.minispace.services.post;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.PostRepository;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityAlreadyExistsException;
import pl.pw.mini.minispace.services.EventService;
import pl.pw.mini.minispace.validators.PostValidator;

@Slf4j
@AllArgsConstructor
@Service
public class AddPostServiceImpl implements AddPostService {

    private PostRepository postRepository;
    private EventService eventService;
    private PostValidator postValidator;

    @Transactional
    @Override
    public Post addPost(Post post, Long eventId) {
        log.info("Adding new post...");
        checkIfPostExists(post.getId());
        Event event = eventService.findById(eventId);

        postValidator.validateNewPost(post);

        post.setEvent(event);
        Post addedPost = postRepository.save(post);
        log.info("Added new post");
        return addedPost;
    }

    private void checkIfPostExists(Long postId) {
        if (postRepository.findById(postId).isPresent()) {
            throw new EntityAlreadyExistsException(String.format(MiniSpaceMessages.ENTITY_ALREADY_EXISTS_MESSAGE.getMessage(),
                    "Post", postId));
        }
    }
}
