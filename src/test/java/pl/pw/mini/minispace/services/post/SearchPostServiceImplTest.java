package pl.pw.mini.minispace.services.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pw.mini.minispace.PostFactory;
import pl.pw.mini.minispace.daos.PostRepository;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SearchPostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private SearchPostServiceImpl searchPostService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Unit test findById - should return post")
    @Test
    void findById_ExistingId_ShouldReturnPost() {
        // given
        Long searchingForId = 2L;
        Post expectedPost = PostFactory.createValidPost(2L);

        // when
        when(postRepository.findById(any(Long.class))).thenReturn(Optional.of(expectedPost));
        Post foundPost = searchPostService.findById(searchingForId);

        // then
        verify(postRepository, times(1)).findById(any(Long.class));
        assertEquals(expectedPost, foundPost);
    }

    @DisplayName("Unit test findById - should throw EntityNotFoundException with message")
    @Test
    void findById_NotExistingPost_ShouldThrowEntityNotFoundException() {
        // given
        Long searchingForId = 100L;
        String expectedMessage = String.format(MiniSpaceMessages.ENTITY_NOT_FOUND_MESSAGE.getMessage(), "Post", searchingForId);

        // when
        when(postRepository.findById(searchingForId)).thenReturn(Optional.empty());
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> searchPostService.findById(searchingForId));

        // then
        assertEquals(expectedMessage, exception.getMessage());
    }
}