package fr.istic.ccn.taa.project.controller;

import fr.istic.ccn.taa.project.model.Person;
import fr.istic.ccn.taa.project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/")
    public List<Person> getPersons(){
        List<Person> personList = this.personService.getPersons();
        return personList;
    }

    @PostMapping(value = "/create")
    public Person addPerson(@RequestBody Person person){

        return this.personService.createPerson(person);
    }

    @PutMapping(value = "/update")
    public Person updatePerson(@RequestBody Person person){

        String message = null;
        Person personToUpdate = this.personService.updatePerson(person);
        if(personToUpdate != null){
            message = "Person " + personToUpdate.getFirstname() + "have been updated";
        }
        else{
            message = "Email " + person.getEmail()+ " don't exist ";
        }
        return person;
    }

    /**Exemple à suivre**/
    @GetMapping(value = "/{id}")
    public Optional<Person> getPersonById(@PathVariable (value = "id") Long id){

            return this.personService.getPersonById(id);
    }


    /**TO DO*/
    @DeleteMapping(value="delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {

        return this.personService.deletePerson(id);
    }
}
