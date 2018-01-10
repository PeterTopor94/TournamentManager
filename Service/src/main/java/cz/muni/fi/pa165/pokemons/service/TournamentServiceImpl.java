package cz.muni.fi.pa165.pokemons.service;

import cz.muni.fi.pa165.pokemons.dao.TournamentDao;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miroslav
 */
@Service
public class TournamentServiceImpl implements TournamentService {

        
    @Autowired
    private TournamentDao tournamentDao;
    
    public TournamentServiceImpl(TournamentDao tournamentDao) {
        this.tournamentDao = tournamentDao;
    }
    
    public TournamentServiceImpl() {
       
    }

    @Override
    public Tournament createTournament(Tournament tournament) {       
        tournamentDao.create(tournament);
        return tournament;
    }

    @Override
    public void removeTournament(Tournament tournament) {
        tournamentDao.remove(tournament);
    }
    
    private boolean verifyTrainer(Trainer trainer, Tournament tournament){  
        return (trainer.getBadges().size() >= tournament.getNumRequiredBadges());
    }   
    
    @Override
    public void addTrainer(Tournament tournament, Trainer trainer) {
        if ((verifyTrainer(trainer,tournament)) && (!tournament.getTrainers().contains(trainer))){
            tournament.addTrainer(trainer);
            tournamentDao.update(tournament);
        }
    }
    
    @Override
    public void removeTrainer(Tournament tournament, Trainer trainer) {
        if((tournament.getTrainers() != null) && (tournament.getTrainers().contains(trainer))){
            tournament.removeTrainer(trainer);
            tournamentDao.update(tournament);
        }
    }

    @Override
    public List<Tournament> getAllTournaments() {
        return tournamentDao.getAllTournaments();
    }

    @Override
    public List<Tournament> findAllTournaments() {
        return tournamentDao.findAll();
    }

    @Override
    public Tournament findTournmanetById(Long id) {
        return tournamentDao.findById(id);
    }

    @Override
    public Tournament findTournamentByName(String name) {
         return tournamentDao.findByName(name);
    }

    @Override
    public void setNameOfTournament(Tournament tournament, String name) {
       tournamentDao.findById(tournament.getId()).setName(name);
    }
 
}
