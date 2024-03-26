package pl.pw.mini.minispace.mappers;

import org.mapstruct.Mapper;
import pl.pw.mini.minispace.dtos.EventSearchDetailsDto;
import pl.pw.mini.minispace.model.EventSearchDetails;

@Mapper(componentModel = "spring")
public interface EventSearchDetailsMapper {
    EventSearchDetailsDto toDto(EventSearchDetails eventSearchDetails);
    EventSearchDetails fromDto(EventSearchDetailsDto eventSearchDetailsDto);
}
