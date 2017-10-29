package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Trainer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Implementation of {@link TrainerDao}
 */
@Repository
public class TrainerDaoImpl implements TrainerDao
{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Trainer t)
    {
        em.persist(t);
    }

    @Override
    public void remove(Trainer t)
    {
        em.remove(t);
    }

    @Override
    public Trainer findById(Long id)
    {
        return em.find(Trainer.class, id);
    }

    @Override
    public List<Trainer> findAll()
    {
        return em.createQuery("SELECT t FROM Trainer t", Trainer.class).getResultList();
    }

    @Override
    public List<Trainer> findByNameAndSurname(String name, String surname)
    {
        TypedQuery<Trainer> query = em.createQuery("SELECT t FROM Trainer t WHERE t.name = :name and t.surname = :surname", Trainer.class);
        query.setParameter("name", name);
        query.setParameter("surname", surname);

        return query.getResultList();
    }
}
