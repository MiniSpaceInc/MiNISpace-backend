package pl.pw.mini.minispace.services.post;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.PostRepository;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.services.event.SearchEventServiceImpl;
import pl.pw.mini.minispace.validators.PostValidator;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
@Service
public class AddPostServiceImpl implements AddPostService {

    private PostRepository postRepository;
    private SearchEventServiceImpl eventService;
    private PostValidator postValidator;

    @Transactional
    @Override
    public Post addPost(Post post, Long eventId) {
        log.info("Adding new post...");
        Event event = eventService.findById(eventId);

        if (Objects.isNull(post.getDatePosted())) {
            post.setDatePosted(LocalDateTime.now());
        }
        if (Objects.isNull(post.getDateCreated())) {
            post.setDateCreated(LocalDateTime.now());
        }

        postValidator.validateNewPost(post);

        post.setEvent(event);
        Post addedPost = postRepository.save(post);
        log.info("Added new post");
        return addedPost;
    }
}
