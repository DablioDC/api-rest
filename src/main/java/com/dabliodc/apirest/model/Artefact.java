package com.dabliodc.apirest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Artefact {
    @Id
    private String id;

    private String date;
    private String name;
    private String state;
    private String bravery;
    private String low;

    public Artefact(String id, String date, String name, String state, String bravery, String low) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.state = state;
        this.bravery = bravery;
        this.low = low;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBravery() {
        return bravery;
    }

    public void setBravery(String bravery) {
        this.bravery = bravery;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    @Override
    public String toString() {
        return "Artefact{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", bravery='" + bravery + '\'' +
                ", low='" + low + '\'' +
                '}';
    }
}
