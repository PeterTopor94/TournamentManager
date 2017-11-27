package cz.muni.fi.pa165.pokemons.service;

import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import java.util.List;

/**
 * Interface for service operations for Gym object
 * @author Matus Krska
 */
public interface GymService
{
    void createGym(Gym gym);

    void deleteGym(Gym gym);

    Gym findById(Long id);

    List<Gym> findAllGyms();

    void changeTypology(Gym gym, PokemonType newTypology);
}