
package cz.muni.fi.pa165.pokemons.service;

import javax.inject.Inject;
import java.util.List;

import cz.muni.fi.pa165.pokemons.dao.PokemonDao;
import cz.muni.fi.pa165.pokemons.entities.Pokemon;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;


/**
 *
 * @author Peter Topor
 */
public class PokemonServiceImpl implements PokemonService{
    
    @Inject
    private PokemonDao pokemonDao;
    
    @Override
    public Pokemon findById(Long id){
        return pokemonDao.findById(id);
    }
    
    @Override
    public List<Pokemon> findAll(){
         return pokemonDao.findAll();
    }

    @Override
    public Pokemon createPokemon(Pokemon p){
        pokemonDao.create(p);
        return p;
    }
    
    @Override
    public void setOwner(Pokemon pokemon, Trainer trainer){
        pokemon.setOwner(trainer);
        pokemonDao.create(pokemon);
    }
    
    @Override
    public void setLevel(Pokemon pokemon, int level){
        if(pokemon.getLevel() > level){
            throw new IllegalArgumentException("Level cannot be decreased");
        }
        pokemon.setLevel(level);
        pokemonDao.create(pokemon);
    }
    
    @Override
    public void setName(Pokemon pokemon, String name){
        pokemon.setName(name);
        pokemonDao.create(pokemon);
    }
    
    @Override
    public void setNickname(Pokemon pokemon, String nickname){
        pokemon.setNickname(nickname);
        pokemonDao.create(pokemon);
    }
    
    @Override
    public void setPokemonType(Pokemon pokemon, PokemonType pokemonType){
        pokemon.setType(pokemonType);
        pokemonDao.create(pokemon);
    }
    
    @Override
    public void deletePokemon(Pokemon p){
        pokemonDao.remove(p);
    }
    
}
