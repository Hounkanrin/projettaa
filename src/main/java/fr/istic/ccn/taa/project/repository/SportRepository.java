package fr.istic.ccn.taa.project.repository;

import fr.istic.ccn.taa.project.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {

    public List<Sport> findByName(String name);

}
