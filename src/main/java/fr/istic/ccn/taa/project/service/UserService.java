package fr.istic.ccn.taa.project.service;

import fr.istic.ccn.taa.project.model.Person;
import fr.istic.ccn.taa.project.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class UserService implements UserDetailsService {


    private final PersonRepository personRepository;

    @Autowired
    public UserService(PersonRepository personRepository) {
        this.personRepository = personRepository;

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        Person person = this.personRepository.findByUsername(username);
        //.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return person;
    }
}
