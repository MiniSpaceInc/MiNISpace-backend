package pl.pw.mini.minispace.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pw.mini.minispace.PostFactory;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostValidatorImplTest {

    @InjectMocks
    private PostValidatorImpl postValidator;

    private Post post;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Unit test validateNewPost - should not throw any exception")
    @Test
    void validateNewPost_ValidPost_ShouldNotThrowException() {
        // given
        post = PostFactory.createValidPost();

        // when
        ValidationException exception = assertThrows(ValidationException.class, () -> postValidator.validateNewPost(post));

        // then
        assertNull(exception);
    }

    @DisplayName("Unit test validateNewPost with empty content - should throw ValidationException with message")
    @Test
    void validateNewPost_EmptyContent_ShouldThrowValidationException() {
        // given
        post = PostFactory.createPostWithEmptyContent();
        String expectedMessage = String.format(MiniSpaceMessages.FIELD_IS_EMPTY_MESSAGE.getMessage(), "content");

        // when
        ValidationException exception = assertThrows(ValidationException.class, () -> postValidator.validateNewPost(post));

        // then
        assertEquals(expectedMessage, exception.getMessage());
    }

    @DisplayName("Unit test validateNewPost with null content - should throw ValidationException with message")
    @Test
    void validateNewPost_NullContent_ShouldThrowValidationException() {
        // given
        post = PostFactory.createPostWithNullFields();
        String expectedMessage = String.format(MiniSpaceMessages.FIELD_IS_NULL_MESSAGE.getMessage(), "content");

        // when
        ValidationException exception = assertThrows(ValidationException.class, () -> postValidator.validateNewPost(post));

        // then
        assertEquals(expectedMessage, exception.getMessage());
    }
}