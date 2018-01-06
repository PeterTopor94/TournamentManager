package service;

import cz.muni.fi.pa165.pokemons.dao.GymDao;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.service.GymService;
import cz.muni.fi.pa165.pokemons.service.GymServiceImpl;
import cz.muni.fi.pa165.pokemons.service.config.ServiceConfiguration;

import org.hibernate.service.spi.ServiceException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test for service layer of gym object
 * @author Matus Krska
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class GymServiceTest {
    @Mock
    private GymDao gymDao;

    private GymService gymService;

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        gymService = new GymServiceImpl(gymDao);
    }

    private Gym testGym;
    private Trainer trainer;
    private Badge badge;

    @BeforeMethod
    public void prepareTestGym() {
        testGym = new Gym();
        testGym.setTypology(PokemonType.DRAGON);
        testGym.setCityName("Trenčín");

        trainer = new Trainer();
        trainer.setName("Matus");
        trainer.setSurname("Krska");

        badge = new Badge();
        badge.setCityOfOrigin("Trenčín");
        badge.setGym(testGym);

        testGym.setGymLeader(trainer);
    }

    @Test
    public void create() {
        gymService.createGym(testGym);
        verify(gymDao, times(1)).create(testGym);
    }

    @Test
    public void delete() {
        gymService.deleteGym(testGym);
        verify(gymDao, times(1)).remove(testGym);
    }

    @Test
    public void findById() {
        when(gymDao.getGymById(6L)).thenReturn(testGym);
        Gym gym = gymDao.getGymById(6L);
        Assert.assertEquals(testGym.getCityName(),gym.getCityName());
    }

    @Test
    public void findAll() {
        when(gymDao.getAllGyms()).thenReturn(Arrays.asList(testGym));
        List<Gym> gyms = gymService.findAllGyms();
        Assert.assertEquals(gyms.size(),1);
    }

    @Test
    public void changeTypology() {
        gymService.changeTypology(testGym, PokemonType.FAIRY);
        Assert.assertEquals(testGym.getTypology(), PokemonType.FAIRY);
    }

    @Test
    public void findByCity() {
        when(gymDao.getGymByCity(testGym.getCityName())).thenReturn(testGym);
        Gym gym = gymService.findGymByCity(testGym.getCityName());
        Assert.assertEquals(gym.getTypology(), testGym.getTypology());
    }

    @Test
    public void findByLeader() {
        when(gymDao.getGymByLeader(trainer)).thenReturn(testGym);
        Gym gym = gymService.findGymByGymLeader(trainer);
        Assert.assertEquals(gym.getTypology(), testGym.getTypology());
    }

    @Test
    public void findByBadge() {
        when(gymDao.getGymByBadge(badge)).thenReturn(testGym);
        Gym gym = gymService.findGymByBadge(badge);
        Assert.assertEquals(gym.getTypology(), testGym.getTypology());
    }

}
