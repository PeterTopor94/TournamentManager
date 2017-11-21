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
        if (tournament.getId() != null) {
            throw new IllegalArgumentException("Can't create turnament that already exists.");
        }
      em.persist(tournament);
    }

    @Override
    public void remove(Tournament tournament) {
        if (tournament.getId() == null) {
            throw new IllegalArgumentException("Can't remove Tournament without ID as it does not exist");
        }
        em.remove(tournament);
    }

    @Override
    public List<Tournament> getAllTournaments() {
      return em.createQuery("SELECT t FROM Tournament t", Tournament.class).getResultList();
    }

    @Override
    public void update(Tournament turnament) throws IllegalArgumentException {
         if (turnament.getId() == null) {
            throw new IllegalArgumentException("Can't update Tournament without ID.");
        }
        em.persist(turnament);
    }

    @Override
    public Tournament findById(Long id) {
       return em.createQuery("SELECT t FROM Tournament t WHERE t.id = :tid", 
                Tournament.class).setParameter("tid", id).getSingleResult();
    }

    @Override
    public Tournament findByName(String name) {
        return em.createQuery("SELECT t FROM Tournament t WHERE t.name = :tname",
                Tournament.class).setParameter("tname", name).getSingleResult();
    }

    @Override
    public List<Tournament> findAll() {
        return em.createQuery("SELECT t FROM Tournament t",
                Tournament.class).getResultList();
    }
    
}
