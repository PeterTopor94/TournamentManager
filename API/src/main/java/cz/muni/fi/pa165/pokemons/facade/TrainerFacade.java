package cz.muni.fi.pa165.pokemons.facade;

import cz.muni.fi.pa165.pokemons.DTO.*;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Roman Gluszny
 */
public interface TrainerFacade {

    Long createTrainer(TrainerCreateDTO trainer);

    void deleteTrainer(TrainerDTO trainer);
    
    void setPlacement(Long trainerId, Long tournamentId);
    
    List<TrainerDTO> getAllTrainers();
    
    TrainerDTO getById(Long id);

    List<TrainerDTO> getTrainersByNameAndSurname(String name, String surname);
    
    List<TrainerDTO> getTrainersByDateOfBirth(Date birthdate);

    TrainerDTO getTrainerByGym(GymDTO gym);
    
    boolean isTrainerQualifiedForTournament(TrainerDTO tr, TournamentDTO to);

    TrainerDTO getTrainerByLogin(String login);

    boolean login(AuthenticateTrainerDTO trainer);
}
