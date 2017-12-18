/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Badge;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author lubos.beno
 */
@Repository
public class BadgeDaoImpl implements BadgeDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * Creates new Badge
     *
     * @param badge Badge to be created
     */
    @Override
    public Long create(Badge badge) {
        em.persist(badge);
        return badge.getId();
    }
    
    /**
     * Removes Badge
     *
     * @param badge Badge to be removed
     */
    @Override
    public void remove(Badge badge) {
        em.remove(badge);
    }
    
    /**
     * Returns Badge by Id
     *
     * @param id of the Badge to be returned
     * @return Badge
     */
    @Override
    public Badge findById(Long id) {
        return em.find(Badge.class, id);
    }
    
    /**
     * Updates Badge
     *
     * @param badge Badge that will be updated
     */
    @Override
    public void update(Badge badge) {
        em.persist(badge);
    }
    
    /**
     * Returns all Badges
     *
     * @return list of all Badges
     */
    @Override
    public List<Badge> findAll() {
        return em.createQuery("SELECT b FROM Badge b", Badge.class).getResultList();
    }
}
