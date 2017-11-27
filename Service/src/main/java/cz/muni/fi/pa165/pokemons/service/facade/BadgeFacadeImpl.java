/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.service.facade;

import cz.muni.fi.pa165.pokemons.DTO.BadgeDTO;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.facade.BadgeFacade;
import cz.muni.fi.pa165.pokemons.service.BadgeService;
import cz.muni.fi.pa165.pokemons.service.BeanMappingService;
import cz.muni.fi.pa165.pokemons.service.GymService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lubos.beno
 */
public class BadgeFacadeImpl implements BadgeFacade {

    @Autowired
    private GymService gymService;

    @Autowired
    private BadgeService badgeService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public void createBadge(BadgeDTO b) {
        Badge mappedBadge = beanMappingService.mapTo(b, Badge.class);
        mappedBadge.setCityOfOrigin(gymService.findById(b.getId()).getCityName());
        mappedBadge.setGym(gymService.findById(b.getId()));
        badgeService.createBadge(mappedBadge);
    }

    @Override
    public void removeBadge(BadgeDTO b) {
        badgeService.deleteBadge(badgeService.findById(b.getId()));
    }

    @Override
    public List<BadgeDTO> getAllBadges() {
        return beanMappingService.mapTo(badgeService.findAll(), BadgeDTO.class);
    }

}
