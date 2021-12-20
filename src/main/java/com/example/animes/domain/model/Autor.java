package com.example.animes.domain.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID autorid;
    public String name;
    public String imageurl;

}
