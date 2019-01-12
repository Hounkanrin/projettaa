package fr.istic.ccn.taa.project.service;

import fr.istic.ccn.taa.project.model.Choice;
import fr.istic.ccn.taa.project.model.Person;
import fr.istic.ccn.taa.project.model.RoleConstants;
import fr.istic.ccn.taa.project.repository.ChoiceRepository;
import fr.istic.ccn.taa.project.repository.PersonRepository;
import fr.istic.ccn.taa.project.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

//control de logique
@Service
@Slf4j
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    ChoiceRepository choiceRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;

    //verifier la validité de l'email
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            final InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (final AddressException ex) {
            result = false;
        }
        return result;
    }


    public List<Person> getPersons() {
        return this.personRepository.findAll();
    }

    public Person createPerson(final Person person) {


        final Optional<Person> personOptional = this.personRepository.findByEmail(person.getEmail());

        if (isValidEmailAddress(person.getEmail()) && !emailExit(person.getEmail())) {
            final HashSet roles = new HashSet();
            roles.add(this.roleRepository.findByName(RoleConstants.USER.name().toLowerCase()));
            final Person personToCreate = Person.builder()
                    .email(person.getEmail())
                    .firstname(person.getFirstname())
                    .lastname(person.getLastname())
                    .password(this.passwordEncoder.encode(person.getPassword()))
                    .roles(roles)
                    .username(person.getUsername())
                    .build();

            return this.personRepository.save(personToCreate);
        } else {
            log.error("L'adresse email utilisée existe déjà");
            return person;
        }
    }

    public Optional<Person> getPersonById(final Long id) {

        return this.personRepository.findById(id);
    }

    public Person updatePerson(Person person) {

        final Optional<Person> personGetId = this.personRepository.findById(person.getId());
        final Person personToUpdate = personGetId.get();

        if (personToUpdate != null) {
            personToUpdate.getId();

            if (personToUpdate.getFirstname() != null) {
                personToUpdate.setFirstname(person.getFirstname());
            }

            if (personToUpdate.getLastname() != null) {
                personToUpdate.setLastname(person.getLastname());
            }

            if (personToUpdate.getEmail() != null) {
                personToUpdate.setEmail(person.getEmail());
            }

            if (personToUpdate.getPassword() != null) {
                personToUpdate.setPassword((person.getPassword()));
            }

            this.personRepository.save(personToUpdate);
        }
        return personToUpdate;
    }


    public boolean deletePerson(Long id) {
        boolean deleted = false;
        final Person person = this.personRepository.findById(id).get();
        final List<Choice> choiceList = this.choiceRepository.findChoicesByPersonId(person.getId());
        if (choiceList.size() > 0) {
            for (final Choice choice : choiceList) {
                this.choiceRepository.deleteById(choice.getId());
            }
            if (this.choiceRepository.findChoicesByPersonId(person.getId()).size() == 0) {
                this.personRepository.deleteById(id);
                deleted = true;
            }
        }
        return deleted;

    }

    private boolean emailExit(final String email) {

        return this.personRepository.findByEmail(email).isPresent();
    }


    public Optional<Person> getPersonEmail(String email) {
        return this.personRepository.findByEmail(email);
    }
}
