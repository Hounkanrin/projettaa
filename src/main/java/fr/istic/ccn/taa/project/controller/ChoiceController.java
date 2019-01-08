package fr.istic.ccn.taa.project.controller;


import fr.istic.ccn.taa.project.model.Choice;
import fr.istic.ccn.taa.project.repository.ChoiceRepository;
import fr.istic.ccn.taa.project.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/choices")
public class ChoiceController {

    @Autowired
    private ChoiceService choiceService;

    @Autowired
    private ChoiceRepository choiceRepository;

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Choice> getAll() {
        return this.choiceService.getAll();
    }

    @PostMapping("/create")
    public Choice createChoice(@RequestBody Choice choice) {

        return this.choiceService.addChoice(choice);

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    public Choice getChoiceById(@PathVariable Long id) {
        return this.choiceService.getChoiceById(id);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    public Choice updateChoice(@RequestBody Choice choice) {
        return this.choiceService.updateChoice(choice);
    }

    @GetMapping("/place")
    public List<Choice> getChoiceByPlace(@PathVariable Long id) {
        return this.choiceService.getChoicesByPlace(id);
    }

    @GetMapping("/sport/{id}")
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    public List<Choice> getChoiceBySport(@PathVariable Long id) {
        return this.choiceService.getChoicesBySport(id);
    }

    @GetMapping("/person/{id}")
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    public List<Choice> getChoiceByPerson(@PathVariable Long id) {
        return this.choiceService.getChoicesByPerson(id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    public boolean deleteChoice(@PathVariable Long id) {
        return this.choiceService.deleteChoice(id);
    }
}


