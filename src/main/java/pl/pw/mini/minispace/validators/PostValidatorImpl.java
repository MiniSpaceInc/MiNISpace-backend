package pl.pw.mini.minispace.validators;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.entities.Post;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostValidatorImpl implements PostValidator {
    @Override
    public void validateNewPost(Post post) {
        throw new UnsupportedOperationException();
    }
}
