package cz.muni.fi.pa165.pokemons.service;

import cz.muni.fi.pa165.pokemons.dao.PokemonDao;
import cz.muni.fi.pa165.pokemons.entities.Pokemon;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author Peter Topor
 */
@Service
public class PokemonServiceImpl implements PokemonService{
    
    @Inject
    private PokemonDao pokemonDao;
    
    public PokemonServiceImpl(PokemonDao pokemonDao){
        this.pokemonDao = pokemonDao;
    }
    
    @Override
    public Pokemon createPokemon(Pokemon pokemon){
        pokemonDao.create(pokemon);
        return pokemon;
    }
    
    @Override
    public void deletePokemon(Pokemon p){
        pokemonDao.remove(p);
    }
    
    @Override
    public Pokemon findById(Long id){
        return pokemonDao.findById(id);
    }
    
    @Override
    public List<Pokemon> findAll(){
         return pokemonDao.findAll();
    }
    
    @Override
    public void setOwner(Pokemon pokemon, Trainer trainer){
        if(trainer == null){
            return;
        }
        pokemon.setOwner(trainer);
        pokemonDao.create(pokemon);
    }
    
    @Override
    public void setLevel(Pokemon pokemon, int level){
        if(pokemon.getLevel() > level){
            throw new IllegalArgumentException("Level cannot be decreased");
        }
        if(pokemon.getLevel() == level){
            return;
        }
        pokemon.setLevel(level);
        pokemonDao.create(pokemon);
    }
    
    @Override
    public void setName(Pokemon pokemon, String name){
        if(name == null || name.equals("")){
            return;
        }
        pokemon.setName(name);
        pokemonDao.create(pokemon);
    }
    
    @Override
    public void setNickname(Pokemon pokemon, String nickname){
        if(nickname == null || nickname.equals("")){
            return;
        }
        pokemon.setNickname(nickname);
        pokemonDao.create(pokemon);
    }
    
    @Override
    public void setPokemonType(Pokemon pokemon, PokemonType pokemonType){
        if(pokemonType == null){
            return;
        }
        pokemon.setType(pokemonType);
        pokemonDao.create(pokemon);
    }
}
