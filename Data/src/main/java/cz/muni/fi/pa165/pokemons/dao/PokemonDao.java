package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Pokemon;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import java.util.List;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.entities.Pokemon;
import cz.muni.fi.pa165.pokemons.entities.Trainer;


/**
 *
 * @author Roman
 */
public interface PokemonDao {
    /**
     * Adds new pokemon
     * @param p Pokemon to add
     */
    public void create(Pokemon p);
    
    /**
     * Removes pokemon
     * @param p Pokemon to remove
     * @throws IllegalArgumentException 
     */
    public void remove(Pokemon p) throws IllegalArgumentException;
    
    /**
     * Returns pokemon by id
     * @param id Pokemon id
     * @return pokemon
     */
    public Pokemon findById(Long id);
    
    /**
     * Returns all pokemon
     * @return list of all pokemon
     */
    public  List<Pokemon> findAll();
    
    /**
     * Returns pokemon by owner
     * @param t Owner
     * @return list of pokemon belonging to specified trainer
     */
    public  List<Pokemon> findByOwner(Trainer t);
    
    /**
     * Returns pokemon by name
     * @param name Pokemon name
     * @return list of pokemon with specified name
     */
    public  List<Pokemon> getPokemonsWithName(String name);
    
    /**
     * Returns pokemon by nickname
     * @param nickname Pokemon nickname
     * @return list of pokemon with specified nickname
     */
    public  List<Pokemon> getPokemonsWithNickname(String nickname);
    
    /**
     * Return pokemon by type
     * @param t Pokemon type
     * @return list of pokemon with specified type
     */
    public  List<Pokemon> getPokemonsWithtype(PokemonType t);
}
