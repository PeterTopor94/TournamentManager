package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Trainer;
import java.util.List;

/**
 * DAO interface for object Trainer
 * defines methods for data operations
 * @author Matus Krska
 */
public interface TrainerDao
{

    /**
     * Creates new trainer
     * @param t trainer to create
     */
    public void create(Trainer t);


    /**
     * Removes a trainer
     * @param t trainer to remove
     * @throws IllegalArgumentException
     */
    public void remove(Trainer t) throws IllegalArgumentException;

    /**
     * Finds a trainer by id
     * @param id id of trainer
     */
    public Trainer findById(Long id);

    /**
     * Finds all trainers
     */
    public List<Trainer> findAll();

    /**
     * Finds trainers by name and surname
     * @param name name of trainer
     * @param surname surname of trainer
     * @return
     */
    public List<Trainer> findByNameAndSurname(String name, String surname);
}
