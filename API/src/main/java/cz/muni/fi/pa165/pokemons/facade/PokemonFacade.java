package cz.muni.fi.pa165.pokemons.facade;

import cz.muni.fi.pa165.pokemons.DTO.PokemonCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.PokemonDTO;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import java.util.List;

/**
 *
 * @author Peter Topor
 */
public interface PokemonFacade {
    
    Long createPokemon(PokemonCreateDTO p);
    void deletePokemon(Long pokemonId);
    List<PokemonDTO> getAllPokemon();
    List<PokemonDTO> getPokemonByTrainer(Long trainerId);
    PokemonDTO getPokemonById(Long pokemonId);
    
    void setOwner(Long pokemonId, Long trainerId);
    void setLevel(Long pokemonId, int level);
    void setName(Long pokemonId, String name);
    void setNickname(Long pokemonId, String nickname);
    void setPokemonType(Long pokemonId, PokemonType pokemonType);
    
}
