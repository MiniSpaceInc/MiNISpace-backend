package pl.pw.mini.minispace.services.post;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.daos.PostRepository;

@AllArgsConstructor
@Service
public class DeletePostServiceImpl implements DeletePostService {

    private PostRepository postRepository;

    @Override
    public void deletePost(Long id) {
        throw new UnsupportedOperationException();
    }
}
