package fr.istic.ccn.taa.project.repository;

import fr.istic.ccn.taa.project.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findByName(String name);

}
