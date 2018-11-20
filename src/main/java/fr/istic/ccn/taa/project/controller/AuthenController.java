package fr.istic.ccn.taa.project.controller;

import fr.istic.ccn.taa.project.model.Person;
import fr.istic.ccn.taa.project.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.Optional;


@RestController
@CrossOrigin
public class AuthenController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/")
    public boolean login(@RequestBody Person person) {
        Optional<Person> loginPerson = this.personRepository.findByEmail(person.getEmail());
        if (loginPerson.isPresent() && person.getPassword().equals(loginPerson.toString())) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () -> new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }
}