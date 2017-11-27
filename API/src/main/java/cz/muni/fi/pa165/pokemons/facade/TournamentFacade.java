/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.facade;

import cz.muni.fi.pa165.pokemons.DTO.TournamentDTO;
import java.util.List;

/**
 *
 * @author Miroslav
 */
public interface TournamentFacade {
   
     Long create(TournamentDTO tournament);
   
     void removTrainer(Long idTournament, Long idTrainer);
     
     void removeTournament(Long id);
    
     void setNameOfTournament(Long id, String name);
     
    List<TournamentDTO> getAllTournaments();
    
    List<TournamentDTO> findAll();
    
    TournamentDTO findById(Long id);
    
    TournamentDTO findByName(String name);
   
   
 
   
   
    
  
 

  
}
