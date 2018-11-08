package fr.istic.ccn.taa.project.repository;

import fr.istic.ccn.taa.project.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


    public List<Person> findByEmail(String email);

    public Person findById(String id);

    @Query(" select person from person u " +
            " where u.username = ?1")
    public Person findByUsername(String username);
    //public Person findByUsername(String username);


}
