package pl.pw.mini.minispace;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import pl.pw.mini.minispace.dtos.PageableDto;
import pl.pw.mini.minispace.dtos.SortDto;
import pl.pw.mini.minispace.dtos.post.PostSearchDetailsDto;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.entities.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostFactory {

    private static Long DEFAULT_ID = 1000L;
    private static String DEFAULT_CONTENT = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
    private static String EMPTY_CONTENT = "";
    private static LocalDateTime DEFAULT_DATETIME = LocalDateTime.now();
    private static Long DEFAULT_VERSION = 0L;

    public static Post createValidPost() {
        Post post = new Post();
        post.setId(DEFAULT_ID);
        post.setContent(DEFAULT_CONTENT);
        post.setDatePosted(DEFAULT_DATETIME);
        post.setDateCreated(DEFAULT_DATETIME);
        post.setVersion(DEFAULT_VERSION);
        return post;
    }

    public static Post createValidPost(Long id) {
        Post post = new Post();
        post.setId(id);
        post.setContent(DEFAULT_CONTENT);
        post.setDatePosted(DEFAULT_DATETIME);
        post.setDateCreated(DEFAULT_DATETIME);
        post.setVersion(DEFAULT_VERSION);
        return post;
    }

    public static Post createValidPost(Long id, String content) {
        Post post = new Post();
        post.setId(id);
        post.setContent(content);
        post.setDatePosted(DEFAULT_DATETIME);
        post.setDateCreated(DEFAULT_DATETIME);
        post.setVersion(DEFAULT_VERSION);
        return post;
    }

    public static Post createPostWithEmptyContent() {
        Post post = new Post();
        post.setId(DEFAULT_ID);
        post.setContent(EMPTY_CONTENT);
        post.setDatePosted(DEFAULT_DATETIME);
        post.setDateCreated(DEFAULT_DATETIME);
        post.setVersion(DEFAULT_VERSION);
        return post;
    }

    public static Post createPostWithNullFields() {
        Post post = new Post();
        post.setId(null);
        post.setContent(null);
        post.setDatePosted(null);
        post.setDateCreated(null);
        post.setVersion(null);
        return post;
    }

    public static PostSearchDetailsDto createPostSearchDetailsDto(int page, int size, String[] sortBy, String direction) {
        PostSearchDetailsDto searchDetailsDto = new PostSearchDetailsDto();
        PageableDto pageableDto = new PageableDto();
        SortDto sortDto = new SortDto();
        sortDto.setSortBy(sortBy);
        sortDto.setDirection(direction);
        pageableDto.setPage(page);
        pageableDto.setSize(size);
        pageableDto.setSort(sortDto);
        searchDetailsDto.setPageable(pageableDto);
        return searchDetailsDto;
    }

    public static Page<Post> createPageOfPosts(List<Post> postList) {
        return new PageImpl<>(postList);
    }

    public static List<Post> createListOfValidPostsWithEvents(Event event) {
        Post post1 = createValidPost(1L, "First post");
        Post post2 = createValidPost(2L, "Second post");
        Post post3 = createValidPost(3L, "Third post");
        post1.setEvent(event);
        post2.setEvent(event);
        post3.setEvent(event);
        return List.of(post1, post2, post3);
    }
}
