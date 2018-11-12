package fr.istic.ccn.taa.project.repository;

import fr.istic.ccn.taa.project.model.Place;
import fr.istic.ccn.taa.project.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findByName(String name);
}
