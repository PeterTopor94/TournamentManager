/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Miroslav
 */
public class TournamentController {
    
}
