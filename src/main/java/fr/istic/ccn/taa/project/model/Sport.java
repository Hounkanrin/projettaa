package fr.istic.ccn.taa.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
public class Sport {

    private Long id;
    private String name;
    private List<Localisation> localisations;

    private List<Choice> choices;

    public Sport() {
        super();
    }

    public Sport(String name) {
        this.name = name;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToMany(mappedBy = "sports", cascade = CascadeType.PERSIST)
    public List<Localisation> getLocalisations() {
        return this.localisations;
    }

    public void setLocalisations(List<Localisation> localisations) {
        this.localisations = localisations;
    }

    @ManyToMany(mappedBy = "sport", cascade = CascadeType.ALL)
    @JsonIgnore
    public List<Choice> getChoices() {
        return this.choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
