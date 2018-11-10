package fr.istic.ccn.taa.project.repository;

import fr.istic.ccn.taa.project.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


    List<Person> findByEmail(String email);

    Person findById(String id);

    Optional<Person> findByUsername(String username);


}
