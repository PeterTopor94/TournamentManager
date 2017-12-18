package service.facade;

import cz.muni.fi.pa165.pokemons.DTO.PokemonCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.PokemonDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import cz.muni.fi.pa165.pokemons.entities.Pokemon;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.facade.PokemonFacade;
import cz.muni.fi.pa165.pokemons.service.BeanMappingService;
import cz.muni.fi.pa165.pokemons.service.PokemonService;
import cz.muni.fi.pa165.pokemons.service.TrainerService;
import cz.muni.fi.pa165.pokemons.service.config.ServiceConfiguration;
import cz.muni.fi.pa165.pokemons.service.facade.PokemonFacadeImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Peter Topor
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class PokemonFacadeTest {
    
    @Mock
    private BeanMappingService mappingService;

    @Mock
    private PokemonService pokemonService;
    
    @Mock
    private TrainerService trainerService;
    
    private PokemonFacade pokemonFacade;
    
    private PokemonDTO pokemonDTO;
    private Pokemon pokemon;
    private PokemonCreateDTO pokemonCreateDTO;
    
    private TrainerDTO trainerDTO;
    private Trainer trainer;
    
    @BeforeClass
    public void setup() throws ServiceException
    {
        MockitoAnnotations.initMocks(this);
        pokemonFacade = new PokemonFacadeImpl( pokemonService, mappingService, trainerService);
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
        
        trainerDTO = new TrainerDTO();
        trainerDTO.setName("ja");
        trainerDTO.setSurname("on");
        trainerDTO.setDateOfBirth(new Date());
        
        pokemonDTO = new PokemonDTO();
        pokemonDTO.setId(6L);
        pokemonDTO.setLevel(10);
        pokemonDTO.setName("pika");
        pokemonDTO.setNickname("polo");
        pokemonDTO.setType(PokemonType.FIRE);
        pokemonDTO.setOwner(trainerDTO);
        
        pokemonCreateDTO = new PokemonCreateDTO();
        pokemonCreateDTO.setLevel(10);
        pokemonCreateDTO.setName("pika");
        pokemonCreateDTO.setNickname("polo");
        pokemonCreateDTO.setOwnerId(5L);
        pokemonCreateDTO.setPokemonType(PokemonType.FIRE);
    }
    
    @Test
    public void createPokemon(){
        when(mappingService.mapTo(pokemonCreateDTO, Pokemon.class)).thenReturn(pokemon);
        when(trainerService.findTrainerById(6L)).thenReturn(trainer);
        when(pokemonService.createPokemon(pokemon)).thenReturn(pokemon);
        pokemonFacade.createPokemon(pokemonCreateDTO);
        verify(pokemonService, times(1)).createPokemon(pokemon);
    }
    
    @Test
    public void setPokemonType(){
        when(pokemonService.findById(6L)).thenReturn(pokemon);
        pokemonFacade.setPokemonType(6L, PokemonType.FAIRY);
        verify(pokemonService, times(1)).deletePokemon(pokemon);
    }
    
    @Test
    public void deletePokemon(){
        when(pokemonService.findById(6L)).thenReturn(pokemon);
        pokemonFacade.deletePokemon(6L);
        verify(pokemonService, times(1)).deletePokemon(pokemon);
    }
    
    @Test
    public void getAllPokemon(){
        when(pokemonService.findAll()).thenReturn(Arrays.asList(pokemon));
        when(mappingService.mapTo(any(), eq(PokemonDTO.class))).thenReturn(Arrays.asList(pokemonDTO));
        List<PokemonDTO> pokemons = pokemonFacade.getAllPokemon();
        Assert.assertEquals(pokemons.size(), 1);
    }
    
    @Test
    public void getPokemonByTrainer(){
        when(pokemonService.findAll()).thenReturn(Arrays.asList(pokemon));
        when(trainerService.findTrainerById(5L)).thenReturn(trainer);
        when(mappingService.mapTo(any(), eq(PokemonDTO.class))).thenReturn(Arrays.asList(pokemonDTO));
        List<PokemonDTO> pokemons = pokemonFacade.getPokemonByTrainer(5L);
        Assert.assertEquals(pokemons.size(), 1);
    }
    
    @Test
    public void getPokemonById(){
        when(pokemonService.findById(6L)).thenReturn(pokemon);
        when(mappingService.mapTo(pokemon, PokemonDTO.class)).thenReturn(pokemonDTO);
        PokemonDTO p = pokemonFacade.getPokemonById(6L);
        Assert.assertEquals(pokemonDTO, p);
    }
    
    @Test
    public void setOwner(){
        when(pokemonService.findById(6L)).thenReturn(pokemon);
        when(trainerService.findTrainerById(5L)).thenReturn(trainer);
        pokemonFacade.setOwner(6L, 5L);
        verify(pokemonService, times(1)).setOwner(pokemon, trainer);
        
    }
    
    @Test
    public void setLevel(){
        when(pokemonService.findById(6L)).thenReturn(pokemon);
        pokemonFacade.setLevel(6L, 15);
        verify(pokemonService, times(1)).setLevel(pokemon, 15);
        
    }
    
    @Test
    public void setName(){
        when(pokemonService.findById(6L)).thenReturn(pokemon);
        pokemonFacade.setName(6L, "name2");
        verify(pokemonService, times(1)).setName(pokemon, "name2");
        
    }
    
    @Test
    public void setNickname(){
        when(pokemonService.findById(6L)).thenReturn(pokemon);
        pokemonFacade.setNickname(6L, "nick2");
        verify(pokemonService, times(1)).setNickname(pokemon, "nick2");
        
    }
}
