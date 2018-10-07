package fr.istic.ccn.taa.project.model;

import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@Entity
public class Level {

    private Long id;
    private String name;

    public Level() {
    }

    public Level(String name) {
        this.name = name;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
