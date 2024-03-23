package pl.pw.mini.minispace.services.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pw.mini.minispace.EventFactory;
import pl.pw.mini.minispace.PostFactory;
import pl.pw.mini.minispace.daos.PostRepository;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityNotFoundException;
import pl.pw.mini.minispace.services.EventService;
import pl.pw.mini.minispace.validators.PostValidatorImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddPostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private EventService eventService;

    @Mock
    private PostValidatorImpl postValidator;

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
        when(postRepository.save(any(Post.class))).thenReturn(post);
        Post returnedPost = addingPostService.addPost(post, event.getId());

        // then
        assertNotNull(returnedPost);
        assertEquals(post, returnedPost);
    }

    @DisplayName("Unit test addPost - should throw EntityNotFoundException with message")
    @Test
    void addPost_SavingPostWithNotExistingEvent_ShouldThrowEntityNotFoundException() {
        // given
        post = PostFactory.createValidPost();
        event = EventFactory.createNonExistingEvent();
        String expectedMessage = String.format(MiniSpaceMessages.ENTITY_NOT_FOUND_MESSAGE.getMessage(), "Event", event.getId());

        // when
        when(eventService.findById(event.getId()))
                .thenThrow(new EntityNotFoundException(String.format(MiniSpaceMessages.ENTITY_NOT_FOUND_MESSAGE.getMessage(), "Event", event.getId())));
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> addingPostService.addPost(post, event.getId()));

        // then
        assertEquals(expectedMessage, exception.getMessage());
    }
}