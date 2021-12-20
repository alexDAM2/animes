package com.example.animes.domain.model;

import com.sun.tools.javac.jvm.Gen;
import sun.security.util.Password;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name ="user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public UUID userid;
    public String username;
    public String password;
    public boolean enabled;

    @ManyToMany(mappedBy = "favorite")
    Set<Animes> favorites;
}
