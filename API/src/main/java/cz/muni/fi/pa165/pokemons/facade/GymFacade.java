package cz.muni.fi.pa165.pokemons.facade;

import cz.muni.fi.pa165.pokemons.DTO.GymCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.GymDTO;
import cz.muni.fi.pa165.pokemons.DTO.NewGymTypologyDTO;

import java.util.List;

/**
 * Interface for facade layer of Gym object
 * @author Matus Krska
 */
public interface GymFacade
{
    void createGym(GymCreateDTO gym);

    void deleteGym(GymDTO gym);

    List<GymDTO> getAllGyms();

    GymDTO getGymById(Long id);

    GymDTO getGymByCity(String cityName);

    GymDTO getGymByLeader(TrainerDTO gymLeader);

    GymDTO getGymByBadge(BadgeDTO badge);

    void changeTypology(NewGymTypologyDTO gymTypologyDTO);


}
