package pl.pw.mini.minispace.services.post;

import pl.pw.mini.minispace.entities.Post;

public interface AddPostService {
    Post addPost(Post post, Long eventId);
}
