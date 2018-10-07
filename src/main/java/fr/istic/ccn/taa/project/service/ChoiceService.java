package fr.istic.ccn.taa.project.service;

import fr.istic.ccn.taa.project.model.Choice;
import fr.istic.ccn.taa.project.model.Localisation;
import fr.istic.ccn.taa.project.model.Person;
import fr.istic.ccn.taa.project.model.Sport;
import fr.istic.ccn.taa.project.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ChoiceService {

    @Autowired
    private ChoiceRepository choiceRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private LocalisationRepository localisationRepository;

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private LevelRepository levelRepository;

    public List<Choice> getAll() {
        return this.choiceRepository.findAll();
    }

    public List<Choice> getChoicesByPerson(Person person) {

        return this.choiceRepository.findChoicesByPersonId(person.getId());
    }

    public List<Choice> getChoicesBySport(Sport sport) {

        return this.choiceRepository.findChoicesBySportId(sport.getId());
    }

    public List<Choice> getChoicesByLocalisation(Localisation localisation) {
        return this.choiceRepository.findChoicesByLocalisationId(localisation.getId());
    }

    public Choice addChoice(Choice choice) {

        choice.setChoiceDate(LocalDateTime.now());
        choice.setLastUpdate(LocalDateTime.now());
        return this.choiceRepository.save(choice);
    }

}
