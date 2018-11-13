package fr.istic.ccn.taa.project.service;

import fr.istic.ccn.taa.project.model.Choice;
import fr.istic.ccn.taa.project.model.Person;
import fr.istic.ccn.taa.project.repository.ChoiceRepository;
import fr.istic.ccn.taa.project.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
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

    public List<Person> getPersons() {
        return this.personRepository.findAll();
    }

    public Person createPerson(Person person) {

        List<Person> persons = this.personRepository.findByEmail(person.getEmail());

        if (persons.size() == 0 && isValidEmailAddress(person.getEmail())) {
            return this.personRepository.save(person);
        } else {
            System.err.println("L'adresse email utilisée existe déjà");
            return person;
        }
    }

    public Optional<Person> getPersonById(Long id) {

        return this.personRepository.findById(id);
    }

    public Person updatePerson(Person person) {

        Optional<Person> personGetId = this.personRepository.findById(person.getId());
        Person personToUpdate = personGetId.get();

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
        Person person = this.personRepository.findById(id).get();
        List<Choice> choiceList = this.choiceRepository.findChoicesByPersonId(person.getId());
        if (choiceList.size() > 0) {
            for (Choice choice : choiceList) {
                this.choiceRepository.deleteById(choice.getId());
            }
            if (this.choiceRepository.findChoicesByPersonId(person.getId()).size() == 0) {
                this.personRepository.deleteById(id);
                deleted = true;
            }
        }
        return deleted;

    }

    //other method
    public boolean existPerson(String email) {
        return this.personRepository.findByEmail(email) != null;
    }

    //verifier la validité de l'email
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

  /*  public User getUser(Long id) {
        User user = new User();
        Person person = this.personRepository.findById(id).get();
        if (person != null) {
            user.setEmail() = person.getEmail();
            user.setEmail() = person.getPassword();
            user.getRole() = person.getRole();
        }
        return user;
    }

*/
}
