package fr.istic.ccn.taa.project.service;

import fr.istic.ccn.taa.project.model.*;
import fr.istic.ccn.taa.project.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class ChoiceService {

    @Autowired
    private ChoiceRepository choiceRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private LevelRepository levelRepository;

    public List<Choice> getAll() {
        return this.choiceRepository.findAll();
    }

    public List<Choice> getChoicesByPerson(Long id) {
        Person person = this.personRepository.findById(id).get();
        return this.choiceRepository.findChoicesByPersonId(person.getId());
    }

    public List<Choice> getChoicesBySport(Long id) {
        Sport sport = this.sportRepository.findById(id).get();
        return this.choiceRepository.findChoicesBySportId(sport.getId());
    }

    public List<Choice> getChoicesByPlace(Long id) {
        Place place = this.placeRepository.findById(id).get();
        return this.choiceRepository.findChoicesByPlacesContains(place.getId());
    }

    public Choice addChoice(Choice choice) {

        List<Place> places = new LinkedList<>();
        for (Place place : choice.getPlaces()) {
            places.add(this.placeRepository.findById(place.getId()).get());
        }
        choice.setPlaces(places);

        Person person = this.personRepository.findById(choice.getPerson().getId()).get();
        choice.setPerson(person);

        Level level = this.levelRepository.findById(choice.getLevel().getId()).get();
        choice.setLevel(level);

        Sport sport = this.sportRepository.findById(choice.getSport().getId()).get();
        choice.setSport(sport);

        choice.setChoiceDate(LocalDateTime.now());
        choice.setLastUpdate(LocalDateTime.now());
        return this.choiceRepository.save(choice);
    }

    public Choice getChoiceById(Long id) {
        return this.choiceRepository.findById(id).get();
    }

    public Choice updateChoice(Choice choice) {
        Choice existingChoice = this.choiceRepository.findById(choice.getId()).get();
        if (existingChoice.getPerson().getId() == choice.getPerson().getId()) {
            if (existingChoice.getSport() != null && choice.getSport() != null) {
                existingChoice.setSport(this.sportRepository.findById(choice.getSport().getId()).get());
            }
            if (existingChoice.getLevel() != null && choice.getLevel() != null) {
                existingChoice.setLevel(this.levelRepository.findById(choice.getLevel().getId()).get());
            }
            if (existingChoice.getPlaces() != null && choice.getPlaces() != null && !existingChoice.getPlaces().isEmpty() && !choice.getPlaces().isEmpty()) {
                for (Place place : choice.getPlaces()) {
                    boolean found = false;
                    for (Place currPlace : existingChoice.getPlaces()) {
                        if (currPlace.getId() == place.getId()) {
                            found = true;
                        }
                    }
                    if (!found) {
                        existingChoice.getPlaces().add(place);
                    }
                }
                this.choiceRepository.save(existingChoice);

            }

        }
        return existingChoice;
    }

    public boolean deleteChoice(Long id) {
        boolean deleted = false;
        this.choiceRepository.deleteById(id);
        deleted = true;
        return deleted;
    }

}
