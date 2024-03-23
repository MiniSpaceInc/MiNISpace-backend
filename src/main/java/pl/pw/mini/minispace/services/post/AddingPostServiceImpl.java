package pl.pw.mini.minispace.services.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.EventRepository;
import pl.pw.mini.minispace.daos.PostRepository;
import pl.pw.mini.minispace.entities.Post;

@Slf4j
@RequiredArgsConstructor
@Service
public class AddingPostServiceImpl implements AddingPostService {

    private final PostRepository postRepository;

    private final EventRepository eventRepository;

    @Override
    public void addPost(Post post, Long eventId) {
        throw new UnsupportedOperationException();
    }
}
