package cz.muni.fi.pa165.pokemons.service.facade;

import cz.muni.fi.pa165.pokemons.DTO.*;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.facade.GymFacade;
import cz.muni.fi.pa165.pokemons.service.BadgeService;
import cz.muni.fi.pa165.pokemons.service.BeanMappingService;
import cz.muni.fi.pa165.pokemons.service.GymService;
import cz.muni.fi.pa165.pokemons.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * implementation of {@link GymFacade}
 * @author Matus Krska
 */
@Service
@Transactional
public class GymFacadeImpl implements GymFacade
{

    public GymFacadeImpl(GymService gymService, BeanMappingService beanMappingService, TrainerService trainerService, BadgeService badgeService)
    {
        this.gymService = gymService;
        this.beanMappingService = beanMappingService;
        this.trainerService = trainerService;
        this.badgeService = badgeService;
    }

    @Autowired
    private GymService gymService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private BadgeService badgeService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public Long createGym(GymCreateDTO gym)
    {
        Gym mappedGym = beanMappingService.mapTo(gym, Gym.class);
        mappedGym.setGymLeader(trainerService.findTrainerById(gym.getGymLeaderId()));
        if(gym.getBadgeId() != null)
        {
            mappedGym.setBadge(badgeService.findById(gym.getBadgeId()));
        }
        return gymService.createGym(mappedGym);
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
        Gym gym = gymService.findById(id);
        return (gym == null) ? null : beanMappingService.mapTo(gym, GymDTO.class);
    }

    @Override
    public GymDTO getGymByCity(String cityName)
    {
        Gym gym = gymService.findGymByCity(cityName);
        return (gym == null) ? null : beanMappingService.mapTo(gym, GymDTO.class);
    }

    @Override
    public GymDTO getGymByLeader(TrainerDTO gymLeader)
    {
        Gym gym = gymService.findGymByGymLeader(beanMappingService.mapTo(gymLeader, Trainer.class));
        return (gym == null) ? null : beanMappingService.mapTo(gym, GymDTO.class);
    }

    @Override
    public GymDTO getGymByBadge(BadgeDTO badge)
    {
        Gym gym = gymService.findGymByBadge(beanMappingService.mapTo(badge, Badge.class));
        return (gym == null) ? null : beanMappingService.mapTo(gym, GymDTO.class);
    }

    @Override
    public void changeTypology(NewGymTypologyDTO newTypology)
    {
        gymService.changeTypology(gymService.findById(newTypology.getGymId()), newTypology.getTypology());
    }
}
