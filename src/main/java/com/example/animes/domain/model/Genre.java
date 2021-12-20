package com.example.animes.domain.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID genreid;
    public String label;
}
