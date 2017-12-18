package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Pokemon;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
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
                .createQuery("SELECT p from Pokemon p WHERE p.owner.id = :ownerid",
                        Pokemon.class).setParameter("ownerid", t.getId())
                .getResultList();
    }

    @Override
    public List<Pokemon> getPokemonsWithName(String name) {
        try {
            return em
                    .createQuery("SELECT p FROM Pokemon p WHERE name = :name",
                            Pokemon.class).setParameter("name", name)
                    .getResultList();
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
                    .getResultList();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    @Override
    public List<Pokemon> getPokemonsWithtype(PokemonType t) {
        try {
            return em
                    .createQuery("SELECT p FROM Pokemon p WHERE type = :type",
                            Pokemon.class).setParameter("type", t)
                    .getResultList();
        } catch (NoResultException nrf) {
            return null;
        }
    }

}
