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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeletePostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private DeletePostServiceImpl deletePostService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Unit test deletePost - should delete post by ID once")
    @Test
    void deletePost_WithValidPostId_ShouldDeleteOneEntity() {
        // given
        Long postId = 1L;
        Post post = PostFactory.createValidPost(postId);

        // when
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));
        deletePostService.deletePost(postId);

        // then
        verify(postRepository, times(1)).deleteById(postId);
    }

    @DisplayName("Unit test deletePost - should throw EntityNotFoundException with message")
    @Test
    void deletePost_WithNonExistingPostId_ShouldThrowEntityNotFoundException() {
        // given
        Long postId = 1L;

        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        // when
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> deletePostService.deletePost(postId));

        // then
        assertEquals(String.format(MiniSpaceMessages.ENTITY_NOT_FOUND_MESSAGE.getMessage(), "Post", postId), exception.getMessage());
        verify(postRepository, never()).deleteById(anyLong());
    }
}