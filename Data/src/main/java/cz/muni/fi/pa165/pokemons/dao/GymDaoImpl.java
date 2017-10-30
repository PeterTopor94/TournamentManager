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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Peter Topor
 */
@Repository
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
        return em.createQuery("SELECT g FROM Gym g", Gym.class).getResultList();
    }

    @Override
    public Gym getGymById(Long id) {
        return em.createQuery("SELECT g FROM Gym g WHERE g.id = :gymid", 
                Gym.class).setParameter("gymid", id).getSingleResult();
    }

    @Override
    public Gym getGymByCity(String city) {
        return em.createQuery("SELECT g FROM Gym g WHERE g.cityName = :gymcity",
                Gym.class).setParameter("gymcity", city).getSingleResult();
    }

    @Override
    public Gym getGymByLeader(Trainer leader) {
        return em.createQuery("SELECT g FROM Gym g WHERE g.gymLeader = :gymleader",
                Gym.class).setParameter("gymleader", leader).getSingleResult();
    }

    @Override
    public Gym getGymByBadge(Badge badge) {
        return em.createQuery("SELECT g FROM Gym g WHERE g.badge = :gymbadge",
                Gym.class).setParameter("gymbadge", badge).getSingleResult();
    }

    @Override
    public void update(Gym gym) {
        if (gym.getId() == null) {
            throw new IllegalArgumentException("Can't update Gym without ID.");
        }
        em.persist(gym);
    }

}
