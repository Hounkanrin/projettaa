package fr.istic.ccn.taa.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sport {

    private Long id;
    private String name;
    private String level1;
    private String level2;
    private  String level3;
    private List<Person> persons;
    private List<Localisation> localisations;

    public Sport() {
        super();
    }

    public Sport(String name, String level1, String level2, String level3) {
        this.name = name;
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
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

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
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
