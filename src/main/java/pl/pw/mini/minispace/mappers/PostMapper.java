package pl.pw.mini.minispace.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;
import pl.pw.mini.minispace.dtos.post.PostDto;
import pl.pw.mini.minispace.dtos.post.RegisterPostDto;
import pl.pw.mini.minispace.entities.Event;
import pl.pw.mini.minispace.entities.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "event", target = "eventId", qualifiedByName = "mapEventId")
    PostDto toDto(Post post);

    Post fromDto(PostDto post);

    Post fromRegisterPostDto(RegisterPostDto registerPostDto);

    @Named("mapEventId")
    default Long mapEventId(Event event) {
        return event != null ? event.getId() : null;
    }
}
