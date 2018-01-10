package cz.muni.fi.pa165.pokemons.controllers;

import cz.muni.fi.pa165.pokemons.DTO.GymCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.GymDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.facade.GymFacade;
import cz.muni.fi.pa165.pokemons.facade.TrainerFacade;
import cz.muni.fi.pa165.pokemons.forms.GymCreateDTOValidator;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * MVC Controller for object gym
 * @author Matus Krska 410073
 */
@Controller
@RequestMapping("/gym")
public class GymController {

    @Inject
    private GymFacade gymFacade;
    @Inject
    private TrainerFacade trainerFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("gyms", gymFacade.getAllGyms());
        return "gym/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, Model model, UriComponentsBuilder uriBuilder,
                         RedirectAttributes redirectAttributes) {
        GymDTO gymDTO = gymFacade.getGymById(id);
        gymFacade.deleteGym(gymDTO);

        redirectAttributes.addFlashAttribute("alert_success", "Gym " + gymDTO.getId() + " was deleted");
        return "redirect:" + uriBuilder.path("/gym/list").toUriString();
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable long id, Model model) {
        model.addAttribute("gym", gymFacade.getGymById(id));
        return "gym/view";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newPlayer(Model model) {
        model.addAttribute("gymCreate", new GymCreateDTO());
        return "gym/new";
    }


    @ModelAttribute("typologies")
    public PokemonType[] typologies() {
        return PokemonType.values();
    }

    @ModelAttribute("trainers")
    public List<TrainerDTO> trainers()
    {
        List<TrainerDTO> withoutGyms = new ArrayList<>();
        for(TrainerDTO trainer : trainerFacade.getAllTrainers())
        {
            if(trainer.getGym() == null)
            {
                withoutGyms.add(trainer);
            }
        }

        return withoutGyms;
    }


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof GymCreateDTO) {
            binder.addValidators(new GymCreateDTOValidator());
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("gymCreate") GymCreateDTO form,
                         BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,
                         UriComponentsBuilder urisBuilder) {
        if (bindingResult.hasErrors()) {
            for (FieldError error: bindingResult.getFieldErrors()) {
                model.addAttribute(error.getField() + "_error", true);
            }
            return "gym/new";
        }

        Long id = gymFacade.createGym(form);

        redirectAttributes.addFlashAttribute("alert_success", "Gym in city " + form.getCityName() + " was created successfully");
        return "redirect:" + urisBuilder.path("/gym/view/{id}").buildAndExpand(id).encode().toUriString();
    }

}
