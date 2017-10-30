/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import java.util.List;
/**
 *
 * @author Miroslav
 */
public interface TournamentDao {
    

     /**
     * Adds new Tournament
     * @param tournament Gym to be added
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
     * Returns Tournament by Id
     * @param id of Gym to be returned
     * @return Trainer
     */
    public Gym getGymById(Long id);
    
    
    
    
    
    
    
    
    
    
    
    
    
}
