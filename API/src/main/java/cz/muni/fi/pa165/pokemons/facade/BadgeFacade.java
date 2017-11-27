/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.facade;

import java.util.List;
import cz.muni.fi.pa165.pokemons.DTO.BadgeDTO;

/**
 *
 * @author lubos.beno
 */
public interface BadgeFacade {

    public void createBadge(BadgeDTO b);

    public void removeBadge(BadgeDTO b);

    public List<BadgeDTO> getAllBadges();
}
