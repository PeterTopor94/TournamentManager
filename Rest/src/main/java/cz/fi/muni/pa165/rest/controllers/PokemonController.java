package cz.fi.muni.pa165.rest.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.fi.muni.pa165.rest.ApiUris;
import cz.muni.fi.pa165.pokemons.DTO.BadgeCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.BadgeDTO;
import cz.fi.muni.pa165.rest.exceptions.ResourceAlreadyExistingException;
import cz.fi.muni.pa165.rest.exceptions.ResourceNotFoundException;
import cz.muni.fi.pa165.pokemons.DTO.PokemonCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.PokemonDTO;
import cz.muni.fi.pa165.pokemons.facade.BadgeFacade;
import cz.muni.fi.pa165.pokemons.facade.PokemonFacade;
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
@RequestMapping(ApiUris.ROOT_URI_POKEMONS)
public class PokemonController {

    @Inject
    private PokemonFacade pokemonFacade;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public final PokemonDTO createPokemon(@RequestBody PokemonCreateDTO pokemon) throws Exception {

        try {
            Long id = pokemonFacade.createPokemon(pokemon);
            return pokemonFacade.getPokemonById(id);
        } catch (Exception ex) {
            throw new ResourceAlreadyExistingException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final void deletePokemon(@PathVariable("id") long id) throws Exception {
        try {
            pokemonFacade.deletePokemon(id);
        } catch (Exception ex) {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final PokemonDTO getPokemon(@PathVariable("id") long id) throws Exception {

        PokemonDTO pokemonDTO = pokemonFacade.getPokemonById(id);
        if (pokemonDTO == null) {
            throw new ResourceNotFoundException();
        }
        return pokemonDTO;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Collection<PokemonDTO> getPokemons() throws JsonProcessingException {
        return pokemonFacade.getAllPokemon();
    }

}
