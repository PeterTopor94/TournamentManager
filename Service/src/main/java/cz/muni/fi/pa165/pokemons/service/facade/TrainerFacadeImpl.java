package cz.muni.fi.pa165.pokemons.service.facade;

import cz.muni.fi.pa165.pokemons.DTO.TrainerCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import cz.muni.fi.pa165.pokemons.DTO.TournamentDTO;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import cz.muni.fi.pa165.pokemons.facade.TrainerFacade;
import cz.muni.fi.pa165.pokemons.service.BeanMappingService;
import cz.muni.fi.pa165.pokemons.service.GymService;
import cz.muni.fi.pa165.pokemons.service.PokemonService;
import cz.muni.fi.pa165.pokemons.service.TrainerService;
import cz.muni.fi.pa165.pokemons.service.BadgeService;
import cz.muni.fi.pa165.pokemons.service.TournamentService;


import java.util.Date;
import java.util.List;

/**
 *
 * @author Roman Gluszny
 */
public class TrainerFacadeImpl implements TrainerFacade {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private BadgeService badgeService;

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private GymService gymService;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Override
    public void createTrainer(TrainerCreateDTO t) {
        Trainer mappedTrainer = beanMappingService.mapTo(t, Trainer.class);

        mappedTrainer.setName(t.getName());
        mappedTrainer.setSurname(t.getSurname());
        mappedTrainer.setGym(gymService.findById(t.getGymId()));
        mappedTrainer.setDateOfBirth(t.getDateOfBirth());

        trainerService.createTrainer(mappedTrainer);
    }

    @Override
    public void deleteTrainer(Long trainerId) {
        trainerService.deleteTrainer(new Trainer(trainerId));
    }

    @Override
    public List<TrainerDTO> getAllTrainers() {
        return beanMappingService.mapTo(trainerService.findAllTrainers(),
                TrainerDTO.class);
    }

    @Override
    public List<TrainerDTO> getTrainersByNameAndSurname(String name, String surname) {
        return beanMappingService.mapTo(trainerService.findByNameAndSurname(name, surname),
                TrainerDTO.class);
    }

    @Override
    public List<TrainerDTO> getTrainersByDateOfBirth(Date birthdate) {
        return beanMappingService.mapTo(trainerService.getTrainersByDateOfBirth(birthdate),
                TrainerDTO.class);
    }

    @Override
    public TrainerDTO getTrainerByGym(Long gymId) {
        Gym gym = gymService.findById(gymId);
        Trainer trainer = trainerService.getTrainerByGym(gym);
        return (trainer == null) ? null : beanMappingService.mapTo(trainer, TrainerDTO.class);
    }

    @Override
    public boolean isTrainerQualifiedForTournament(TrainerDTO tr, TournamentDTO to) {
        return trainerService.isTrainerQualifiedForTournament(beanMappingService.mapTo(tr, Trainer.class), beanMappingService.mapTo(to, Tournament.class));
    }

}
