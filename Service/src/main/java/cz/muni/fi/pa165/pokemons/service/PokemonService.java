
package cz.muni.fi.pa165.pokemons.service;

import java.util.List;
import cz.muni.fi.pa165.pokemons.entities.Pokemon;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;

/**
 *
 * @author Peter Topor
 */
public interface PokemonService {
    	public Pokemon findById(Long id);
	public List<Pokemon> findAll();
	public Pokemon createPokemon(Pokemon p);
	public void setOwner(Pokemon pokemon, Trainer trainer);
        public void setLevel(Pokemon pokemon, int level);
        public void setName(Pokemon pokemon, String name);
        public void setNickname(Pokemon pokemon, String nickname);
        public void setPokemonType(Pokemon pokemon, PokemonType pokemonType);
	public void deletePokemon(Pokemon p);
    
}
