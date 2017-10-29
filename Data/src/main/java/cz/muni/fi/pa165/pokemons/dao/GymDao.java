/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.entities.Badge;
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
    public void create(Gym gym);

    /**
     * Removes Gym
     * @param gym Gym to be removed
     * @throws IllegalArgumentException
     */
    public void remove(Gym gym);

    /**
     * Returns all Gyms
     * @return list of all Gyms
     */
    public List<Gym> getAllGyms();

    /**
     * Returns Gym by Id
     * @param id of Gym to be returned
     * @return Gym
     */
    public Gym getGymById(Long id);

    /**
     * Returns Gym by City
     * @param city of Gym to be returned
     * @return Gym
     */
    public Gym getGymByCity(String city);

    /**
     * Returns Gym by Leader
     * @param leader of Gym to be returned
     * @return Gym
     */
    public Gym getGymByLeader(Trainer leader);

    /**
     * Returns Gym by Badge
     * @param badge of Gym to be returned
     * @return Gym
     */
    public Gym getGymByBadge(Badge badge);

    /**
     * Updates Gym
     * @param gym Gym to be updated
     * @throws IllegalArgumentException
     */
    public void update(Gym gym);
    }
