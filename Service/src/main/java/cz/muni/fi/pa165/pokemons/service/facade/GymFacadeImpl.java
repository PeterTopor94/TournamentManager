package cz.muni.fi.pa165.pokemons.service.facade;

import cz.muni.fi.pa165.pokemons.DTO.GymCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.GymDTO;
import cz.muni.fi.pa165.pokemons.DTO.NewGymTypologyDTO;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.facade.GymFacade;
import cz.muni.fi.pa165.pokemons.service.BeanMappingService;
import cz.muni.fi.pa165.pokemons.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GymFacadeImpl implements GymFacade
{

    @Autowired
    private GymService gymService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private BadgeService badgeService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public void createGym(GymCreateDTO gym)
    {
        Gym mappedGym = beanMappingService.mapTo(gym, Gym.class);
        mappedGym.setGymLeader(trainerService.getTrainerById(gym.getGymLeaderId()));
        mappedGym.setBadge(badgeService.getBadgeById(gym.getBadgeId()));

        gymService.createGym(mappedGym);
    }

    @Override
    public void deleteGym(GymDTO gym)
    {
        gymService.deleteGym(gymService.findById(gym.getId()));
    }

    @Override
    public List<GymDTO> getAllGyms()
    {
        return beanMappingService.mapTo(gymService.findAllGyms(),
                GymDTO.class);
    }

    @Override
    public GymDTO getGymById(Long id)
    {
        Gym gym = orderService.findGymById(id);
        return (gym == null) ? null : beanMappingService.mapTo(gym, GymDTO.class);
    }

    @Override
    public GymDTO getGymByCity(String cityName)
    {
        Gym gym = orderService.findGymByCity(cityName);
        return (gym == null) ? null : beanMappingService.mapTo(gym, GymDTO.class);
    }

    @Override
    public GymDTO getGymByLeader(TrainerDTO gymLeader)
    {
        Gym gym = orderService.findGymByGymLeader(beanMappingService.mapTo(gymLeader, Trainer.class));
        return (gym == null) ? null : beanMappingService.mapTo(gym, GymDTO.class);
    }

    @Override
    public GymDTO getGymByBadge(BadgeDTO badge)
    {
        Gym gym = orderService.findGymByBadge(beanMappingService.mapTo(badge, Badge.class));
        return (gym == null) ? null : beanMappingService.mapTo(gym, GymDTO.class);
    }

    @Override
    public void changeTypology(NewGymTypologyDTO newTypology)
    {
        gymService.changeTypology(gymService.findById(newTypology.getGymId()), newTypology.getTypology());
    }
}
