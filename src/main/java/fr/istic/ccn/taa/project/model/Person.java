package fr.istic.ccn.taa.project.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Person {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private List<Choice> choices;

    public Person() {
        this.lastname = "";
        this.firstname = "";
        this.email = "";
        this.choices = new LinkedList<>();
    }

    public Person(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
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

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    public List<Choice> getChoices() {
        return this.choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }


}
