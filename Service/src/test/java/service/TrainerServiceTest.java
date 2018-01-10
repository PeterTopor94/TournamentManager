package service;

import cz.muni.fi.pa165.pokemons.dao.TrainerDao;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.service.TrainerService;
import cz.muni.fi.pa165.pokemons.service.TrainerServiceImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Roman Gluszny
 */
public class TrainerServiceTest {

    @Mock
    private TrainerDao trainerDao;

    private TrainerService trainerService;

    private Tournament tournament;

    private Badge badge;

    private Trainer red;
    private Trainer blue;
    private Gym gym;

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        trainerService = new TrainerServiceImpl(trainerDao);
    }

    @BeforeMethod
    public void createTrainers() {
        tournament = new Tournament();
        tournament.setNumRequiredBadges(1);

        gym = new Gym();
        gym.setTypology(PokemonType.FIRE);
        gym.setCityName("Opal Town");

        badge = new Badge();
        badge.setCityOfOrigin("Opal Town");
        badge.setGym(new Gym());

        red = new Trainer();
        red.setName("Jon");
        red.setSurname("Red");
        red.setDateOfBirth(new Date());
        red.addBadge(badge);
        red.setGym(gym);
        red.setLogin("red");

        blue = new Trainer();
        blue.setName("Misty");
        blue.setSurname("Blue");
        blue.setDateOfBirth(new Date());
        blue.setLogin("blue");

    }

    @Test
    public void create() {
        trainerService.createTrainer(red);
        verify(trainerDao, times(1)).create(red);
    }

    @Test
    public void delete() {
        trainerService.deleteTrainer(red);
        verify(trainerDao, times(1)).remove(red);
    }

    @Test
    public void findById() {
        Long id = red.getId();
        when(trainerDao.findById(id)).thenReturn(red);
        Trainer t = trainerDao.findById(id);
        Assert.assertEquals(red.getName(), t.getName());
    }

    @Test
    public void findAll() {
        when(trainerDao.findAll()).thenReturn(Arrays.asList(red, blue));
        List<Trainer> trainers = trainerService.findAllTrainers();
        Assert.assertEquals(trainers.size(), 2);
    }

    @Test
    public void findByNameAndSurname() {
        when(trainerDao.findByNameAndSurname("Jon", "Red")).thenReturn(Arrays.asList(red));
        List<Trainer> trainers = trainerService.findByNameAndSurname("Jon", "Red");
        Assert.assertEquals(trainers.get(0).getDateOfBirth(), red.getDateOfBirth());
    }

    @Test
    public void findByGym() {
        when(trainerDao.findByGym(gym)).thenReturn(red);
        Trainer trainer = trainerService.getTrainerByGym(gym);
        Assert.assertEquals(trainer.getName(), red.getName());
    }

    @Test
    public void trainerWithBadgeQualified() {
        Assert.assertTrue(trainerService.isTrainerQualifiedForTournament(red, tournament));
    }

    @Test
    public void trainerWithoutBadgeQualified() {
        Assert.assertFalse(trainerService.isTrainerQualifiedForTournament(blue, tournament));
    }
}
