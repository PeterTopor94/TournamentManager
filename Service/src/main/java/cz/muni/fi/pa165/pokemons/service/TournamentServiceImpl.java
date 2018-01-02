/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    
    public TournamentServiceImpl(TournamentDao tournamentDao)
    {
        this.tournamentDao = tournamentDao;
    }
    public TournamentServiceImpl()
    {
       
    }
    
    @Autowired
    private TournamentDao tournamentDao;

    

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
        if (verifyTrainer(trainer,tournament)){
        tournament.addTrainer(trainer);
        tournamentDao.update(tournament);
        }
    }

    
     @Override
    public void removeTrainer(Tournament tournament, Trainer trainer) {
     
     tournament.removeTrainer(trainer);
     tournamentDao.update(tournament);
     
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
