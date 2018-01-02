package service;

import cz.muni.fi.pa165.pokemons.dao.TournamentDao;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.service.TournamentService;
import cz.muni.fi.pa165.pokemons.service.TournamentServiceImpl;
import cz.muni.fi.pa165.pokemons.service.config.ServiceConfiguration;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
 * @author Miroslav
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class TournamentServiceTest {
    @Mock  
    private TournamentDao tournamentDao;

    private TournamentService tournamentService;

    private Tournament league1;
    
    private Trainer trainer1;
    
    private Badge badgeFIRE;
    private Badge badgeWATER;
    private Badge badgeGRASS; 
    
    @BeforeClass
    public void setUp() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        tournamentService = new TournamentServiceImpl(tournamentDao);
    }
    
    @BeforeMethod
    public void prepareTest() {    

        trainer1 = new Trainer();
        trainer1.setName("bob");
        trainer1.setSurname("Chalinger");
        trainer1.setDateOfBirth(new Date());
        trainer1.addBadge(badgeFIRE);   
       
        league1 = new Tournament();
        league1.setName("League 1");
        league1.setNumRequiredBadges(1);
        league1.setId(1L);

    }

    @Test
    public void testCreateTournament() { 
        tournamentService.createTournament(league1);
        verify(tournamentDao, times(1)).create(league1);   
    }

    @Test
    public void testRemoveTournament() {
        tournamentService.removeTournament(league1);
        verify(tournamentDao, times(1)).remove(league1);
    }

    @Test
    public void testAddTrainer() {
        league1.setNumRequiredBadges(1);
        tournamentService.addTrainer(league1, trainer1);
        verify(tournamentDao, times(1)).update(league1);
    }
    
    @Test
    public void testRemoveTrainer() {
        tournamentService.createTournament(league1);
        league1.removeTrainer(trainer1);
        verify(tournamentDao, times(1)).update(league1);
    }
 
    @Test
    public void testGetAllTournaments() {
        when(tournamentDao.getAllTournaments()).thenReturn(Arrays.asList(league1));
        List<Tournament> tournaments = tournamentService.getAllTournaments();
        Assert.assertEquals(tournaments.size(),1);     
    }

    @Test
    public void testFindAllTournaments() {
        when(tournamentDao.findAll()).thenReturn(Arrays.asList(league1));
        List<Tournament> tournaments = tournamentService.findAllTournaments();
        Assert.assertEquals(tournaments.size(),1);
    }

    @Test
    public void testFindTournmanetById() {
        when(tournamentDao.findById(1L)).thenReturn(league1);
        Tournament tournament = tournamentService.findTournmanetById(league1.getId());
        Assert.assertEquals(league1.getId(),tournament.getId());
    }

    @Test
    public void testFindTournamentByName() {
        when(tournamentDao.findByName(league1.getName())).thenReturn(league1);
        Tournament tournament = tournamentService.findTournamentByName(league1.getName());
        Assert.assertEquals(league1.getName(),tournament.getName());
    }

    @Test
    public void testSetNameOfTournament() {
        tournamentService.setNameOfTournament(league1, "blava");
        Tournament tournament = tournamentService.findTournamentByName(league1.getName());
        Assert.assertEquals(league1.getName(),tournament.getName());
    }
    
}
