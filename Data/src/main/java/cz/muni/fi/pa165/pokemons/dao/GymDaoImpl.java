/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Peter Topor
 */
public class GymDaoImpl implements GymDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Gym gym) {
        if (gym.getId() != null) {
            throw new IllegalArgumentException("Can't create Gym that already exists.");
        }
        em.persist(gym);
    }

    @Override
    public void remove(Gym gym) {
        if (gym.getId() == null) {
            throw new IllegalArgumentException("Can't remove Gym without ID.");
        }
        em.remove(gym);
    }

    @Override
    public List<Gym> getAllGyms() {
        return em.createQuery("SELECT * FROM Gym gym", Gym.class).getResultList();
    }

    @Override
    public Gym getGymById(Long id) {;
        return em.createQuery("SELECT * FROM Gym gym WHERE gym.id = :gymid", 
                Gym.class).setParameter("gymid", id).getSingleResult();
    }

    @Override
    public Gym getGymByCity(String city) {
        return em.createQuery("SELECT * FROM Gym gym WHERE gym.city = :gymcity",
                Gym.class).setParameter("gymcity", city).getSingleResult();
    }

    @Override
    public Gym getGymByLeader(Trainer leader) {
        return em.createQuery("SELECT * FROM Gym gym WHERE gym.leader_id = :gymleader",
                Gym.class).setParameter("gymleader", leader.getId()).getSingleResult();
    }

    @Override
    public Gym getGymByBadge(Badge badge) {
        return em.createQuery("SELECT * FROM Gym gym WHERE gym.badge_id = :gymbadge",
                Gym.class).setParameter("gymbadge", badge.getId()).getSingleResult();
    }

    @Override
    public void update(Gym gym) {
        if (gym.getId() == null) {
            throw new IllegalArgumentException("Can't update Gym without ID.");
        }
        em.persist(gym);
    }

}
