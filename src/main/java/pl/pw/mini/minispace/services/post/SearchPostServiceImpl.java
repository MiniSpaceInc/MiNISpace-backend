package pl.pw.mini.minispace.services.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.PostRepository;
import pl.pw.mini.minispace.entities.Post;

@Slf4j
@RequiredArgsConstructor
@Service
public class SearchPostServiceImpl implements SearchPostService {

    private final PostRepository postRepository;

    @Override
    public Post findById(Long id) {
        throw new UnsupportedOperationException();
    }
}
