package pl.pw.mini.minispace.services.post;

import org.springframework.data.domain.Page;
import pl.pw.mini.minispace.dtos.post.PostSearchDetailsDto;
import pl.pw.mini.minispace.entities.Post;

public interface SearchPostService {
    Post findById(Long id);
    Page<Post> searchPosts(PostSearchDetailsDto postSearchDetailsDto);
}
