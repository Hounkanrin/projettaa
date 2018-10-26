package fr.istic.ccn.taa.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int role;
    private String image;

    public Person() {
        this.lastname = "";
        this.firstname = "";
        this.email = "";

    }

    public Person(String firstname, String lastname, String email, String password, String image) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = 0;
        this.image = image;
    }

//    public Person(String firstname, String lastname, String email) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.email = email;
//
//    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
