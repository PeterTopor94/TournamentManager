package cz.muni.fi.pa165.pokemons.controllers;

import cz.muni.fi.pa165.pokemons.DTO.AddBadgeToTrainerDTO;
import cz.muni.fi.pa165.pokemons.DTO.BadgeDTO;
import cz.muni.fi.pa165.pokemons.DTO.GymDTO;
import cz.muni.fi.pa165.pokemons.DTO.PokemonDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import cz.muni.fi.pa165.pokemons.facade.BadgeFacade;
import cz.muni.fi.pa165.pokemons.facade.GymFacade;
import cz.muni.fi.pa165.pokemons.facade.PokemonFacade;
import cz.muni.fi.pa165.pokemons.facade.TrainerFacade;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

@Controller
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private TrainerFacade trainerFacade;

    @Autowired
    private BadgeFacade badgeFacade;

    @Autowired
    private GymFacade gymFacade;

    @Autowired
    private PokemonFacade pokemonFacade;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("trainers", trainerFacade.getAllTrainers());
        return "trainer/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, Model model, UriComponentsBuilder uriBuilder, RedirectAttributes redirectAttributes) {
        TrainerDTO trainer = trainerFacade.getById(id);
        trainerFacade.deleteTrainer(trainer);
        redirectAttributes.addFlashAttribute("alert_success", "Trainer \"" + trainer.getName() + " " + trainer.getSurname() + "\" was deleted.");
        return "redirect:" + uriBuilder.path("/trainer/list").toUriString();
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable long id, Model model) {
        model.addAttribute("trainer", trainerFacade.getById(id));
        return "trainer/view";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String add(@PathVariable long id, Model model) {
        AddBadgeToTrainerDTO addBadge = new AddBadgeToTrainerDTO();
        addBadge.setTrainerId(id);
        model.addAttribute("trainerAdd", addBadge);
        return "trainer/add";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newProduct(Model model) {
        model.addAttribute("trainerCreate", new TrainerCreateDTO());
        return "trainer/new";
    }

    @ModelAttribute("badges")
    public List<BadgeDTO> badges() {
        return badgeFacade.getAllBadges();
    }

    @ModelAttribute("pokemon")
    public List<PokemonDTO> pokemon() {
        return pokemonFacade.getAllPokemon();
    }

    @ModelAttribute("gyms")
    public List<GymDTO> gyms() {
        return gymFacade.getAllGyms();
    }

    @ModelAttribute("trainers")
    public List<TrainerDTO> trainers() {
        return trainerFacade.getAllTrainers();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("trainerCreate") TrainerCreateDTO formBean, BindingResult bindingResult,
            Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        if (bindingResult.hasErrors()) {

            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "trainer/new";
        }
        Long id = trainerFacade.createTrainer(formBean);

        redirectAttributes.addFlashAttribute("alert_success", "Trainer " + id + " was created");
        return "redirect:" + uriBuilder.path("/trainer/view/{id}").buildAndExpand(id).encode().toUriString();
    }

    @RequestMapping(value = "/foo", method = RequestMethod.POST)
    public String foo(@Valid @ModelAttribute("trainerAdd") AddBadgeToTrainerDTO formBean, BindingResult bindingResult,
            Model model, RedirectAttributes redirectAttributes, UriComponentsBuilder uriBuilder) {
        if (bindingResult.hasErrors()) {

            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "trainer/add";
        }
        Long id = formBean.getTrainerId();
        trainerFacade.addBadge(formBean.getTrainerId(), formBean.getBadgeId());

        redirectAttributes.addFlashAttribute("alert_success", "Badge " + formBean.getBadgeId() + " was added");
        return "redirect:" + uriBuilder.path("/trainer/view/{id}").buildAndExpand(id).encode().toUriString();
    }
    
    
}
