package fr.istic.ccn.taa.project.repository;

import fr.istic.ccn.taa.project.model.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {

    List<Choice> findChoicesByPersonId(Long id);

    List<Choice> findChoicesBySportId(Long id);

    List<Choice> findChoicesByPlacesContains(Long id);

}
