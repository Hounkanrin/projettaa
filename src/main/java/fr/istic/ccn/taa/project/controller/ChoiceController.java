package fr.istic.ccn.taa.project.controller;


import fr.istic.ccn.taa.project.model.Choice;
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
    public List<Choice> getChoiceByPlace(@PathVariable Long id) {
        return this.choiceService.getChoicesByPlace(id);
    }

    @GetMapping("/sport/{id}")
    public List<Choice> getChoiceBySport(@PathVariable Long id) {
        return this.choiceService.getChoicesBySport(id);
    }

    @GetMapping("/person/{id}")
    public List<Choice> getChoiceByPerson(@PathVariable Long id) {
        return this.choiceService.getChoicesByPerson(id);
    }

}
