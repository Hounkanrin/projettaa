package fr.istic.ccn.taa.project.controller;

import fr.istic.ccn.taa.project.model.Person;
import fr.istic.ccn.taa.project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/")
    public List<Person> getPersons() {
        List<Person> personList = this.personService.getPersons();
        return personList;
    }

    @PostMapping(value = "/create")
    public Person addPerson(@RequestBody Person person) {

        return this.personService.createPerson(person);
    }

    @PutMapping(value = "/update")
    public Person updatePerson(@RequestBody Person person) {

        String message = null;
        Person personToUpdate = this.personService.updatePerson(person);
        if (personToUpdate != null) {
            message = "Les informations de " + personToUpdate.getFirstname() + "ont été mises à jour.";
        } else {
            message = "L'email " + person.getEmail() + " n'existe pas. ";
        }
        return person;
    }

    /**
     * Exemple à suivre
     **/
    @GetMapping(value = "/{id}")
    public Optional<Person> getPersonById(@PathVariable(value = "id") Long id) {

        return this.personService.getPersonById(id);
    }

    /**
     * TO DO
     */
    @DeleteMapping(value = "delete/{id}")
    public boolean deletePerson(@PathVariable("id") Long id) {
        return this.personService.deletePerson(id);
    }

}