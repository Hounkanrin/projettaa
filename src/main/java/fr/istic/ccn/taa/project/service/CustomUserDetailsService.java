package fr.istic.ccn.taa.project.service;

import fr.istic.ccn.taa.project.model.CustomUserDetails;
import fr.istic.ccn.taa.project.model.Person;
import fr.istic.ccn.taa.project.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Optional<Person> personOptional = this.personRepository.findByEmail(username);
        personOptional.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        log.info("{}", personOptional.get());
        return personOptional.map(person -> new CustomUserDetails(person)).get();

    }
}
