package cz.muni.fi.pa165.pokemons.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roman Gluszny
 */
@Repository
public class PokemonDaoImpl implements PokemonDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Pokemon p) {
        em.persist(p);
    }

    @Override
    public void remove(Pokemon p) {
        em.remove(p);
    }

    @Override
    public Pokemon findById(Long id) {
        return em.find(Pokemon.class, id);
    }

    @Override
    public List<Pokemon> findAll() {
        return em.createQuery("SELECT p FROM Pokemon p", Pokemon.class)
                .getResultList();
    }

    @Override
    public List<Pokemon> findByOwner(Trainer t) {
        return em
                .createQuery("SELECT p from Pokemon p WHERE p.owner = :ownerid",
                        Pokemon.class).query.setParameter("ownerid", t)
                .getResultList();
    }

    @Override
    public List<Pokemon> getPokemonsWithName(String name) {
        try {
            return em
                    .createQuery("SELECT p FROM Pokemon p WHERE name = :name",
                            Pokemon.class).setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    @Override
    public List<Pokemon> getPokemonsWithNickname(String nickname) {
        try {
            return em
                    .createQuery("SELECT p FROM Pokemon p WHERE nickname = :nickname",
                            Pokemon.class).setParameter("nickname", nickname)
                    .getSingleResult();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    @Override
    public List<Pokemon> getPokemonsWithtype(Type t) {
        try {
            return em
                    .createQuery("SELECT p FROM Pokemon p WHERE type = :type",
                            Pokemon.class).setParameter("type", t)
                    .getSingleResult();
        } catch (NoResultException nrf) {
            return null;
        }
    }

}
