package com.example.animes.domain.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "anime")
public class Animes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public UUID animeid;
    public String name;
    public String description;
    public String type;
    public int year;
    public String image;


    @ManyToMany
    @JoinTable(name = "favorite", joinColumns = @JoinColumn(name = "animeid"), inverseJoinColumns = @JoinColumn(name = "userid"))
    public Set<Animes> favorites;
}
