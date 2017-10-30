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
    public void create(Badge badge);

    /**
     * Removes Badge
     *
     * @param badge Badge to be removed
     */
    public void remove(Badge badge);

    /**
     * Returns Badge by Id
     *
     * @param id of the Badge to be returned
     * @return Badge
     */
    public Badge findById(Long id);

    /**
     * Updates Badge
     *
     * @param badge Badge that will be updated
     */
    public void update(Badge badge);

    /**
     * Returns all Badges
     *
     * @return list of all Badges
     */
    public List<Badge> findAll();

    /**
     * Returns Badges by Trainer
     *
     * @param trainer of Trainer whom badges to be returned
     * @return
     */
    public List<Badge> findByOwner(Trainer trainer);

}
