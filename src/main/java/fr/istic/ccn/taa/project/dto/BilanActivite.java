package fr.istic.ccn.taa.project.dto;

import fr.istic.ccn.taa.project.model.Place;
import fr.istic.ccn.taa.project.model.Sport;

import java.util.List;

public class BilanActivite {

    private Sport activite;

    private List<Place> lieuxEligible;

    public Sport getActivite() {
        return activite;
    }

    public void setActivite(Sport activite) {
        this.activite = activite;
    }

    public List<Place> getLieuxEligible() {
        return lieuxEligible;
    }

    public void setLieuxEligible(List<Place> lieuxEligible) {
        this.lieuxEligible = lieuxEligible;
    }
}
