package fr.istic.ccn.taa.project.repository;

import fr.istic.ccn.taa.project.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public Person findByEmail(String email);

    public Person findById(String id);
}
