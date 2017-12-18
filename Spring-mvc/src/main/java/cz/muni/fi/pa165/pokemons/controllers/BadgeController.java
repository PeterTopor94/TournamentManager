/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.controllers;

import cz.muni.fi.pa165.pokemons.DTO.BadgeCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.BadgeDTO;
import cz.muni.fi.pa165.pokemons.DTO.GymCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.GymDTO;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.facade.BadgeFacade;
import cz.muni.fi.pa165.pokemons.facade.GymFacade;
import cz.muni.fi.pa165.pokemons.forms.BadgeCreateDTOValidator;
import cz.muni.fi.pa165.pokemons.forms.GymCreateDTOValidator;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 *
 * @author lubos.beno
 */
@Controller
@RequestMapping("/badge")
public class BadgeController {

    @Inject
    private BadgeFacade badgeFacade;
    
    @Inject 
    private GymFacade gymFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("badges", badgeFacade.getAllBadges());
        return "badge/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, Model model, UriComponentsBuilder uriBuilder,
            RedirectAttributes redirectAttributes) {
        BadgeDTO badgeDTO = badgeFacade.getById(id);
        badgeFacade.removeBadge(badgeDTO);

        redirectAttributes.addFlashAttribute("alert_success", "Badge " + badgeDTO.getId() + " was deleted");
        return "redirect:" + uriBuilder.path("/badge/list").toUriString();
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable long id, Model model) {
        model.addAttribute("badge", badgeFacade.getById(id));
        return "badge/view";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newBadge(Model model) {
        model.addAttribute("badgeCreate", new BadgeCreateDTO());
        return "badge/new";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof BadgeCreateDTO) {
            binder.addValidators(new BadgeCreateDTOValidator());
        }
    }

    
    @ModelAttribute("gyms")
    public List<GymDTO> gyms() {
    return gymFacade.getAllGyms();
}
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("badgeCreate") BadgeCreateDTO form,
            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,
            UriComponentsBuilder urisBuilder) {
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                model.addAttribute(error.getField() + "_error", true);
            }
            return "badge/new";
        }

        Long id = badgeFacade.createBadge(form);

        redirectAttributes.addFlashAttribute("alert_success", "Badge in city " + form.getCityOfOrigin() + " was created successfully");
        return "redirect:" + urisBuilder.path("/badge/view/{id}").buildAndExpand(id).encode().toUriString();
    }

}
