package pl.pw.mini.minispace.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "Events")
public class Event extends BaseEntity {

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

}
