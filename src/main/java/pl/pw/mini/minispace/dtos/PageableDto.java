package pl.pw.mini.minispace.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableDto {
    private int pageNumber;
    private int itemsOnPage;
}
