package pl.pw.mini.minispace.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
