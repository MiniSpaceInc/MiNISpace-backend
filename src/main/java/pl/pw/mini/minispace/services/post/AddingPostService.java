package pl.pw.mini.minispace.services.post;

import pl.pw.mini.minispace.entities.Post;

public interface AddingPostService {
    void addPost(Post post, Long eventId);
}
