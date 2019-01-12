package fr.istic.ccn.taa.project.controller;

import fr.istic.ccn.taa.project.model.Sport;
import fr.istic.ccn.taa.project.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/sports")
public class SportController {

    @Autowired
    SportService sportService;

    @GetMapping(value = "")
    public List<Sport> sportList() {
        return this.sportService.sportList();
    }

    @GetMapping(value = "/")
    public List<Sport> sportListForLogin() {
        return this.sportService.sportList();
    }

    @GetMapping(value = "/{id}")
    public Sport getSportById(@PathVariable Long id) {
        return this.sportService.getSportById(id);
    }


    @PostMapping(value = "/create")
    @PreAuthorize(" hasRole('ADMIN')")
    public Sport addSport(@RequestBody Sport sport) {
        return this.sportService.addSport(sport);
    }

    @PutMapping(value = "/update")
    public Sport updateSport(@RequestBody Sport sport) {
        return this.sportService.updateSport(sport);
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize(" hasRole('ADMIN')")
    public boolean deleteSport(@PathVariable Long id) {
        return this.sportService.deleteSport(id);

    }

    @GetMapping(value = "/sport/{name}")
    public boolean getSportByName(@PathVariable String name) {
        return this.sportService.getSportByName(name);
    }

}
