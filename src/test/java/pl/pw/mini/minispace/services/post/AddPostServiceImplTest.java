package pl.pw.mini.minispace.services.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pw.mini.minispace.EventFactory;
import pl.pw.mini.minispace.PostFactory;
import pl.pw.mini.minispace.daos.PostRepository;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityAlreadyExistsException;

@ExtendWith(MockitoExtension.class)
class AddPostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private AddPostServiceImpl addingPostService;

    private Post post;
    private Event event;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Unit test addPost - should save one entity")
    @Test
    void addPost_ValidContentAndUniquePost_ShouldSaveOneEntity() {
        // given
        post = PostFactory.createValidPost();
        event = EventFactory.createValidEvent();

        // when
        addingPostService.addPost(post, event.getId());

        // then
        verify(postRepository, times(1)).save(post);
    }

    @DisplayName("Unit test addPost - should throw EntityAlreadyExistsException with message")
    @Test
    void addPost_SavingIdenticalPost_ShouldThrowEntityAlreadyExistsException() {
        // given
        post = PostFactory.createValidPost();
        event = EventFactory.createValidEvent();
        String expectedMessage = String.format(MiniSpaceMessages.ENTITY_ALREADY_EXISTS_MESSAGE.getMessage(), "post", post.getId());

        // when
        addingPostService.addPost(post, event.getId());
        EntityAlreadyExistsException exception = assertThrows(EntityAlreadyExistsException.class, () -> addingPostService.addPost(post, event.getId()));

        // then
        assertEquals(expectedMessage, exception.getMessage());
    }

    @DisplayName("Unit test addPost - should throw EntityAlreadyExistsException with message")
    @Test
    void addPost_SavingPostWithNotExistingEvent_ShouldThrowEntityAlreadyExistsException() {
        // given
        post = PostFactory.createValidPost();
        event = EventFactory.createNonExistingEvent();
        String expectedMessage = String.format(MiniSpaceMessages.ENTITY_NOT_FOUND_MESSAGE.getMessage(), "event", event.getId());

        // when
        EntityAlreadyExistsException exception = assertThrows(EntityAlreadyExistsException.class, () -> addingPostService.addPost(post, event.getId()));

        // then
        assertEquals(expectedMessage, exception.getMessage());
    }

    @DisplayName("Unit test addPost - should throw EntityAlreadyExistsException with message")
    @Test
    void addPost_SavingIdenticalPost_ShouldThrowEntityAlreadyExistsExceptionWithProperMessage() {
        // given
        post = PostFactory.createValidPost();
        event = EventFactory.createValidEvent();
        String expectedMessage = String.format(MiniSpaceMessages.ENTITY_ALREADY_EXISTS_MESSAGE.getMessage(), post.getClass().getSimpleName(), post.getId());

        // when
        addingPostService.addPost(post, event.getId());
        EntityAlreadyExistsException exception = assertThrows(EntityAlreadyExistsException.class, () -> addingPostService.addPost(post, event.getId()));

        // then
        assertEquals(expectedMessage, exception.getMessage());
    }
}