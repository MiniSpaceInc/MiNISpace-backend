package pl.pw.mini.minispace.services.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.PostRepository;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.services.EventService;

@Slf4j
@RequiredArgsConstructor
@Service
public class AddPostServiceImpl implements AddPostService {

    private final PostRepository postRepository;

    private final EventService eventService;

    @Override
    public void addPost(Post post, Long eventId) {

        Event event = eventService.findById(eventId);
    }
}
