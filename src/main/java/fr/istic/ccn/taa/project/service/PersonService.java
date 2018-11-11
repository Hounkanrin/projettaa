package fr.istic.ccn.taa.project.service;

import fr.istic.ccn.taa.project.model.Person;
import fr.istic.ccn.taa.project.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;
import java.util.Optional;

//control de logique
@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

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
        System.err.println("pass par la");
         System.err.println(person.getEmail());
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

            if (personToUpdate.getPassword() != null){
                personToUpdate.setPassword((person.getPassword()));
            }

            if (personToUpdate.getImage() != null) {
                personToUpdate.setImage(person.getImage());
            }

            this.personRepository.save(personToUpdate);
        }
        return personToUpdate;
    }

//    public String deletePerson(Long id) {
//        this.personRepository.deleteById(id);
//        return "Person deleted";
//    }
    public boolean deletePerson(Long id) {
        boolean deleted = false;
        this.personRepository.deleteById(id);
        deleted = true;
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
}
