package com.company.project.entities;

import jakarta.persistence.*;

@Entity
public class Model {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name= "model_id")
    private int model_id;

    @Basic
    @Column(name="model_name")
    private String model_name;

    @Basic
    @Column(name="model_slug")
    private String model_slug;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="make_id")
    private Make fk_model_make;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="type_id")
    private Type fk_model_type;

    public int getId(){ return model_id;}

    public void setId(int id){this.model_id = id;}

    public String getModel_name(){return model_name;}
    public void setModel_name (String model_name){this.model_name = model_name;}

    public String getModel_slug(){return model_slug;}
    public void setModel_id (String model_slug){this.model_slug = model_slug;}

    public Make getModel_makeid(){return fk_model_make;}

    public void setModel_makeid(Make fk_model_make){this.fk_model_make = fk_model_make;}

    public Type getModel_typeid(){return fk_model_type ;}

    public void setModel_typeid(Type fk_model_type){this.fk_model_type = fk_model_type;}
}
