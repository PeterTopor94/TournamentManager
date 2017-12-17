package cz.muni.fi.pa165.pokemons.service;

import cz.muni.fi.pa165.pokemons.entities.Pokemon;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import java.util.List;

/**
 *
 * @author Peter Topor
 */
public interface PokemonService {
    	
    Pokemon createPokemon(Pokemon p);
    void deletePokemon(Pokemon p);
    Pokemon findById(Long id);
    List<Pokemon> findAll();
	    
    void setOwner(Pokemon pokemon, Trainer trainer);
    void setLevel(Pokemon pokemon, int level);
    void setName(Pokemon pokemon, String name);
    void setNickname(Pokemon pokemon, String nickname);
    void setPokemonType(Pokemon pokemon, PokemonType pokemonType);
            
}
