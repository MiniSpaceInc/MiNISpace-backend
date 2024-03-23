package pl.pw.mini.minispace.services.post;

import pl.pw.mini.minispace.dtos.post.PostDto;
import pl.pw.mini.minispace.dtos.post.RegisterPostDto;

public interface PostServiceFacade {
    PostDto addPost(RegisterPostDto registerPostDto);

    PostDto findById(Long id);

    void deletePost(Long id);
}
