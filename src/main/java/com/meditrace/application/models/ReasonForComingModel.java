package com.meditrace.application.models;

import java.util.List;

public class ReasonForComingModel {

    private String name;
    private String description;

    public ReasonForComingModel() {
    }

    public ReasonForComingModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}