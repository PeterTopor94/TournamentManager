package cz.muni.fi.pa165.pokemons.controllers;

import cz.muni.fi.pa165.pokemons.DTO.AuthenticateTrainerDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import cz.muni.fi.pa165.pokemons.facade.TrainerFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author Matus Krska
 */
@Controller
@RequestMapping("/")
public class LoginController
{

    @Inject
    TrainerFacade trainerFacade;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("authenticatedUser") != null) {
            return "redirect:/";
        }

        model.addAttribute("userLogin", new AuthenticateTrainerDTO());
        return "/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpServletRequest request) {

        if(request.getSession().getAttribute("authenticatedUser") != null)
        {
            request.getSession().removeAttribute("authenticatedUser");
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin(@Valid @ModelAttribute("userLogin") AuthenticateTrainerDTO form,
                            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,
                            UriComponentsBuilder uriBuilder, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                model.addAttribute(error.getField() + "_error", true);
            }

            model.addAttribute("userLogin", new AuthenticateTrainerDTO());
            return "/login";
        }

        TrainerDTO found = trainerFacade.getTrainerByLogin(form.getLogin());

        if (found == null || !trainerFacade.login(form))
        {
            redirectAttributes.addFlashAttribute("alert_warning", "Login with username "+form.getLogin()+" has failed.");
            return "redirect:" + uriBuilder.path("/login").toUriString();
        }

        request.getSession().setAttribute("authenticatedUser", found);

        redirectAttributes.addFlashAttribute("alert_success", "Login was successful");
        return "redirect:" + uriBuilder.path("/").toUriString();
    }
}
