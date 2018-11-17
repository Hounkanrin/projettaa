package fr.istic.ccn.taa.project.controller;

import fr.istic.ccn.taa.project.model.Person;
import fr.istic.ccn.taa.project.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@CrossOrigin
public class AuthenController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/login")
    public boolean login(@RequestBody Person person) {
        Optional<Person> loginPerson = this.personRepository.findByEmail(person.getEmail());
        if (loginPerson.isPresent() && person.getPassword().equals(loginPerson.toString())) {
            return true;
        } else {
            return false;
        }

    }
}