package fr.istic.ccn.taa.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Localisation {

    private Long id;
    private String city;
    private String department;
    private String region;
    private List<Person> persons;
    private List<Sport> sports;

    public Localisation() {
    }

    public Localisation(String city, String department, String region) {
        this.city = city;
        this.department = department;
        this.region = region;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @ManyToMany(mappedBy = "localisations", cascade = CascadeType.PERSIST)
    @JsonIgnore
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @ManyToMany
    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }
}
