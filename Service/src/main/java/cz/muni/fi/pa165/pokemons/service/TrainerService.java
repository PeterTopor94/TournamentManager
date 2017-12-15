package cz.muni.fi.pa165.pokemons.service;

import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Roman Gluszny
 */
public interface TrainerService {

    public void createTrainer(Trainer t);

    public void deleteTrainer(Trainer t);

    public Trainer findTrainerById(Long id);

    public List<Trainer> findAllTrainers();

    public List<Trainer> findByNameAndSurname(String name, String surname);

    public List<Trainer> getTrainersByDateOfBirth(Date birthdate);

    public Trainer getTrainerByGym(Gym gym);

    public boolean isTrainerQualifiedForTournament(Trainer trainer, Tournament tournament);
}
