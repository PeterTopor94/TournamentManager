/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Badge;
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
    public void create(Badge b) {
        em.persist(b);
    }

    @Override
    public void remove(Badge b) {
        em.remove(b);
    }

    @Override
    public Badge findById(Long id) {
        return em.find(Badge.class, id);
    }

    @Override
    public void update(Badge b) {
       
    }

    @Override
    public List<Badge> findAll() {
        return em.createQuery("SELECT badge FROM Badge badge", Badge.class).getResultList();
    }

    @Override
    public List<Badge> findByOwner(Trainer t) {
       return em.createQuery("SELECT badge FROM Badge badge WHERE badge.owner = :ownerid", Badge.class).query.setParameter("ownerid",t).getResultList();
    }
    
    
}
