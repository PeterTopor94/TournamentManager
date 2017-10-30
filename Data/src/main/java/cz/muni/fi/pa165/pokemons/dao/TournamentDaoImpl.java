/*

 */
package cz.muni.fi.pa165.pokemons.dao;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.lang.UnsupportedOperationException;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import cz.muni.fi.pa165.pokemons.entities.Pokemon;        
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import org.hibernate.internal.log.ConnectionPoolingLogger;
import org.hibernate.internal.log.DeprecationLogger;
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
    public Tournament getTournamentById(Long id) {
       return em.createQuery("SELECT t FROM Tournament t WHERE t.id = :tid", 
                Tournament.class).setParameter("tid", id).getSingleResult();
    }

    @Override
    public Tournament getTournamentByName(String name) {
        return em.createQuery("SELECT t FROM Tournament t WHERE t.name = :tname",
                Tournament.class).setParameter("tname", name).getSingleResult();
    }
    
}
