package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import java.util.Date;

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
    Long create(Trainer t) throws IllegalArgumentException;


    /**
     * Updates existing trainer
     * @param t
     */
    void update(Trainer t) throws IllegalArgumentException;

    /**
     * Removes a trainer
     * @param t trainer to remove
     * @throws IllegalArgumentException
     */
    void remove(Trainer t) throws IllegalArgumentException;

    /**
     * Finds a trainer by id
     * @param id id of trainer
     */
    Trainer findById(Long id);

    /**
     * Finds all trainers
     */
    List<Trainer> findAll();

    /**
     * Finds trainers by name and surname
     * @param name name of trainer
     * @param surname surname of trainer
     * @return
     */
    List<Trainer> findByNameAndSurname(String name, String surname);

    Trainer findByLogin(String login);

    public List<Trainer> findByBirthdate(Date birthdate);

    public Trainer findByGym(Gym gym);
}
