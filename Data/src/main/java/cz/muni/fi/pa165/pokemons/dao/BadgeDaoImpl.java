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

    @Override
    public Long create(Badge badge) {
        em.persist(badge);
        return badge.getId();
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
}
