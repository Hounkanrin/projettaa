package fr.istic.ccn.taa.project.repository;

import fr.istic.ccn.taa.project.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Long> {


    Optional<Person> findByEmail(String email);

    Optional<Person> findById(String id);

    Optional<Person> findByUsername(String username);


}
