package fr.istic.ccn.taa.project.schedule;

import fr.istic.ccn.taa.project.dto.BilanActivite;
import fr.istic.ccn.taa.project.dto.Meteo;
import fr.istic.ccn.taa.project.enums.EnumConditionMeteo;
import fr.istic.ccn.taa.project.model.Choice;
import fr.istic.ccn.taa.project.model.Person;
import fr.istic.ccn.taa.project.model.Place;
import fr.istic.ccn.taa.project.model.Sport;
import fr.istic.ccn.taa.project.service.ChoiceService;
import fr.istic.ccn.taa.project.service.EmailService;
import fr.istic.ccn.taa.project.service.MeteoService;
import fr.istic.ccn.taa.project.service.SportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm.ss");


    @Autowired
    SportService sportService;

    @Autowired
    ChoiceService choiceService;

    @Autowired
    MeteoService meteoService;

    @Autowired
    EmailService emailService;

    private static final String pays = "fr";


    @Scheduled(cron="0 0 0 * * TUE-WED")
    public void reportCurrentTime(){
        log.info("The time is now {}", dateFormat.format((new Date())));
        //récupération de la liste des choix existant en BDD
        List<Choice> listeChoix = choiceService.getAll();

        //Transformation : association activités/personne
        Map<Person, Set<Choice>> listeChoixParPersonne = listeChoix.stream().collect(Collectors.groupingBy(Choice::getPerson, Collectors.toSet()));

        //pour chaque personne on va récupérer le bilan d'activité et lui envoyer par mail
        for (Map.Entry<Person, Set<Choice>> choixPersone : listeChoixParPersonne.entrySet()) {

            //récupérer le bilan d'activité de la personne
            List<BilanActivite> listeBilanActivites = recupererLesActivitesPossible(choixPersone.getValue());

            //envoyer un mail à la personne sur le bilan de ses activités
            envoyerUnMailBilanActivites(choixPersone.getKey(), listeBilanActivites);
        }
    }

    /**
     *Cette méthode construit pour chaque sport les villes où il est possible de les pratiquer en fonction de la météo du jour
     * @param listeChoix : la liste des activtés
     * @return la liste des bilans de chaque activité
     */
    public List<BilanActivite> recupererLesActivitesPossible(Set<Choice> listeChoix){
        List<BilanActivite> bilanActivites = new ArrayList<>();

        //pour chaque choix/sport/activité
        listeChoix.forEach(choix -> {
            BilanActivite bilan = new BilanActivite();
            Sport sport = sportService.getSportDataById(choix.getSport().getId(),choix.getSport().getName());
            bilan.setActivite(sport);

            //la liste des villes où le sport ce pratique indépendamment de la météo
            List<Place> lieux = sport.getPlaces();

            //Les villes éligibles
            List<Place> villesELigibles = new ArrayList<>();

            //on détermine les villes où la météo permet de pratiquer l'activité
            lieux.forEach(lieu -> {
                Meteo meteo = meteoService.getMeteo(pays, lieu.getName());
                if(meteoBonne(meteo,sport)){
                    villesELigibles.add(lieu);
                }
            });

            //on associe le sport à ses villes éligible
            bilan.setLieuxEligible(villesELigibles);

            //on construit le bilan de chaque activite
            bilanActivites.add(bilan);
        });

        return bilanActivites;
    }

    public void envoyerUnMailBilanActivites(Person user, List<BilanActivite> bilanActivites){
        //construction du corps du mail à partir du bilan d'activité
        StringBuilder contenuDuMail = new StringBuilder();
        contenuDuMail.append("Retrouvez le bilan de vos activtés. Pour chaque sport les villes où les conditions météo permettent de pratiquer l'activité.");
        bilanActivites.forEach(bilan -> {
            contenuDuMail.append(bilan.getActivite().getName());
            contenuDuMail.append(": ");
            List<Place> lieuxEligibles = bilan.getLieuxEligible();
            if(CollectionUtils.isEmpty(lieuxEligibles)){
                contenuDuMail.append("pas de ville propice pour cette activité");
            } else{
                lieuxEligibles.forEach(lieux -> {
                    contenuDuMail.append(lieux.getName());
                    contenuDuMail.append(",");
                });
            }

            contenuDuMail.append("/n </br>");
        });

        //envoie du mail à l'utilisateur
        emailService.envoyerEmail(user.getEmail(), "Bilan d'activité", contenuDuMail.toString());
    }

    /**
     * Cette méthode retourne true si les conditions météos pour l'activité sont bonnes
     * @param meteo
     * @param sport
     * @return
     */
    public Boolean meteoBonne(Meteo meteo, Sport sport){
        //récupère la condition météo pour ce sport
        EnumConditionMeteo conditionMeteoPourSport = EnumConditionMeteo.getEnumBySport(sport.getId());
        if(meteo.getTemperature() < conditionMeteoPourSport.getTemperature()) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
