package pl.pw.mini.minispace.mappers;

import org.mapstruct.Mapper;
import pl.pw.mini.minispace.dtos.PostDto;
import pl.pw.mini.minispace.entities.Post;

@Mapper
public interface PostMapper {

    PostDto toDto(Post post);

    Post fromDto(PostDto post);
}
