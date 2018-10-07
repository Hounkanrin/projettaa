package fr.istic.ccn.taa.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@ToString
public class Localisation {

    private Long id;
    private String city;
    private String department;
    private String region;
    private List<Sport> sports;
    private List<Choice> choices;

    public Localisation() {
    }

    public Localisation(String city, String department, String region) {
        this.city = city;
        this.department = department;
        this.region = region;
        this.choices = new LinkedList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @ManyToMany
    public List<Sport> getSports() {
        return this.sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    @OneToMany
    @JsonIgnore
    public List<Choice> getChoices() {
        return this.choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
