package pl.pw.mini.minispace.services.post;

import pl.pw.mini.minispace.dtos.PostDto;

public interface PostServiceFacade {
    PostDto addPost(PostDto postDto);

    PostDto findById(Long id);

    void deletePost(Long id);
}
