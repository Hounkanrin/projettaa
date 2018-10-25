package fr.istic.ccn.taa.project.controller;

import fr.istic.ccn.taa.project.model.Place;
import fr.istic.ccn.taa.project.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @GetMapping("/")
    public List<Place> getPlace() {
        return this.placeService.getPlaces();
    }

    @PostMapping(value = "/create")
    public Place addPlace(@RequestBody Place place) {

        return this.placeService.createPlace(place);
    }

    @PutMapping(value = "/update")
    public Place updatePlace(@RequestBody Place place) {

        String message = null;
        Place placeToUpdate = this.placeService.updatePlace(place);
        if (placeToUpdate != null) {
            message = "Le lieu " + placeToUpdate.getName() + " a été mise à jour";
        } else {
            message = "Email " + placeToUpdate.getName() + " n'existe pas ";
        }
        return place;
    }

    @GetMapping(value = "/{id}")
    public Optional<Place> getPlaceById(@PathVariable(value = "id") Long id) {
        return this.placeService.getPlaceById(id);
    }



    /**/

    @DeleteMapping(value = "/delete/{id}")
    public String deletePlace(@PathVariable("id") Long id) {
        return this.placeService.deletePlace(id);
    }
}
