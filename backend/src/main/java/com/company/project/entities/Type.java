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

    public int getId(){ return type_id;}

    public void setId(int id){this.type_id = id;}

    public String getType_name(){return type_name;}
    public void setType_name (String type_name){this.type_name = type_name;}
}
