package fr.istic.ccn.taa.project.controller;

import fr.istic.ccn.taa.project.model.Localisation;
import fr.istic.ccn.taa.project.service.LocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/localisations")
public class LocalisationController {

    @Autowired
    LocalisationService localisationService;

    @GetMapping("/")
    public List<Localisation> getLocalisation(){
        return this.localisationService.getLocalisations();
    }

    @PostMapping(value = "/create")
    public Localisation addLocalisation(@RequestBody Localisation localisation){

        return this.localisationService.createLocalisation(localisation);
    }

    @PutMapping(value = "/update")
    public Localisation updateLocalisation(@RequestBody Localisation localisation){

        String message = null;
        Localisation localisationToUpdate = this.localisationService.updateLocalisation(localisation);
        if(localisationToUpdate != null) {
            message = "Le lieu " + localisationToUpdate.getCity() + " a été mise à jour";
        }
        else{
            message = "Email " + localisationToUpdate.getCity() + " n'existe pas ";
        }
        return localisation;
    }

    @GetMapping(value = "/{id}")
    public Optional<Localisation> getLocalisationById(@PathVariable (value = "id") Long id){
        return this.localisationService.getLocalisationById(id);
    }

    /**/
    @GetMapping(value ="/city/{city}")
    public List<Localisation> getCity(@PathVariable (value = "city") String city){
        return this.localisationService.getCity(city);
    }

    @GetMapping(value ="/department/{department}")
    public List<Localisation> getDepartment(@PathVariable (value = "department") String department){
        return this.localisationService.getDepartment(department);
    }

    @GetMapping(value ="region/{region}")
    public List<Localisation> getRegion(@PathVariable (value = "region") String region){
        return this.localisationService.getRegion(region);
    }
    /**/

    @DeleteMapping(value = "/delete/{id}")
    public String deleteLocalisation(@PathVariable("id") Long id){
        return this.localisationService.deleteLocalisation(id);
    }
}
