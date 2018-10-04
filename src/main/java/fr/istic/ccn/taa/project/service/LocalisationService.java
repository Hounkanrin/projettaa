package fr.istic.ccn.taa.project.service;

import fr.istic.ccn.taa.project.model.Localisation;
import fr.istic.ccn.taa.project.repository.LocalisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalisationService {

    @Autowired
    LocalisationRepository localisationRepository;

    public List<Localisation> getLocalisations(){ return this.localisationRepository.findAll(); }

    public Localisation createLocalisation (Localisation localisation){

        List<Localisation> localisations = localisationRepository.findByCity(localisation.getCity());

        if(localisations.size() > 0 ) {
            return localisation;
        }
        else {
            return localisationRepository.save(localisation);
        }
    }

    public Optional<Localisation> getLocalisation(Long id){
        return this.localisationRepository.findById(id);
    }

    public Localisation updateLocalisation(Localisation localisation){

        Optional<Localisation> localisationGetId = this.localisationRepository.findById(localisation.getId());
        Localisation localisationToUpdate = localisationGetId.get();

        if(localisationToUpdate != null){
            localisationToUpdate.getId();

            if(localisationToUpdate.getCity() != null){
                localisationToUpdate.setCity(localisation.getCity());
            }

            if(localisationToUpdate.getDepartment() != null){
                localisationToUpdate.setDepartment(localisation.getDepartment());
            }

            if(localisationToUpdate.getRegion() != null){
                localisationToUpdate.setDepartment(localisation.getRegion());
            }
            this.localisationRepository.save(localisation);
        }
        return localisation;
    }

    public Optional<Localisation> getLocalisationById(Long id){

        return this.localisationRepository.findById(id);
    }
    /**/
    public List<Localisation> getCity(String city){
        return this.localisationRepository.findByCity(city);
    }

    public List<Localisation> getDepartment(String department){
        return this.localisationRepository.findByDepartment(department);
    }

    public List<Localisation> getRegion(String region){
        return this.localisationRepository.findByRegion(region);
    }
    /**/

    public String deleteLocalisation(Long id){
         this.localisationRepository.deleteById(id);
         return "Localisation deleted";
    }

    public boolean existLocalisation(Long id){
        return localisationRepository.existsById(id);
    }


}
