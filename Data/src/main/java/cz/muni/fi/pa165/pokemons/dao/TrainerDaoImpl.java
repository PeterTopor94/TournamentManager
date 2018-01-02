package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Implementation of {@link TrainerDao}
 */
@Repository
public class TrainerDaoImpl implements TrainerDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Long create(Trainer t) {
        if (t.getId() != null) {
            throw new IllegalArgumentException("Can't create Trainer that already exists.");
        }
        em.persist(t);
        return t.getId();
    }

    @Override
    public void update(Trainer t) throws IllegalArgumentException {
        if (t.getId() == null) {
            throw new IllegalArgumentException("Can't update Trainer without ID.");
        }
        em.persist(t);
    }

    @Override
    public void remove(Trainer t) {
        if (t.getId() == null) {
            throw new IllegalArgumentException("Can't remove Trainer without ID.");
        }
        em.remove(t);
    }

    @Override
    public Trainer findById(Long id) {
        return em.find(Trainer.class, id);
    }

    @Override
    public List<Trainer> findAll() {
        return em.createQuery("SELECT t FROM Trainer t", Trainer.class).getResultList();
    }

    @Override
    public List<Trainer> findByNameAndSurname(String name, String surname) {
        TypedQuery<Trainer> query = em.createQuery("SELECT t FROM Trainer t WHERE t.name = :name and t.surname = :surname", Trainer.class);
        query.setParameter("name", name);
        query.setParameter("surname", surname);

        return query.getResultList();
    }

    @Override
    public List<Trainer> findByBirthdate(Date birthdate) {
        return em.createQuery("SELECT t FROM Trainer t WHERE t.dateOfBirth = :date"
                , Trainer.class).setParameter("date", birthdate).getResultList();
    }

    @Override
    public Trainer findByGym(Gym gym) {
        return em.createQuery("SELECT t FROM Trainer t WHERE t.gym = :gymid",
                Trainer.class).setParameter("gymid", gym).getSingleResult();
    }

    @Override
    public Trainer findByLogin(String login) throws NoResultException
    {
        return em.createQuery("SELECT t FROM Trainer t WHERE t.login = :login",
                Trainer.class).setParameter("login", login).getSingleResult();
    }
}
