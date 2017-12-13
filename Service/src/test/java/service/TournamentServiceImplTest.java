/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import cz.muni.fi.pa165.pokemons.dao.TournamentDao;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.service.TournamentService;
import cz.muni.fi.pa165.pokemons.service.TournamentServiceImpl;
import cz.muni.fi.pa165.pokemons.service.config.ServiceConfiguration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
/**
 *
 * @author Miroslav
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class TournamentServiceImplTest {
   @Mock  
   private TournamentDao tournamentDao;

   private TournamentService tournamentService;
    
    
    
   @Before
    public void setUp() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        tournamentService = new TournamentServiceImpl(tournamentDao);
    }//end of the setUp method
    
    
    
    //declaration of the object of type Tournament
    private Tournament league1,league2,league3,league4;
    //declaration of the object of type Trainer
    private Trainer trainer1,trainer2,trainer3,trainer4;
    //declaration of the object of type Badge
    private Badge badgeFIRE, badgeWATER, badgeGRASS;
    //declaration of the object of type Gym
    private Gym gymLondon, gymMadrid, gymPovazkaBystrica;
    
    
    @BeforeMethod
    public void beforeRunningTestMethods()
    {
        
      //initialization of the object of type Gym
        gymLondon = new Gym();
        gymLondon.setTypology(PokemonType.FIRE);
        gymLondon.setCityName("London");
        
        gymMadrid = new Gym();
        gymMadrid.setTypology(PokemonType.WATER);
        gymMadrid.setCityName("Madrid");
        
        gymPovazkaBystrica = new Gym();
        gymPovazkaBystrica.setTypology(PokemonType.GRASS);
        gymPovazkaBystrica.setCityName("PovazkaBystrica");
        
        //initialization of the object of type Badge        
        badgeFIRE = new Badge();
        badgeFIRE.setCityOfOrigin(gymLondon.getCityName());
        badgeFIRE.setGym(gymLondon);

        badgeWATER = new Badge();
        badgeWATER.setCityOfOrigin(gymMadrid.getCityName());
        badgeWATER.setGym(gymMadrid);
        
        badgeGRASS = new Badge(); 
        badgeGRASS.setCityOfOrigin(gymPovazkaBystrica.getCityName());
        badgeGRASS.setGym(gymPovazkaBystrica);
        
        
         //initialization of the object of type Trainer
       trainer1 = new Trainer();
                trainer1.setName("bob");
                trainer1.setSurname("Chalinger");
                trainer1.setDateOfBirth(new Date());
                trainer1.addBadge(badgeFIRE);
   
        trainer2 = new Trainer();
                trainer2.setName("bob");
                trainer2.setSurname("Chalinger");
                trainer2.setDateOfBirth(new Date());
                trainer2.addBadge(badgeFIRE);
                trainer2.addBadge(badgeWATER);
                
        trainer3 = new Trainer();
                trainer3.setName("bob");
                trainer3.setSurname("Chalinger");
                trainer3.setDateOfBirth(new Date());
                trainer3.addBadge(badgeFIRE);
                trainer3.addBadge(badgeWATER);
                trainer3.addBadge(badgeGRASS);
                
                
        trainer4 = new Trainer();
                trainer4.setName("bob");
                trainer4.setSurname("Chalinger");
                trainer4.setDateOfBirth(new Date());
        
        //initialization of the object of type Tournament
        league1 = new Tournament();
                   league1.setName("League 1");
                   league1.setNumRequiredBadges(1);
                   league1.addTrainer(trainer2);
                 
        league2 = new Tournament();
                   league2.setName("League 2");
                   league2.setNumRequiredBadges(2);
                   
        league3 = new Tournament();
                   league3.setName("League 3");
                   league3.setNumRequiredBadges(3);    
       
    }

    /**
     * Test of createTournament method, of class TournamentServiceImpl.
     */
    @Test
    public void testCreateTournament() {
        tournamentService.createTournament(league1);
        verify(tournamentDao, times(1)).create(league1);

    }

    /**
     * Test of removeTournament method, of class TournamentServiceImpl.
     */
    @Test
    public void testRemoveTournament() {
        tournamentService.removeTournament(league1);
        verify(tournamentDao, times(1)).remove(league1);
    }

    /**
     * Test of addTrainer method, of class TournamentServiceImpl.
    */
    @Test
    public void testAddTrainer() {
      tournamentService.createTournament(league1);
      league1.addTrainer(trainer1);

      verify(league1, times(1)).addTrainer(trainer1);
    }
    
    /**
     * Test of removeTrainer method, of class TournamentServiceImpl.
    */
    @Test
    public void testRemoveTrainer() {
      tournamentService.createTournament(league1);
      league1.removeTrainer(trainer1);
      verify(league1, times(1)).removeTrainer(trainer1);
    }
 
    /**
     * Test of getAllTournaments method, of class TournamentServiceImpl.
     */
    @Test
    public void testGetAllTournaments() {
       when(tournamentDao.getAllTournaments()).thenReturn(Arrays.asList(league1));

        List<Tournament> tournaments = tournamentService.getAllTournaments();
        Assert.assertEquals(tournaments.size(),1);
       
    }

    /**
     * Test of updateTournaments method, of class TournamentServiceImpl.
     */
    @Test
    public void testUpdateTournaments() {
       tournamentService.createTournament(league1);
       league1.setName("Zilina");
       tournamentService.updateTournaments(league1);
       
       Tournament tournament = tournamentService.findTournamentByName(league1.getName());
       Assert.assertEquals(league1.getName(),tournament.getName());
       
    }

    /**
     * Test of findAllTournaments method, of class TournamentServiceImpl.
     */
    @Test
    public void testFindAllTournaments() {
         when(tournamentDao.findAll()).thenReturn(Arrays.asList(league1));

        List<Tournament> tournaments = tournamentService.findAllTournaments();
        Assert.assertEquals(tournaments.size(),1);
    }

    /**
     * Test of findTournmanetById method, of class TournamentServiceImpl.
     */
    @Test
    public void testFindTournmanetById() {
       when(tournamentDao.findById(1L)).thenReturn(league1);

        Tournament tournament = tournamentService.findTournmanetById(league1.getId());

        Assert.assertEquals(league1.getId(),tournament.getId());
    }

    /**
     * Test of findTournamentByName method, of class TournamentServiceImpl.
     */
    @Test
    public void testFindTournamentByName() {
        when(tournamentDao.findByName(league1.getName())).thenReturn(league1);

        Tournament tournament = tournamentService.findTournamentByName(league1.getName());

        Assert.assertEquals(league1.getName(),tournament.getName());
    }

    /**
     * Test of setNameOfTournament method, of class TournamentServiceImpl.
     */
    @Test
    public void testSetNameOfTournament() {
      tournamentService.setNameOfTournament(league1, "blava");
      tournamentService.updateTournaments(league1);
       
      Tournament tournament = tournamentService.findTournamentByName(league1.getName());
      
        Assert.assertEquals(league1.getName(),tournament.getName());
    }
    
}
