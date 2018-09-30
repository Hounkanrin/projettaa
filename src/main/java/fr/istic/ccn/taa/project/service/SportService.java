package fr.istic.ccn.taa.project.service;

import fr.istic.ccn.taa.project.model.Sport;
import fr.istic.ccn.taa.project.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportService {

    @Autowired
    SportRepository sportRepository;

    public List<Sport> sportList(){
        return sportRepository.findAll();

    }

    public Sport addSport(Sport sport){
       return sportRepository.save(sport);
    }

    public Sport updateSport(Sport sport) {
        Optional<Sport> sport1 = sportRepository.findById(sport.getId());
        Sport sportUpdate = sport1.get();
        if (sportUpdate != null) {
            sportUpdate.getId();

            if (sportUpdate.getName() != null) {
                sportUpdate.setName(sport.getName());
            }
            if (sportUpdate.getLevel() != null) {
                sportUpdate.setLevel(sport.getLevel());
            }
            if (sportUpdate.getPersons() != null) {
                sportUpdate.setPersons(sport.getPersons());
            }
            if (sportUpdate.getLocalisations() != null) {
                sportUpdate.setLocalisations(sport.getLocalisations());
            }
            sportRepository.save(sport);
        }
            return sport;
    }

    public String deleteSport(Long id){
        sportRepository.deleteById(id);
        return "deleted";
    }


}
