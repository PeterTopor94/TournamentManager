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

    List<TrainerDTO> getAllTrainers();
    
    TrainerDTO getById(Long id);

    List<TrainerDTO> getTrainersByNameAndSurname(String name, String surname);
    
    List<TrainerDTO> getTrainersByDateOfBirth(Date birthdate);

    TrainerDTO getTrainerByGym(GymDTO gym);
    
    boolean isTrainerQualifiedForTournament(TrainerDTO tr, TournamentDTO to);

    TrainerDTO getTrainerByLogin(String login);

    boolean login(AuthenticateTrainerDTO trainer);
    
    public void addBadge(Long trainerId, Long badgeId);
    
    public void addPlacement(Long tournamentId, Long trainerId);
    
    public void removePlacement(Long tournamentId, Long trainerId);
}
