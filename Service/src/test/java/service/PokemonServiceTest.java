package service;

import cz.muni.fi.pa165.pokemons.dao.PokemonDao;
import cz.muni.fi.pa165.pokemons.entities.Pokemon;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.service.PokemonService;
import cz.muni.fi.pa165.pokemons.service.PokemonServiceImpl;
import cz.muni.fi.pa165.pokemons.service.config.ServiceConfiguration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.hibernate.service.spi.ServiceException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

/**
 *
 * @author Peter Topor
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class PokemonServiceTest {
    @Mock
    private PokemonDao pokemonDao;


    private PokemonService pokemonService;
    
    private Pokemon pokemon;
    private Trainer trainer;

    @BeforeClass
    public void setup() throws ServiceException
    {
        MockitoAnnotations.initMocks(this);
        pokemonService = new PokemonServiceImpl( pokemonDao );
    }
    
    @BeforeMethod
    public void prepareTest(){
        trainer = new Trainer();
        trainer.setName("ja");
        trainer.setSurname("on");
        trainer.setDateOfBirth(new Date());
        
        pokemon = new Pokemon();
        pokemon.setId(6L);
        pokemon.setLevel(10);
        pokemon.setName("pika");
        pokemon.setNickname("polo");
        pokemon.setType(PokemonType.FIRE);
        pokemon.setOwner(trainer);
    }
    
    @Test
    public void findById(){
        when(pokemonDao.findById(6L)).thenReturn(pokemon);
        Pokemon p = pokemonService.findById(6L);
        Assert.assertEquals(pokemon, p);
    }
    
    @Test
    public void findAll(){
        when(pokemonDao.findAll()).thenReturn(Arrays.asList(pokemon));
        List<Pokemon> pokemons = pokemonService.findAll();
        Assert.assertEquals(pokemons.size(), 1);
    }
    
    @Test
    public void createPokemon(){
        pokemonService.createPokemon(pokemon);
        verify(pokemonDao, times(1)).create(pokemon);
    }
    
    @Test
    public void setOwner(){
        pokemonService.setOwner(pokemon, trainer);
        verify(pokemonDao, times(2)).create(pokemon);
    }
    
    @Test
    public void setLevel(){
        pokemonService.setLevel(pokemon, 15);
        verify(pokemonDao, times(1)).create(pokemon);
    }
    
    @Test
    public void setName(){
        pokemonService.setName(pokemon, "name");
        verify(pokemonDao, times(1)).create(pokemon);
    }
    
    @Test
    public void setNickname(){
        pokemonService.setNickname(pokemon, "nick");
        verify(pokemonDao, times(1)).create(pokemon);
    }
    
    @Test
    public void setPokemonType(){
        pokemonService.setPokemonType(pokemon, PokemonType.BUG);
        verify(pokemonDao, times(1)).create(pokemon);
    }
    
    @Test
    public void deletePokemon(){
        pokemonService.deletePokemon(pokemon);
        verify(pokemonDao, times(1)).remove(pokemon);
    }
    
}
