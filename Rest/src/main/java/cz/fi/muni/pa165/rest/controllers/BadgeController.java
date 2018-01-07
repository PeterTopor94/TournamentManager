package cz.fi.muni.pa165.rest.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.fi.muni.pa165.rest.ApiUris;
import cz.muni.fi.pa165.pokemons.DTO.BadgeCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.BadgeDTO;
import cz.fi.muni.pa165.rest.exceptions.ResourceAlreadyExistingException;
import cz.fi.muni.pa165.rest.exceptions.ResourceNotFoundException;
import cz.muni.fi.pa165.pokemons.facade.BadgeFacade;
import java.util.Collection;
import javax.inject.Inject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lubos.beno
 */
@RestController
@RequestMapping(ApiUris.ROOT_URI_BADGES)
public class BadgeController {

    @Inject
    private BadgeFacade badgeFacade;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final BadgeDTO createBadge(@RequestBody BadgeCreateDTO badge) throws Exception {

        try {
            Long id = badgeFacade.createBadge(badge);
            return badgeFacade.getById(id);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deleteBadge(@PathVariable("id") long id) throws Exception {
        try {
            badgeFacade.removeBadge(badgeFacade.getById(id));
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final BadgeDTO getBadge(@PathVariable("id") long id) throws Exception {

        BadgeDTO badgeDTO = badgeFacade.getById(id);
        if (badgeDTO == null) {
            throw new ResourceNotFoundException();
        }
        return badgeDTO;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Collection<BadgeDTO> getBadges() throws JsonProcessingException {
        return badgeFacade.getAllBadges();
    }

}
