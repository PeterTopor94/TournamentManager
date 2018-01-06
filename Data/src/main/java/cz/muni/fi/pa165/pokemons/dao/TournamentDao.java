package cz.muni.fi.pa165.pokemons.dao;

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
     void create(Tournament tournament);
   
     /**
     * Removes Tournament
     * @param tournament Gym to be removed
     * @throws IllegalArgumentException
     */
     void remove(Tournament tournament);
    
    /**
     * Returns all Tournaments
     * @return list of all Tournament
     */
    List<Tournament> getAllTournaments();
    
    /**
     * Updates existing trainer
     * @param turnament
     */
    void update(Tournament turnament) throws IllegalArgumentException;
 
    /**
     * Returns All Tournaments
     * @return list of Tournaments
     */
    List<Tournament> findAll();
    
     /**
     * Returns Tournament by Id
     * @param id of Tournament to be returned
     * @return Tournament
     */
     Tournament findById(Long id);
    
  /**
     * Returns Tournament by name
     * @param tournamentName of Tournament to be returned
     * @return Tournament
     */
  Tournament findByName(String tournamentName);
}
