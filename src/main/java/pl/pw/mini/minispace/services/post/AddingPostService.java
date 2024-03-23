package pl.pw.mini.minispace.services.post;

import pl.pw.mini.minispace.dtos.PostDto;

public interface AddingPostService {
    void addPost(PostDto postDto, Long eventId);
}
