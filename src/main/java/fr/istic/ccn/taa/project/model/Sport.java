package fr.istic.ccn.taa.project.model;

import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@NamedEntityGraph(name = "all", includeAllAttributes = true)
public class Sport {

    private Long id;
    private String name;
    private List<Place> places;


    public Sport() {
        this.places = new ArrayList<>();

    }

    public Sport(String name) {
        this.name = name;
        this.places = new ArrayList<>();
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

    //@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ManyToMany
    public List<Place> getPlaces() {
        return this.places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }


}
