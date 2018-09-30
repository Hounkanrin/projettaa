package fr.istic.ccn.taa.project.repository;

import fr.istic.ccn.taa.project.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {
}
