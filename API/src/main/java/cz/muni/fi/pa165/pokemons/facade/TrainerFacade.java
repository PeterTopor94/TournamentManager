/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.facade;

import cz.muni.fi.pa165.pokemons.DTO.*;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Roman Gluszny
 */
public interface TrainerFacade {

    public Long createTrainer(TrainerCreateDTO trainer);

    public void deleteTrainer(TrainerDTO trainer);

    public List<TrainerDTO> getAllTrainers();

    public TrainerDTO getById(Long id);

    public List<TrainerDTO> getTrainersByNameAndSurname(String name, String surname);

    public List<TrainerDTO> getTrainersByDateOfBirth(Date birthdate);

    public TrainerDTO getTrainerByGym(GymDTO gym);

    public boolean isTrainerQualifiedForTournament(TrainerDTO tr, TournamentDTO to);

    public TrainerDTO getTrainerByLogin(String login);

    public boolean login(AuthenticateTrainerDTO trainer);

    void addBadgeToTrainer(Long trainerId, Long badgeId);

}
