package cz.fi.muni.pa165.rest.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.fi.muni.pa165.rest.ApiUris;
import cz.muni.fi.pa165.pokemons.DTO.GymCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.GymDTO;
import cz.fi.muni.pa165.rest.exceptions.ResourceAlreadyExistingException;
import cz.fi.muni.pa165.rest.exceptions.ResourceNotFoundException;
import cz.muni.fi.pa165.pokemons.facade.GymFacade;
import cz.muni.fi.pa165.pokemons.facade.BadgeFacade;
import cz.muni.fi.pa165.pokemons.facade.TournamentFacade;
import cz.muni.fi.pa165.pokemons.facade.TrainerFacade;
import java.util.Collection;
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
 * @author lubos.beno
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_GYMS)
public class GymController {

    @Inject
    private BadgeFacade badgeFacade;
    
    @Inject
    private TrainerFacade trainerFacade;

    @Inject
    private GymFacade gymFacade;

    @Inject
    private TournamentFacade tournamentFacade;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final GymDTO createGym(@RequestBody GymCreateDTO gym) throws Exception {

        try {
            Long id = gymFacade.createGym(gym);
            return gymFacade.getGymById(id);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteGym(@PathVariable("id") long id) throws Exception {
        try {
            gymFacade.deleteGym(gymFacade.getGymById(id));
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final GymDTO getGym(@PathVariable("id") long id) throws Exception {

        GymDTO gymDTO = gymFacade.getGymById(id);
        if (gymDTO == null) {
            throw new ResourceNotFoundException();
        }
        return gymDTO;
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final GymDTO getGymByCity(@RequestParam("cityName") String cityName) {

        GymDTO gymDTO = gymFacade.getGymByCity(cityName);
        if (gymDTO == null) {
            throw new ResourceNotFoundException();
        }
        return gymDTO;
    }
    
     @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final GymDTO getGymByBadge(@RequestParam("badge_id") long badge_id) {

        GymDTO gymDTO = gymFacade.getGymByBadge(badgeFacade.getById(badge_id));
        if (gymDTO == null) {
            throw new ResourceNotFoundException();
        }
        return gymDTO;
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final GymDTO getGymByLeader(@RequestParam("trainer_id") long trainer_id) {

        GymDTO gymDTO = gymFacade.getGymByLeader(trainerFacade.getById(trainer_id));
        if (gymDTO == null) {
            throw new ResourceNotFoundException();
        }
        return gymDTO;
    }
    

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Collection<GymDTO> getGyms() throws JsonProcessingException {
        return gymFacade.getAllGyms();
    }

}
