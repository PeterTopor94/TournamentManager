package cz.muni.fi.pa165.pokemons.controllers;

import cz.muni.fi.pa165.pokemons.DTO.PokemonCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.PokemonDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.facade.PokemonFacade;
import cz.muni.fi.pa165.pokemons.facade.TrainerFacade;
import cz.muni.fi.pa165.pokemons.forms.PokemonCreateDTOValidator;
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
 * MVC Controller for object pokemon
 * @author Peter Topor
 */
@Controller
@RequestMapping("/pokemon")
public class PokemonController {
    
    @Inject
    private PokemonFacade pokemonFacade;
    
    @Inject
    private TrainerFacade trainerFacade;
    
    @ModelAttribute("typologies")
    public PokemonType[] typologies() {
        return PokemonType.values();
    }
    
    @ModelAttribute("pokemons")
    public List<PokemonDTO> pokemons() {
        return pokemonFacade.getAllPokemon();
    }
    
    @ModelAttribute("trainers")
    public List<TrainerDTO> trainers()
    {
        return trainerFacade.getAllTrainers();
    }


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof PokemonCreateDTO) {
            binder.addValidators(new PokemonCreateDTOValidator());
        }
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("pokemons", pokemonFacade.getAllPokemon());
        return "pokemon/list";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newPlayer(Model model) {
        model.addAttribute("pokemonCreate", new PokemonCreateDTO());
        return "pokemon/new";
    }
    
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable long id, Model model) {
        model.addAttribute("pokemon", pokemonFacade.getPokemonById(id));
        return "pokemon/view";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("pokemonCreate") PokemonCreateDTO form,
                         BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,
                         UriComponentsBuilder urisBuilder) {
        if (bindingResult.hasErrors()) {
            for (FieldError error: bindingResult.getFieldErrors()) {
                model.addAttribute(error.getField() + "_error", true);
            }
            return "pokemon/new";
        }

        Long id = pokemonFacade.createPokemon(form);

        redirectAttributes.addFlashAttribute("alert_success", "Pokemon " + form.getName() + " was created successfully");
        return "redirect:" + urisBuilder.path("/pokemon/view/{id}").buildAndExpand(id).encode().toUriString();
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, Model model, UriComponentsBuilder uriBuilder,
                         RedirectAttributes redirectAttributes) {
        pokemonFacade.deletePokemon(id);

        redirectAttributes.addFlashAttribute("alert_success", "Pokemon " + id + " was deleted");
        return "redirect:" + uriBuilder.path("/pokemon/list").toUriString();
    }
    
}
