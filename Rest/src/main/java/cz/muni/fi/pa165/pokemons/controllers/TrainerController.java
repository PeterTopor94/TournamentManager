package cz.muni.fi.pa165.pokemons.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.muni.fi.pa165.pokemons.DTO.TournamentDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import cz.muni.fi.pa165.pokemons.exceptions.ResourceAlreadyExistingException;
import cz.muni.fi.pa165.pokemons.exceptions.ResourceNotFoundException;
import cz.muni.fi.pa165.pokemons.facade.GymFacade;
import cz.muni.fi.pa165.pokemons.facade.TournamentFacade;
import cz.muni.fi.pa165.pokemons.facade.TrainerFacade;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roman
 */
@RestController
public class TrainerController {

    final static Logger logger = LoggerFactory.getLogger(TrainerController.class);

    @Inject
    private TrainerFacade trainerFacade;

    @Inject
    private GymFacade gymFacade;
    
    @Inject
    private TournamentFacade tournamentFacade;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final TrainerDTO createTrainer(@RequestBody TrainerCreateDTO trainer) throws Exception {

        logger.debug("rest createTrainer()");

        try {
            Long id = trainerFacade.createTrainer(trainer);
            return trainerFacade.getById(id);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteTrainer(@PathVariable("id") long id) throws Exception {
        logger.debug("rest deleteTrainer({})", id);
        try {
            trainerFacade.deleteTrainer(trainerFacade.getById(id));
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final TrainerDTO getTrainer(@PathVariable("id") long id) throws Exception {

        logger.debug("rest getTrainer({})", id);
        TrainerDTO trainerDTO = trainerFacade.getById(id);
        if (trainerDTO == null) {
            throw new ResourceNotFoundException();
        }
        return trainerDTO;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Collection<TrainerDTO> getAllTrainers() throws JsonProcessingException {

        logger.debug("rest getAllTrainers()");
        return trainerFacade.getAllTrainers();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final List<TrainerDTO> getTrainerByNameAndSurname(@RequestParam("name") String name,
            @RequestParam(value = "surname") String surname) {

        logger.debug("rest getTrainerByNameAndSurname({},{})", name, surname);

        List<TrainerDTO> trainerDTOs = trainerFacade.getTrainersByNameAndSurname(name, surname);
        if (trainerDTOs == null) {
            throw new ResourceNotFoundException();
        }
        return trainerDTOs;
    }

    @RequestMapping(value = "/{gym_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final TrainerDTO getTrainerByGym(@PathVariable("gym_id") long gymid) {

        logger.debug("rest getOrderByUserId({})", gymid);

        TrainerDTO trainer = trainerFacade.getTrainerByGym(gymFacade.getGymById(gymid));
        if (trainer == null) {
            throw new ResourceNotFoundException();
        }
        return trainer;
    }
    
     @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean checkTrainerQualificationForTournament(@RequestParam("trainer_id") Long trainer_id,
            @RequestParam(value = "tournament_id") Long tournament_id) {

        logger.debug("rest checkTrainerQualificationForTournament({},{})", trainer_id, tournament_id);

        TrainerDTO trainer = trainerFacade.getById(trainer_id);
        if (trainer == null) {
            throw new ResourceNotFoundException();
        }
        TournamentDTO tournament = tournamentFacade.findById(tournament_id);
        if (trainer == null) {
            throw new ResourceNotFoundException();
        }
        return trainerFacade.isTrainerQualifiedForTournament(trainer, tournament);
    }

}
