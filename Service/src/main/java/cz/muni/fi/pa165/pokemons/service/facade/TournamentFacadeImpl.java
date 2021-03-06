package cz.muni.fi.pa165.pokemons.service.facade;

import cz.muni.fi.pa165.pokemons.DTO.TournamentCreateDTO;
import cz.muni.fi.pa165.pokemons.service.BeanMappingService;
import cz.muni.fi.pa165.pokemons.DTO.TournamentDTO;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.facade.TournamentFacade;
import cz.muni.fi.pa165.pokemons.service.TournamentService;
import cz.muni.fi.pa165.pokemons.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.inject.Inject;

/**
 * implementation of {@link TournamentFacade}
 * @author Miroslav
 */
@Service
@Transactional
public class TournamentFacadeImpl implements TournamentFacade {

    @Inject
    private TrainerService trainerService;
    
    @Autowired
    private BeanMappingService beanMappingService;
    
    @Inject
    private TournamentService tournamentService; 

    public TournamentFacadeImpl( BeanMappingService mappingService, TournamentService tournamentService) {
        this.tournamentService = tournamentService;
        this.beanMappingService = mappingService;      
    }

    @Override
    public Long createTournament(TournamentCreateDTO tournament) {
        Tournament mappedTournament = beanMappingService.mapTo(tournament, Tournament.class);
        mappedTournament.setName(tournament.getName());
        Tournament newTournament = tournamentService.createTournament(mappedTournament);
        return newTournament.getId();
    }
    
    @Override
     public void addTrainerToTournament(Long idTournament, Long idTrainer) {
        tournamentService.addTrainer(tournamentService.findTournmanetById(idTournament),
        trainerService.findTrainerById(idTrainer));
    }
    
    @Override
    public void removTrainer(Long idTournament, Long idTrainer) {
        tournamentService.removeTrainer(tournamentService.findTournmanetById(idTournament),
        trainerService.findTrainerById(idTrainer));
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
