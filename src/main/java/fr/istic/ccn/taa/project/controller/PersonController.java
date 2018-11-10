package fr.istic.ccn.taa.project.controller;

import fr.istic.ccn.taa.project.model.Person;
import fr.istic.ccn.taa.project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('USER')")
    public List<Person> getPersons() {
        List<Person> personList = this.personService.getPersons();
        return personList;
    }

    @PostMapping(value = "/create")
    public Person addPerson(@RequestBody Person person) {

        return this.personService.createPerson(person);
    }

    @PutMapping(value = "/update")
    @PreAuthorize("hasRole('USER')")
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
    @PreAuthorize("hasRole('USER')")
    public Optional<Person> getPersonById(@PathVariable(value = "id") Long id) {

        return this.personService.getPersonById(id);
    }


    /**
     * TO DO
     */
    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("hasRole('USER')")
    public boolean deletePerson(@PathVariable("id") Long id) {

        return this.personService.deletePerson(id);
    }
}