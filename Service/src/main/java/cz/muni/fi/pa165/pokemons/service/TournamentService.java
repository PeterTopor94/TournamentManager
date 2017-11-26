/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.service;

import cz.muni.fi.pa165.pokemons.entities.Tournament;
import java.util.List;

/**
 *
 * @author Miroslav
 */
public interface TournamentService {
     void create(Tournament tournament);
   
    
     void remove(Tournament tournament);
    
   
    List<Tournament> getAllTournaments();
    
   
    void update(Tournament turnament) throws IllegalArgumentException;
 
   
    List<Tournament> findAll();
    
   
     Tournament findById(Long id);
    
  
  Tournament findByName(String name);
}
