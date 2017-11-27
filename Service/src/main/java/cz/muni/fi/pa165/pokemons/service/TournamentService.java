/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.service;

import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import java.util.List;

/**
 *
 * @author Miroslav
 */
public interface TournamentService {
     void createTournament(Tournament tournament);
   
     void removeTrainer(Tournament tournament, Trainer trainer); 
             
     void removeTournament(Tournament tournament);
     
     void setNameOfTournament(Tournament tournament, String name);
   
    List<Tournament> getAllTournaments();
    
   
    void updateTournaments(Tournament turnament) throws IllegalArgumentException;
 
   
    List<Tournament> findAllTournaments();
    
   
     Tournament findTournmanetById(Long id);
    
  
  Tournament findTournamentByName(String name);
}
