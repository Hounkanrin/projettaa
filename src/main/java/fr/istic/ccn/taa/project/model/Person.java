package fr.istic.ccn.taa.project.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private List<Sport> sports;
    private List<Localisation> localisations;

    public Person() {
    }

    public Person(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany
    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    @ManyToMany
    public List<Localisation> getLocalisations() {
        return localisations;
    }

    public void setLocalisations(List<Localisation> localisations) {
        this.localisations = localisations;
    }
}
