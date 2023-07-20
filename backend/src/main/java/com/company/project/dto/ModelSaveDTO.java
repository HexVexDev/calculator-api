package com.company.project.dto;

import com.company.project.entities.Model;

import java.util.Objects;

public class ModelSaveDTO {
    private Model model;
    private Integer make_id;
    private Integer type_id;

    // No-arguments constructor
    public ModelSaveDTO() {
    }

    // Constructor with Model parameter
    public ModelSaveDTO(Model model) {
        this.model = model;
    }

    // Getter for 'model' field
    public Model getModel() {
        return model;
    }

    public Integer getMake_id() {
        return make_id;
    }

    public Integer getType_id() {
        return type_id;
    }

    // Setter for 'model' field
    public void setModel(Model model) {
        this.model = model;
    }

    public void setMake_id(Integer make_id) {
        this.make_id = make_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    // toString() method
    @Override
    public String toString() {
        return "ModelSaveDTO{" +
                "model=" + model +
                '}';
    }

    // equals() and hashCode() methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelSaveDTO that = (ModelSaveDTO) o;
        return Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }
}
