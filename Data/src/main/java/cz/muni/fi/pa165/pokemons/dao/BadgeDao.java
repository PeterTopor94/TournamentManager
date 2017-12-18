/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Badge;

import java.util.List;

/**
 *
 * @author lubos.beno
 */
public interface BadgeDao {

    /**
     * Creates new Badge
     *
     * @param badge Badge to be created
     */
    Long create(Badge badge) throws IllegalArgumentException;

    /**
     * Removes Badge
     *
     * @param badge Badge to be removed
     */
    void remove(Badge badge) throws IllegalArgumentException;

    /**
     * Returns Badge by Id
     *
     * @param id of the Badge to be returned
     * @return Badge
     */
    Badge findById(Long id);

    /**
     * Updates Badge
     *
     * @param badge Badge that will be updated
     */
    void update(Badge badge) throws IllegalArgumentException;

    /**
     * Returns all Badges
     *
     * @return list of all Badges
     */
    List<Badge> findAll();

  
}
