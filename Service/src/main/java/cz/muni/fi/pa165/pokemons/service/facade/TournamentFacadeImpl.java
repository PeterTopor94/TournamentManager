/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.service.facade;
import com.google.inject.Inject;
import cz.muni.fi.pa165.pokemons.service.BeanMappingService;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.DTO.TournamentDTO;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.facade.TournamentFacade;
import cz.muni.fi.pa165.pokemons.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 *
 * @author Miroslav
 */
public class TournamentFacadeImpl implements TournamentFacade {

   @Inject
   private TrainerService trainerService;

    
    @Autowired
   private TournamentService tournamentService; 

    @Override
    public Long create(TournamentDTO tournament) {
  
     Tournament mappedTournament = beanMappingService.mapTo(tournament, Tournament.class);
     mappedTournament.setName(tournament.getName());
     tournamentService.createTournament(mappedTournament);
       return mappedTournament.getId();
    }

    @Override
    public void removTrainer(Long idTournament, Long idTrainer) {
       tournamentService.removeTrainer(tournamentService.findTournmanetById(idTournament),
       trainerService.findById(idTrainer));
    }

    @Override
    public void removeTournament(Long id) {
       
    tournamentService.removeTournament(tournamentService.findTournmanetById(id));    
    }

    @Override
    public void setNameOfTournament(Long id, String name) {
    
      tournamentService.setNameOfTournament(tournamentService.findTournmanetById(id), name);
    
    }

   
    @Override
    public List<TournamentDTO> getAllTournaments() {
   return beanMappingService.mapTo(tournamentService.getAllTournaments(),TournamentDTO.class);
    
    }

    @Override
    public List<TournamentDTO> findAll() {
       return beanMappingService.mapTo(tournamentService.findAllTournaments(),TournamentDTO.class);
    
    }

    @Override
    public TournamentDTO findById(Long id) {
     Tournament tournament = tournamentService.findTournmanetById(id);
      return (tournament == null) ? null : beanMappingService.mapTo(tournament,TournamentDTO.class);  
    
    }

    @Override
    public TournamentDTO findByName(String name) {
     Tournament tournament = tournamentService.findTournamentByName(name);
      return (tournament == null) ? null : beanMappingService.mapTo(tournament,TournamentDTO.class);  
      
    
    }
   
}
