package pl.pw.mini.minispace.services.post;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pw.mini.minispace.dtos.post.PostDto;
import pl.pw.mini.minispace.dtos.post.RegisterPostDto;
import pl.pw.mini.minispace.entities.Post;
import pl.pw.mini.minispace.mappers.PostMapper;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@Service
public class PostServiceFacadeImpl implements PostServiceFacade {

    private AddPostService addPostService;
    private SearchPostService searchPostService;
    private DeletePostService deletePostService;

    private PostMapper postMapper;

    @Override
    public PostDto addPost(RegisterPostDto postDto) {
        Post post = postMapper.fromRegisterPostDto(postDto);
        if (Objects.isNull(post.getDateCreated())) {
            post.setDateCreated(LocalDateTime.now());
        }

        return postMapper.toDto(addPostService.addPost(post, postDto.getEventId()));
    }

    @Override
    public PostDto findById(Long id) {
        Post post = searchPostService.findById(id);
        return postMapper.toDto(post);
    }

    @Override
    public void deletePost(Long id) {
        deletePostService.deletePost(id);
    }
}
