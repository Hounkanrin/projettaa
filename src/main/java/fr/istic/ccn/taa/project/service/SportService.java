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
        Optional<Sport> sport1 = this.sportRepository.findById(sport.getId());
        Sport sportUpdate = sport1.get();
        if (sportUpdate != null) {
            sportUpdate.getId();

            if (sportUpdate.getName() != null) {
                sportUpdate.setName(sport.getName());
            }
            
            if (sportUpdate.getLocalisations() != null) {
                sportUpdate.setLocalisations(sport.getLocalisations());
            }
            this.sportRepository.save(sport);
        }
        return sport;
    }

    public String deleteSport(Long id) {
        this.sportRepository.deleteById(id);
        return "deleted";
    }


}
