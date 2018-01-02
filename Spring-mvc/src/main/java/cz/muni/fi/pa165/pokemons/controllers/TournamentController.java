/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.controllers;
import cz.muni.fi.pa165.pokemons.DTO.TournamentCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.TournamentDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.facade.PokemonFacade;
import cz.muni.fi.pa165.pokemons.facade.TournamentFacade;
import cz.muni.fi.pa165.pokemons.facade.TrainerFacade;
import cz.muni.fi.pa165.pokemons.forms.PokemonCreateDTOValidator;
import cz.muni.fi.pa165.pokemons.forms.TournamentCreateDTOValidator;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;
/**
 * MVC Controller for object Tournament
 * @author Miroslav
 */

@Controller
@RequestMapping("/tournament")
public class TournamentController {
  
    @Inject
    private TournamentFacade tournamentFacade;
    
    @Inject
    private TrainerFacade trainerFacade;
    
    @ModelAttribute("tournaments")
    public List<TournamentDTO> pokemons() {
        return tournamentFacade.getAllTournaments();
    }
    
    @ModelAttribute("trainers")
    public List<TrainerDTO> trainers()
    {
        return trainerFacade.getAllTrainers();
    }


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof TournamentCreateDTO) {
            binder.addValidators(new TournamentCreateDTOValidator());
        }
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("tournaments", tournamentFacade.getAllTournaments());
        return "tournament/list";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newPlayer(Model model) {
        model.addAttribute("tournamentCreate", new TournamentCreateDTO());
        return "tournament/new";
    }
    
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable long id, Model model) {
        model.addAttribute("tournament", tournamentFacade.findById(id));
        return "tournament/view";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("tournamentCreate") TournamentCreateDTO form,
                         BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,
                         UriComponentsBuilder urisBuilder) {
        if (bindingResult.hasErrors()) {
            for (FieldError error: bindingResult.getFieldErrors()) {
                model.addAttribute(error.getField() + "_error", true);
            }
            return "tournament/new";
        }

        Long id = tournamentFacade.createTournament(form);

        redirectAttributes.addFlashAttribute("alert_success", "Tournament " + form.getName() + " was created successfully");
        return "redirect:" + urisBuilder.path("/tournament/view/{id}").buildAndExpand(id).encode().toUriString();
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, Model model, UriComponentsBuilder uriBuilder,
                         RedirectAttributes redirectAttributes) {
        tournamentFacade.removeTournament(id);

        redirectAttributes.addFlashAttribute("alert_success", "Tournament " + id + " was deleted");
        return "redirect:" + uriBuilder.path("/tournament/list").toUriString();
    }
   
}
