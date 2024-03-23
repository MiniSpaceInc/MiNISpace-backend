package pl.pw.mini.minispace.services.post;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.dtos.PostDto;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.mappers.PostMapper;

@AllArgsConstructor
@Service
public class PostServiceFacadeImpl implements PostServiceFacade {

    private AddPostService addPostService;
    private SearchPostService searchPostService;

    private PostMapper postMapper;

    @Override
    public PostDto addPost(PostDto postDto) {
        Post post = addPostService.addPost(postMapper.fromDto(postDto), postDto.getEventId());
        return postMapper.toDto(post);
    }

    @Override
    public PostDto findById(Long id) {
        Post post = searchPostService.findById(id);
        return postMapper.toDto(post);
    }
}
