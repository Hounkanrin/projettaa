package fr.istic.ccn.taa.project.service;

import fr.istic.ccn.taa.project.model.Place;
import fr.istic.ccn.taa.project.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    PlaceRepository placeRepository;

    public List<Place> getPlaces() {
        return this.placeRepository.findAll();
    }

    public Place createPlace(Place placeToCreate) {

        Place foundPlace = this.placeRepository.findByName(placeToCreate.getName());

        if (foundPlace != null) {
            return foundPlace;
        } else {
            return this.placeRepository.save(placeToCreate);
        }
    }

    public Optional<Place> getPlaceById(Long id) {
        return this.placeRepository.findById(id);
    }

    public Place updatePlace(Place place) {

        Place placeToUpdate = this.placeRepository.findById(place.getId()).get();

        if (placeToUpdate != null) {
            placeToUpdate.getId();

            if (placeToUpdate.getName() != null && place.getName() != null) {
                placeToUpdate.setName(place.getName());
            }

        }
        this.placeRepository.save(placeToUpdate);

        return placeToUpdate;
    }

    /**/
    public Place getName(String name) {
        return this.placeRepository.findByName(name);
    }


    /**/

    public String deletePlace(Long id) {
        this.placeRepository.deleteById(id);
        return "Place deleted";
    }

}
