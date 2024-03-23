package pl.pw.mini.minispace.mappers;

import org.mapstruct.Mapper;
import pl.pw.mini.minispace.dtos.post.PostDto;
import pl.pw.mini.minispace.dtos.post.RegisterPostDto;
import pl.pw.mini.minispace.entities.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDto toDto(Post post);

    Post fromDto(PostDto post);

    Post fromRegisterPostDto(RegisterPostDto registerPostDto);
}
