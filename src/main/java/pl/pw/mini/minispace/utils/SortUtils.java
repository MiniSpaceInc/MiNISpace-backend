package pl.pw.mini.minispace.utils;

import org.springframework.data.domain.Sort;
import pl.pw.mini.minispace.dtos.SortDto;

public class SortUtils {

    public static Sort buildSort(SortDto sortDto) {
        return Sort.by(sortDto
                        .getDirection()
                        .equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortDto.getSortBy());
    }
}
