package cz.fi.muni.pa165.rest.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.fi.muni.pa165.rest.ApiUris;
import cz.muni.fi.pa165.pokemons.DTO.TournamentDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import cz.fi.muni.pa165.rest.exceptions.ResourceAlreadyExistingException;
import cz.fi.muni.pa165.rest.exceptions.ResourceNotFoundException;
import cz.muni.fi.pa165.pokemons.facade.GymFacade;
import cz.muni.fi.pa165.pokemons.facade.TournamentFacade;
import cz.muni.fi.pa165.pokemons.facade.TrainerFacade;
import java.util.Collection;
import java.util.List;
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
 * @author Roman Gluszny
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_TRAINERS)
public class TrainerController {

    @Inject
    private TrainerFacade trainerFacade;

    @Inject
    private GymFacade gymFacade;

    @Inject
    private TournamentFacade tournamentFacade;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final TrainerDTO createTrainer(@RequestBody TrainerCreateDTO trainer) throws Exception {

        try {
            Long id = trainerFacade.createTrainer(trainer);
            return trainerFacade.getById(id);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteTrainer(@PathVariable("id") long id) throws Exception {
        try {
            trainerFacade.deleteTrainer(trainerFacade.getById(id));
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final TrainerDTO getTrainer(@PathVariable("id") long id) throws Exception {

        TrainerDTO trainerDTO = trainerFacade.getById(id);
        if (trainerDTO == null) {
            throw new ResourceNotFoundException();
        }
        return trainerDTO;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Collection<TrainerDTO> getTrainers() throws JsonProcessingException {
        return trainerFacade.getAllTrainers();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final List<TrainerDTO> getTrainerByNameAndSurname(@RequestParam("name") String name,
            @RequestParam(value = "surname") String surname) {

        List<TrainerDTO> trainerDTOs = trainerFacade.getTrainersByNameAndSurname(name, surname);
        if (trainerDTOs == null) {
            throw new ResourceNotFoundException();
        }
        return trainerDTOs;
    }

    @RequestMapping(value = "/{gym_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final TrainerDTO getTrainerByGym(@PathVariable("gym_id") long gymid) {

        TrainerDTO trainer = trainerFacade.getTrainerByGym(gymFacade.getGymById(gymid));
        if (trainer == null) {
            throw new ResourceNotFoundException();
        }
        return trainer;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean checkTrainerQualificationForTournament(@RequestParam("trainer_id") Long trainer_id,
            @RequestParam(value = "tournament_id") Long tournament_id) {

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
