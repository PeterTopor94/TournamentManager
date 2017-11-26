/*

 */
package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Tournament;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
/**
 *
 * @author Miroslav
 */
@Repository
public class TournamentDaoImpl implements TournamentDao{
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void create(Tournament tournament) {
        
        if (tournament == null || getAllTournaments().contains(tournament)) {           
            throw new IllegalArgumentException
        ("Can't create turnament that already exists or the value of the tournament for creating is null.");
        }
      em.persist(tournament);
    }

    @Override
    public void remove(Tournament tournament) {
        
        if (tournament == null || !getAllTournaments().contains(tournament)) {
            throw new IllegalArgumentException("Can't remove Tournament which is null or the tournament is not registered");
        }
        em.remove(tournament);
    }

    @Override
    public List<Tournament> getAllTournaments() {
      return em.createQuery("SELECT t FROM Tournament t", Tournament.class).getResultList();
    }

    @Override
    public void update(Tournament tournament) throws IllegalArgumentException {
         if (tournament == null || tournament.getId() == null) {
            throw new IllegalArgumentException("Can't update Tournament which is null or without ID.");
        }
        em.persist(tournament);
    }

    @Override
    public Tournament findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Can't find Tournament without ID.");
        }
       return em.createQuery("SELECT t FROM Tournament t WHERE t.id = :tid", 
                Tournament.class).setParameter("tid", id).getSingleResult();
    }

    @Override
    public Tournament findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Can't find Tournament without name.");
        }
        return em.createQuery("SELECT t FROM Tournament t WHERE t.name = :tname",
                Tournament.class).setParameter("tname", name).getSingleResult();
    }

    @Override
    public List<Tournament> findAll() {
        return em.createQuery("SELECT t FROM Tournament t",
                Tournament.class).getResultList();
    }
    
}
