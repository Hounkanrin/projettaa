package fr.istic.ccn.taa.project.controller;

import fr.istic.ccn.taa.project.model.Sport;
import fr.istic.ccn.taa.project.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sports")
public class SportController {

    @Autowired
    SportService sportService;

    @GetMapping(value = "/")
    public List<Sport> sportList() {
        return this.sportService.sportList();
    }


    @PostMapping(value = "/create")
    public Sport addSport(@RequestBody Sport sport) {
        return this.sportService.addSport(sport);
    }

    @PutMapping(value = "/update")
    public Sport updateSport(@RequestBody Sport sport) {
        return this.sportService.updateSport(sport);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteSport(@PathVariable Long id) {
        return this.sportService.deleteSport(id);

    }


}
