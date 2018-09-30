package fr.istic.ccn.taa.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sport {

    private Long id;
    private String name;
    private String level;
    private List<Person> persons;
    private List<Localisation> localisations;

    public Sport() {
        super();
    }

    public Sport(String name, String level) {
        this.name = name;
        this.level = level;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @ManyToMany(mappedBy = "sports", cascade = CascadeType.PERSIST)
    @JsonIgnore
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @ManyToMany(mappedBy = "sports", cascade = CascadeType.PERSIST)
    @JsonIgnore
    public List<Localisation> getLocalisations() {
        return localisations;
    }

    public void setLocalisations(List<Localisation> localisations) {
        this.localisations = localisations;
    }
}
