package com.company.project.entities;

import jakarta.persistence.*;

@Entity
public class Type {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="type_id")
    private int type_id;

    @Basic
    @Column(name="name")
    private String type_name;
}
