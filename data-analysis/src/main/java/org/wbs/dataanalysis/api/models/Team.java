package org.wbs.dataanalysis.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Team {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    private String Name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    private int id;

}
