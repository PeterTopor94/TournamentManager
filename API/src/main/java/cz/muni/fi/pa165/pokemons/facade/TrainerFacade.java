/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.facade;

import cz.muni.fi.pa165.pokemons.DTO.TrainerCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Roman Gluszny
 */
public interface TrainerFacade {

    public void createTrainer(TrainerCreateDTO t);

    public void deleteTrainer(Long trainerId);

    public List<TrainerDTO> getAllTrainers();

    public List<TrainerDTO> getTrainersByNameAndSurname(String name, String surname);

    public List<TrainerDTO> getTrainersByDateOfBirth(Date birthdate);

    public TrainerDTO getTrainerByGym(Long gymId);

    public List<TrainerDTO> getAllTrainersForTournament(Long tournamentId);
    //trainers having pokemon
    //trainers having badge
}
