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
    public Long createPokemon(PokemonCreateDTO p);
    public void setOwner(Long pokemonId, Long trainerId);
    public void setLevel(Long pokemonId, int level);
    public void setName(Long pokemonId, String name);
    public void setNickname(Long pokemonId, String nickname);
    public void setPokemonType(Long pokemonId, PokemonType pokemonType);
    public void deletePokemon(Long pokemonId);
    public List<PokemonDTO> getAllPokemon();
    public List<PokemonDTO> getPokemonByTrainer(Long trainerId);
    public PokemonDTO getPokemonById(Long pokemonId);
    
}
