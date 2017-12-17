package service.facade;

import cz.muni.fi.pa165.pokemons.DTO.GymDTO;
import cz.muni.fi.pa165.pokemons.DTO.TournamentDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.facade.TrainerFacade;
import cz.muni.fi.pa165.pokemons.service.BadgeService;
import cz.muni.fi.pa165.pokemons.service.BeanMappingService;
import cz.muni.fi.pa165.pokemons.service.GymService;
import cz.muni.fi.pa165.pokemons.service.PokemonService;
import cz.muni.fi.pa165.pokemons.service.TournamentService;
import cz.muni.fi.pa165.pokemons.service.TrainerService;
import cz.muni.fi.pa165.pokemons.service.facade.TrainerFacadeImpl;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Roman Gluszny
 */
public class TrainerFacadeTest {

    @Mock
    private TrainerService trainerService;

    @Mock
    private BadgeService badgeService;

    @Mock
    private PokemonService pokemonService;

    @Mock
    private GymService gymService;

    @Mock
    private TournamentService tournamentService;

    @Mock
    private BeanMappingService mappingService;

    private TrainerFacade trainerFacade;

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        trainerFacade = new TrainerFacadeImpl(trainerService, badgeService, pokemonService, gymService, tournamentService, mappingService);
    }

    private Trainer trainer;
    private TrainerCreateDTO trainerCreateDTO;
    private TrainerDTO trainerDTO;
    private Gym gym;
    private GymDTO gymDTO;
    private Tournament tournament;
    private TournamentDTO tournamentDTO;

    @BeforeMethod
    public void prepareTrainers() {
        trainer = new Trainer();
        trainer.setName("Misty");
        trainer.setSurname("Blue");
        trainer.setLogin("blue");
        trainer.setDateOfBirth(new Date(1994, 1, 9));

        trainerCreateDTO = new TrainerCreateDTO();
        trainerCreateDTO.setName("Misty");
        trainerCreateDTO.setSurname("Blue");
        trainerCreateDTO.setLogin("blue");
        trainerCreateDTO.setDateOfBirth(new Date(1994, 1, 9));

        trainerDTO = new TrainerDTO();
        trainerDTO.setName("Misty");
        trainerDTO.setSurname("Blue");
        trainerDTO.setLogin("blue");
        trainerDTO.setDateOfBirth(new Date(1994, 1, 9));

        gymDTO = new GymDTO();
        gymDTO.setTypology(PokemonType.WATER);
        gymDTO.setCityName("Opal Town");

        gym = new Gym();
        gym.setTypology(PokemonType.WATER);
        gym.setCityName("Opal Town");

        tournamentDTO = new TournamentDTO();
        tournamentDTO.setName("World Championship");
        tournamentDTO.setNumRequiredBadges(1);

        tournament = new Tournament();
        tournament.setName("World Championship");
        tournament.setNumRequiredBadges(1);
    }

    @Test
    public void create() {
        when(mappingService.mapTo(trainerCreateDTO, Trainer.class)).thenReturn(trainer);
        trainerFacade.createTrainer(trainerCreateDTO);

        verify(trainerService, times(1)).createTrainer(trainer);
    }

    @Test
    public void delete() {
        when(trainerService.findTrainerById(6L)).thenReturn(trainer);
        trainerDTO.setId(6L);

        trainerFacade.deleteTrainer(trainerDTO);
        verify(trainerService, times(1)).deleteTrainer(trainer);
    }

    @Test
    public void getAll() {
        when(trainerService.findAllTrainers()).thenReturn(Arrays.asList(trainer));
        when(mappingService.mapTo(any(), eq(TrainerDTO.class))).thenReturn(Arrays.asList(trainerDTO));

        List<TrainerDTO> trainers = trainerFacade.getAllTrainers();

        Assert.assertEquals(trainers.size(), 1);
    }

    @Test
    public void getById() {
        when(trainerService.findTrainerById(6L)).thenReturn(trainer);
        when(mappingService.mapTo(trainer, TrainerDTO.class)).thenReturn(trainerDTO);

        TrainerDTO trainer = trainerFacade.getById(6L);
        Assert.assertEquals(trainer.getSurname(), trainerDTO.getSurname());
    }

    @Test
    public void getByNameAndSurname() {
        when(trainerService.findByNameAndSurname(trainerDTO.getName(), trainerDTO.getSurname())).thenReturn(Arrays.asList(trainer));
        when(mappingService.mapTo(any(), eq(TrainerDTO.class))).thenReturn(Arrays.asList(trainerDTO));

        List<TrainerDTO> trainers = trainerFacade.getTrainersByNameAndSurname(trainerDTO.getName(), trainerDTO.getSurname());

        Assert.assertEquals(trainers.size(), 1);
    }

    @Test
    public void getByDateOfBirth() {
        when(trainerService.getTrainersByDateOfBirth(trainerDTO.getDateOfBirth())).thenReturn(Arrays.asList(trainer));
        when(mappingService.mapTo(any(), eq(TrainerDTO.class))).thenReturn(Arrays.asList(trainerDTO));

        List<TrainerDTO> trainers = trainerFacade.getTrainersByDateOfBirth(trainerDTO.getDateOfBirth());

        Assert.assertEquals(trainers.size(), 1);
    }

    @Test
    public void getByGym() {
        when(trainerService.getTrainerByGym(gym)).thenReturn(trainer);
        when(mappingService.mapTo(trainer, TrainerDTO.class)).thenReturn(trainerDTO);
        when(mappingService.mapTo(gymDTO, Gym.class)).thenReturn(gym);

        TrainerDTO trainer = trainerFacade.getTrainerByGym(gymDTO);
        Assert.assertEquals(trainer.getName(), trainerDTO.getName());
    }

    @Test
    public void trainerQualified() {
        when(trainerService.getTrainerByGym(gym)).thenReturn(trainer);
        when(mappingService.mapTo(trainer, TrainerDTO.class)).thenReturn(trainerDTO);
        when(mappingService.mapTo(tournamentDTO, Tournament.class)).thenReturn(tournament);

        Assert.assertFalse(trainerFacade.isTrainerQualifiedForTournament(trainerDTO, tournamentDTO));
    }
}
