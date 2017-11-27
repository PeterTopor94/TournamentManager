package service.facade;

import cz.muni.fi.pa165.pokemons.DTO.GymCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.GymDTO;
import cz.muni.fi.pa165.pokemons.DTO.NewGymTypologyDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.facade.GymFacade;
import cz.muni.fi.pa165.pokemons.service.BeanMappingService;
import cz.muni.fi.pa165.pokemons.service.GymService;
import cz.muni.fi.pa165.pokemons.service.config.ServiceConfiguration;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test for facade layer of gym object
 * @author Matus Krska
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class GymFacadeTest
{
    @Mock
    private BeanMappingService mappingService;

    @Mock
    private GymService gymService;

    @InjectMocks
    private GymFacade gymFacade;

    @BeforeClass
    public void setup() throws ServiceException
    {
        MockitoAnnotations.initMocks(this);
    }

    private GymDTO gymDTO;
    private GymCreateDTO gymCreateDTO;
    private Gym gym;
    private Trainer trainer;
    private TrainerDTO trainerDTO;
    private NewGymTypologyDTO newTypology;

    @BeforeMethod
    public void prepareGyms()
    {
        gym = new Gym();
        gym.setTypology(PokemonType.DRAGON);
        gym.setCityName("Trenčín");

        gymCreateDTO = new GymCreateDTO();
        gymCreateDTO.setTypology(PokemonType.DRAGON);
        gymCreateDTO.setCityName("Trenčín");

        gymDTO = new GymDTO();
        gymDTO.setTypology(PokemonType.DRAGON);
        gymDTO.setCityName("Trenčín");

        trainerDTO = new TrainerDTO();
        trainerDTO.setName("Matus");
        trainerDTO.setSurname("Krska");

        trainer = new Trainer();
        trainer.setName("Matus");
        trainer.setSurname("Krska");

        newTypology.setGymId(6L);
        newTypology.setTypology(PokemonType.FAIRY);
    }

    @Test
    public void create()
    {
        when(mappingService.mapTo(gymCreateDTO, Gym.class)).thenReturn(gym);

        gymFacade.createGym(gymCreateDTO);
        verify(gymService, times(1)).createGym(gym);
    }

    @Test
    public void delete()
    {
        when(gymService.findById(6L)).thenReturn(gym);
        gymDTO.setId(6L);

        gymFacade.deleteGym(gymDTO);
        verify(gymService,times(1)).deleteGym(gym);
    }

    @Test
    public void getAll()
    {
        when(gymService.findAllGyms()).thenReturn(Arrays.asList(gym));
        when(mappingService.mapTo(any(),eq(GymDTO.class))).thenReturn(Arrays.asList(gymDTO));

        List<GymDTO> gyms = gymFacade.getAllGyms();

        Assert.assertEquals(gyms.size(),1);
    }

    @Test
    public void getById()
    {
        when(gymService.findById(6L)).thenReturn(gym);
        when(mappingService.mapTo(gym,eq(GymDTO.class))).thenReturn(gymDTO);

        GymDTO gym = gymFacade.getGymById(6L);
        Assert.assertEquals(gym.getCityName(),gymDTO.getCityName());
    }

    @Test
    public void changeTypology()
    {
        when(gymService.findById(6L)).thenReturn(gym);

        gymFacade.changeTypology(newTypology);

        verify(gymService,times(1)).changeTypology(gym, newTypology.getTypology());
    }

    @Test
    public void findByCity()
    {
        when(gymService.findGymByCity(gymDTO.getCityName())).thenReturn(gym);
        when(mappingService.mapTo(gym, GymDTO.class)).thenReturn(gymDTO);

        GymDTO gym = gymFacade.getGymByCity(gymDTO.getCityName());
        Assert.assertEquals(gym.getCityName(),gymDTO.getCityName());
    }

    @Test
    public void getByLeader()
    {
        when(gymService.findGymByGymLeader(trainer)).thenReturn(gym);
        when(mappingService.mapTo(gym, GymDTO.class)).thenReturn(gymDTO);
        when(mappingService.mapTo(trainerDTO, Trainer.class)).thenReturn(trainer);

        GymDTO gym = gymFacade.getGymByLeader(trainerDTO);
        Assert.assertEquals(gym.getCityName(),gymDTO.getCityName());
    }

    //TODO after Badge classes are created
    /*@Test
    public void getByBadge()
    {

    }*/
}
