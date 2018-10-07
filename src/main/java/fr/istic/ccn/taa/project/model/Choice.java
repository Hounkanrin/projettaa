package fr.istic.ccn.taa.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@ToString
public class Choice {

    private Long id;
    private Person person;
    private Level level;
    private Sport sport;
    private Localisation localisation;
    private LocalDateTime choiceDate;
    private LocalDateTime lastUpdate;


    public Choice() {
    }

    public Choice(Person person, Sport sport) {
        this.person = person;
        this.sport = sport;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JsonIgnore
    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @OneToOne
    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @OneToOne
    public Sport getSport() {
        return this.sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @OneToOne
    public Localisation getLocalisation() {
        return this.localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public LocalDateTime getChoiceDate() {
        return this.choiceDate;
    }

    public void setChoiceDate(LocalDateTime choiceDate) {
        this.choiceDate = choiceDate;
    }

    public LocalDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
