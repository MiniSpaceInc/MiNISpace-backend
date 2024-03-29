package pl.pw.mini.minispace.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "Events")
public class Event extends BaseEntity {

    @Generated
    @Column(insertable = false)
    private UUID uuid;

    @Column
    private String name;

    @Column
    private String organizer;

    @Column
    private LocalDateTime date;

    @Column
    private String description;

    @OneToMany(mappedBy = "event", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Post> posts;
}
