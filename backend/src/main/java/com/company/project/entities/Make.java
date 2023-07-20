package com.company.project.entities;

import javax.persistence.*;

@Entity
public class Make {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="make_id")
    private int make_id;

    @Basic
    @Column(name= "make_name")
    private String make_name;

    @Basic
    @Column(name = "make_slug")
    private String make_slug;

    public int getId(){ return make_id;}

    public void setId(int id){this.make_id = id;}

    public String getMake_name(){return make_name;}
    public void setMake_name (String make_name){this.make_name = make_name;}

    public String getMake_slug(){return make_slug;}
    public void setMake_slug (String make_slug){this.make_slug = make_slug;}


}
