
package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import java.util.List;
/**
 *
 * @author Miroslav
 */
public interface TournamentDao {

     /**
     * Adds new Tournament
     * @param tournament Tournament to be added
     * @throws IllegalArgumentException
     */
    public void create(Tournament tournament);
   
     /**
     * Removes Tournament
     * @param tournament Gym to be removed
     * @throws IllegalArgumentException
     */
    public void remove(Tournament tournament);
    
    /**
     * Returns all Tournaments
     * @return list of all Tournament
     */
    public List<Tournament> getAllTournaments(); 
    
    /**
     * Updates existing trainer
     * @param turnament
     */
    public void update(Tournament turnament) throws IllegalArgumentException;
 
    /**
     * Returns All Tournaments
     * @return list of Tournaments
     */
    public List<Tournament> findAll();
    
     /**
     * Returns Tournament by Id
     * @param id of Tournament to be returned
     * @return Tournament
     */
    public Tournament findById(Long id);
    
  /**
     * Returns Tournament by name
     * @param name of Tournament to be returned
     * @return Tournament
     */
    public Tournament findByName(String name);  
}
