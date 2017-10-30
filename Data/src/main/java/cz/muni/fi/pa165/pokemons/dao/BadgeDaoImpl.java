/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lubos.beno
 */
@Repository
public class BadgeDaoImpl implements BadgeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Badge badge) {
        em.persist(badge);
    }

    @Override
    public void remove(Badge badge) {
        em.remove(badge);
    }

    @Override
    public Badge findById(Long id) {
        return em.find(Badge.class, id);
    }

    @Override
    public void update(Badge badge) {
        em.persist(badge);
    }

    @Override
    public List<Badge> findAll() {
        return em.createQuery("SELECT b FROM Badge b", Badge.class).getResultList();
    }

    @Override
    public List<Badge> findByOwner(Trainer trainer) {
        return em.createQuery("SELECT b FROM Badge b WHERE b.owners = :ownerid", Badge.class).setParameter("ownerid", trainer).getResultList();
    }

}
