package pl.pw.mini.minispace.services.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import pl.pw.mini.minispace.EventFactory;
import pl.pw.mini.minispace.PostFactory;
import pl.pw.mini.minispace.daos.PostRepository;
import pl.pw.mini.minispace.dtos.post.PostSearchDetailsDto;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.enums.MiniSpaceMessages;
import pl.pw.mini.minispace.exceptions.EntityNotFoundException;
import pl.pw.mini.minispace.utils.SortUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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

    @DisplayName("Unit test searchPosts - should return PagedPostsWithSameEventId")
    @Test
    void searchPosts_ExistingEventAndPosts_ShouldReturnPagedPostsWithSameEventId() {
        // given
        Long searchingForEventId = 5L;
        Event event = EventFactory.createValidEvent(searchingForEventId);
        Page<Post> pagePosts = PostFactory.createPageOfPosts(PostFactory.createListOfValidPostsWithEvents(event));
        PostSearchDetailsDto searchDetailsDto = PostFactory.createPostSearchDetailsDto(0, 10, new String[]{"id"}, "ASC");
        Specification<Post> specification = searchPostService.buildSpecification(searchDetailsDto);
        Sort sort = SortUtils.buildSort(searchDetailsDto.getPageable().getSort());
        Pageable pageable = PageRequest.of(searchDetailsDto.getPageable().getPage(), searchDetailsDto.getPageable().getSize(), sort);

        // when
        when(postRepository.findAll(specification, pageable)).thenReturn(pagePosts);
        Page<Post> result = searchPostService.searchPosts(searchDetailsDto);

        // then
        assertNotNull(result);

        Long expectedEventId = event.getId();
        for (Post post : result.getContent()) {
            assertNotNull(post.getEvent());
            assertEquals(expectedEventId, post.getEvent().getId(), "All posts should have the same eventId");
        }
    }
}