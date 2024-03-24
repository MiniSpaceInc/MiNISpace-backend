package pl.pw.mini.minispace.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortDto {
    private String[] sortBy;
    private String direction;
}
