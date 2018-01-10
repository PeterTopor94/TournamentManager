package cz.muni.fi.pa165.pokemons.service.facade;

import cz.muni.fi.pa165.pokemons.DTO.BadgeCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.BadgeDTO;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.facade.BadgeFacade;
import cz.muni.fi.pa165.pokemons.service.BadgeService;
import cz.muni.fi.pa165.pokemons.service.BeanMappingService;
import cz.muni.fi.pa165.pokemons.service.GymService;
import cz.muni.fi.pa165.pokemons.service.TrainerService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lubos.beno
 */
@Service
@Transactional
public class BadgeFacadeImpl implements BadgeFacade {

    @Autowired
    private GymService gymService;

    @Autowired
    private BadgeService badgeService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private BeanMappingService beanMappingService;

    public BadgeFacadeImpl(GymService gymService, BeanMappingService beanMappingService, BadgeService badgeService, TrainerService trainerService) {
        this.gymService = gymService;
        this.beanMappingService = beanMappingService;
        this.badgeService = badgeService;
        this.trainerService = trainerService;
    }

    @Override
    public Long createBadge(BadgeCreateDTO b) {
        Badge mappedBadge = beanMappingService.mapTo(b, Badge.class);
        mappedBadge.setGym(gymService.findById(b.getGymId()));
        mappedBadge.setCityOfOrigin(b.getCityOfOrigin());
        return badgeService.createBadge(mappedBadge);
    }

    @Override
    public void removeBadge(BadgeDTO b) {
        badgeService.deleteBadge(badgeService.findById(b.getId()));
    }

    @Override
    public List<BadgeDTO> getAllBadges() {
        return beanMappingService.mapTo(badgeService.findAll(), BadgeDTO.class);
    }

    @Override
    public BadgeDTO getById(Long id) {
        Badge badge = badgeService.findById(id);
        return (badge == null) ? null : beanMappingService.mapTo(badge, BadgeDTO.class);
    }

    @Override
    public boolean addOwner(Long trainerId, Long badgeId) {
	return badgeService.addOwner(trainerService.findTrainerById(trainerId),
				badgeService.findById(badgeId));    }

}