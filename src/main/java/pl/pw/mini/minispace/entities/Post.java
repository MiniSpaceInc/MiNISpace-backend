package pl.pw.mini.minispace.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "Posts")
public class Post extends BaseEntity {

    @Column(name = "event_id")
    private Long eventId;

    @Column
    private String content;

    @Column(name = "date_posted")
    private LocalDateTime datePosted;
}
