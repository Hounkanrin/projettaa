package fr.istic.ccn.taa.project.service;

import fr.istic.ccn.taa.project.model.Place;
import fr.istic.ccn.taa.project.model.Sport;
import fr.istic.ccn.taa.project.repository.SportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SportService {

    @Autowired
    SportRepository sportRepository;

    public List<Sport> sportList() {
        return this.sportRepository.findAll();

    }

    public Sport addSport(Sport sport) {
        List<Sport> list = this.sportRepository.findByName(sport.getName());
        if (list.size() > 0) {
            return sport;
        } else
            return this.sportRepository.save(sport);
    }

    public Sport updateSport(Sport sport) {
        Sport sportToUpdate = this.sportRepository.findById(sport.getId()).get();

        if (sportToUpdate != null) {

            if (sportToUpdate.getName() != null && sport.getName() != null && !sport.getName().isEmpty()) {
                sportToUpdate.setName(sport.getName());
            }
            if (sportToUpdate.getPlaces() != null && sport.getPlaces() != null && !sportToUpdate.getPlaces().isEmpty() && !sport.getPlaces().isEmpty()) {
                for (Place receivedPlace : sport.getPlaces()) {
                    boolean found = false;
                    for (Place currentPlace : sportToUpdate.getPlaces()) {
                        if (currentPlace.getId() == receivedPlace.getId()) {
                            found = true;
                        }
                    }
                    if (!found) {
                        sportToUpdate.getPlaces().add(receivedPlace);
                    }

                }
            }
            this.sportRepository.save(sportToUpdate);
        }
        return sportToUpdate;
    }


    public String deleteSport(Long id) {
        this.sportRepository.deleteById(id);
        return "deleted";
    }


}
