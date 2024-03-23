package pl.pw.mini.minispace.validators;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.ValidationException;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostValidatorImpl implements PostValidator {
    @Override
    public void validateNewPost(Post post) {
        if (Objects.isNull(post.getContent())) {
            throw new ValidationException(String.format(MiniSpaceMessages.FIELD_IS_NULL_MESSAGE.getMessage(), "content"));
        }

        if (post.getContent().isEmpty()) {
            throw new ValidationException(String.format(MiniSpaceMessages.FIELD_IS_EMPTY_MESSAGE.getMessage(), "content"));
        }
    }

}
