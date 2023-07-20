package com.company.project.entities;

import javax.persistence.*;

@Entity
public class Model {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "model_id")
    private int model_id;

    @Basic
    @Column(name = "model_name")
    private String model_name;

    @Basic
    @Column(name = "model_slug")
    private String model_slug;

    @ManyToOne(targetEntity = Make.class)
    @JoinColumn(name = "make_id", referencedColumnName = "make_id")
    private Make fk_model_make;

    @ManyToOne(targetEntity = Type.class)
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    private Type fk_model_type;

    // Getters and Setters with correct naming conventions

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getModel_slug() {
        return model_slug;
    }

    public void setModel_slug(String model_slug) {
        this.model_slug = model_slug;
    }

    public Make getFk_model_make() {
        return fk_model_make;
    }

    public void setFk_model_make(Make fk_model_make) {
        this.fk_model_make = fk_model_make;
    }

    public Type getFk_model_type() {
        return fk_model_type;
    }

    public void setFk_model_type(Type fk_model_type) {
        this.fk_model_type = fk_model_type;
    }
}