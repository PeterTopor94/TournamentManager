package cz.muni.fi.pa165.pokemons.service.facade;

import cz.muni.fi.pa165.pokemons.DTO.GymDTO;
import cz.muni.fi.pa165.pokemons.DTO.TournamentDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
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

    public TrainerFacadeImpl(TrainerService trainerService, BadgeService badgeService, PokemonService pokemonService, GymService gymService, TournamentService tournamentService, BeanMappingService beanMappingService) {
        this.trainerService = trainerService;
        this.badgeService = badgeService;
        this.pokemonService = pokemonService;
        this.gymService = gymService;
        this.tournamentService = tournamentService;
        this.beanMappingService = beanMappingService;
    }

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
    public void createTrainer(TrainerCreateDTO trainer) {
        Trainer mappedTrainer = beanMappingService.mapTo(trainer, Trainer.class);

        mappedTrainer.setName(trainer.getName());
        mappedTrainer.setSurname(trainer.getSurname());
        mappedTrainer.setGym(gymService.findById(trainer.getGymId()));
        mappedTrainer.setDateOfBirth(trainer.getDateOfBirth());

        trainerService.createTrainer(mappedTrainer);
    }

    @Override
    public void deleteTrainer(TrainerDTO trainer) {
        trainerService.deleteTrainer(trainerService.findTrainerById(trainer.getId()));
    }

    @Override
    public List<TrainerDTO> getAllTrainers() {
        return beanMappingService.mapTo(trainerService.findAllTrainers(),
                TrainerDTO.class);
    }

    @Override
    public TrainerDTO getById(Long id) {
        Trainer trainer = trainerService.findTrainerById(id);
        return (trainer == null) ? null : beanMappingService.mapTo(trainer, TrainerDTO.class);
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
    public TrainerDTO getTrainerByGym(GymDTO gym) {      
        Trainer trainer = trainerService.getTrainerByGym(beanMappingService.mapTo(gym, Gym.class));
        return (trainer == null) ? null : beanMappingService.mapTo(trainer, TrainerDTO.class);
    }

    @Override
    public boolean isTrainerQualifiedForTournament(TrainerDTO tr, TournamentDTO to) {
        return trainerService.isTrainerQualifiedForTournament(beanMappingService.mapTo(tr, Trainer.class), beanMappingService.mapTo(to, Tournament.class));
    }
}
