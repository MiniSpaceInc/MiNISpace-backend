package pl.pw.mini.minispace.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "Posts")
public class Post extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    @Column
    private String content;

    @Column(name = "date_posted")
    private LocalDateTime datePosted;
}
