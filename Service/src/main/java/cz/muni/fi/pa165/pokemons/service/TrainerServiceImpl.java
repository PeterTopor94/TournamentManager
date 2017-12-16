package cz.muni.fi.pa165.pokemons.service;

import cz.muni.fi.pa165.pokemons.dao.TrainerDao;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Roman Gluszny
 */
public class TrainerServiceImpl implements TrainerService {
    
    public TrainerServiceImpl(TrainerDao trainerDao)
    {
        this.trainerDao = trainerDao;
    }

    @Autowired
    private TrainerDao trainerDao;

    @Override
    public void createTrainer(Trainer t) {
        trainerDao.create(t);
    }

    @Override
    public void deleteTrainer(Trainer t) {
        trainerDao.remove(t);
    }

    @Override
    public Trainer findTrainerById(Long id) {
        return trainerDao.findById(id);
    }

    @Override
    public List<Trainer> findAllTrainers() {
        return trainerDao.findAll();
    }

    @Override
    public List<Trainer> findByNameAndSurname(String name, String surname) {
        return trainerDao.findByNameAndSurname(name, surname);
    }

    @Override
    public List<Trainer> getTrainersByDateOfBirth(Date birthdate) {
        return trainerDao.findByBirthdate(birthdate);
    }

    @Override
    public Trainer getTrainerByGym(Gym gym) {
        return trainerDao.findByGym(gym);
    }


    @Override
    public boolean isTrainerQualifiedForTournament(Trainer trainer, Tournament tournament) {
        return trainer.getBadges().size()>=tournament.getNumRequiredBadges();
    }
}
