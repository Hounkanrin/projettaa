package fr.istic.ccn.taa.project.controller;

import fr.istic.ccn.taa.project.model.Sport;
import fr.istic.ccn.taa.project.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SportController {

    @Autowired
    SportService sportService;

    @GetMapping(value = "/sportlist")
    public List<Sport> sportList(){
        return sportService.sportList();
    }


    @PostMapping(value = "/addsport")
    public Sport addSport(@RequestBody Sport sport){
        return sportService.addSport(sport);
    }

    @PutMapping(value = "/updatesport")
    public Sport updateSport(@RequestBody Sport sport){
        return sportService.updateSport(sport);
    }

    @DeleteMapping(value = "/deletesport/{id}")
    public String deleteSport(@PathVariable Long id){
        return sportService.deleteSport(id);

    }





}
