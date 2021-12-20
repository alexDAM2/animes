package com.example.animes.domain.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="file")
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public UUID fileid;
    public String contenttype;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    public byte[] data;

}
