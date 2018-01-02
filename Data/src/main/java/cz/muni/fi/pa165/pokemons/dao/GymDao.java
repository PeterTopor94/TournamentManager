package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;

import java.util.List;

/**
 *
 * @author Peter Topor
 */
public interface GymDao {

    /**
     * Adds new Gym
     * @param gym Gym to be added
     * @throws IllegalArgumentException
     */
    Long create(Gym gym);

    /**
     * Removes Gym
     * @param gym Gym to be removed
     * @throws IllegalArgumentException
     */
    void remove(Gym gym);

    /**
     * Returns all Gyms
     * @return list of all Gyms
     */
    List<Gym> getAllGyms();

    /**
     * Returns Gym by Id
     * @param id of Gym to be returned
     * @return Gym
     */
    Gym getGymById(Long id);

    /**
     * Returns Gym by City
     * @param city of Gym to be returned
     * @return Gym
     */
    Gym getGymByCity(String city);

    /**
     * Returns Gym by Leader
     * @param leader of Gym to be returned
     * @return Gym
     */
    Gym getGymByLeader(Trainer leader);

    /**
     * Returns Gym by Badge
     * @param badge of Gym to be returned
     * @return Gym
     */
    Gym getGymByBadge(Badge badge);

    /**
     * Updates Gym
     * @param gym Gym to be updated
     * @throws IllegalArgumentException
     */
    void update(Gym gym);
    }
