package pl.pw.mini.minispace.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String uuid;
    @Column
    private String name;
    @Column
    private String organizer;
    @Column
    private LocalDateTime date;
    @Column
        private String description;

}
