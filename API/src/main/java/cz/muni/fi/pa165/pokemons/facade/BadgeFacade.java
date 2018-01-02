package cz.muni.fi.pa165.pokemons.facade;

import cz.muni.fi.pa165.pokemons.DTO.BadgeCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.BadgeDTO;

import java.util.List;

/**
 *
 * @author lubos.beno
 */
public interface BadgeFacade {

    Long createBadge(BadgeCreateDTO b);

    void removeBadge(BadgeDTO b);

    List<BadgeDTO> getAllBadges();
    
    BadgeDTO getById(Long id);
}
