package fr.istic.ccn.taa.project.repository;

import fr.istic.ccn.taa.project.model.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocalisationRepository extends JpaRepository<Localisation, Long> {

    public List<Localisation> findByCity(String city);

    public List<Localisation> findByDepartment(String department);

    public List<Localisation> findByRegion(String region);

}
