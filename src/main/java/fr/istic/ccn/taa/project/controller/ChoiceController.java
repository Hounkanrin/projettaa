package fr.istic.ccn.taa.project.controller;


import fr.istic.ccn.taa.project.model.Choice;
import fr.istic.ccn.taa.project.model.Person;
import fr.istic.ccn.taa.project.model.Place;
import fr.istic.ccn.taa.project.model.Sport;
import fr.istic.ccn.taa.project.repository.ChoiceRepository;
import fr.istic.ccn.taa.project.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/choices")
public class ChoiceController {

    @Autowired
    private ChoiceService choiceService;

    @Autowired
    private ChoiceRepository choiceRepository;

    @GetMapping("/")
    public List<Choice> getAll() {
        return this.choiceService.getAll();
    }

    @PostMapping("/create")
    public Choice createChoice(@RequestBody Choice choice) {

        return this.choiceService.addChoice(choice);

    }

    @GetMapping("/{id}")
    public Choice getChoiceById(@PathVariable Long id) {
        return this.choiceService.getChoiceById(id);
    }

    @PutMapping("/update")
    public Choice updateChoice(@RequestBody Choice choice) {
        return this.choiceService.updateChoice(choice);
    }

    @GetMapping("/place")
    public List<Choice> getChoiceByPlace(@RequestBody Place place) {
        return this.choiceService.getChoicesByPlace(place);
    }

    @GetMapping("/choice")
    public List<Choice> getChoiceBySport(@RequestBody Sport sport) {
        return this.choiceService.getChoicesBySport(sport);
    }

    @GetMapping("/person")
    public List<Choice> getChoiceByPerson(@RequestBody Person person) {
        return this.choiceService.getChoicesByPerson(person);
    }

}
