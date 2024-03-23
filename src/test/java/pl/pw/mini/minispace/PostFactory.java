package pl.pw.mini.minispace;

import pl.pw.mini.minispace.entities.Post;

import java.time.LocalDateTime;

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
}
