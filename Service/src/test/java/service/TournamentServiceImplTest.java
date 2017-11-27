/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cz.muni.fi.pa165.pokemons.dao.TournamentDao;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.service.TournamentServiceImpl;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
/**
 *
 * @author Miroslav
 */
public class TournamentServiceImplTest {
   @Mock  
   private TournamentDao leagueDao;
    
    
    private Tournament league1;
    private Tournament league2;
    private Tournament league3;
    private Tournament league4;
    
    private Trainer trainer1;
    private Trainer trainer2;
    private Trainer trainer3;
    private Trainer trainer4;
    
    public TournamentServiceImplTest() {
    }
    
   
    
    @Before
    public void setUp() {
       league1 = new Tournament();
                   league1.setName("League 1");
                   league1.setNumRequiredBadges(4);
                 
        league2 = new Tournament();
                   league2.setName("League 2");
                   league2.setNumRequiredBadges(3);
                   
        league3 = new Tournament();
                   league3.setName("League 3");
                   league3.setNumRequiredBadges(2);
        
        league4 = new Tournament();
                   league3.setName("League 4");
                   league3.setNumRequiredBadges(1);
        
        
        
       trainer1 = new Trainer();
                trainer1.setName("bob");
                trainer1.setSurname("Chalinger");
                trainer1.setDateOfBirth(new Date());
   
        trainer2 = new Trainer();
                trainer2.setName("bob");
                trainer2.setSurname("Chalinger");
                trainer2.setDateOfBirth(new Date());
                
        trainer3 = new Trainer();
                trainer3.setName("bob");
                trainer3.setSurname("Chalinger");
                trainer3.setDateOfBirth(new Date());
                
        trainer4 = new Trainer();
                trainer4.setName("bob");
                trainer4.setSurname("Chalinger");
                trainer4.setDateOfBirth(new Date());
        
    }
    
  

    /**
     * Test of createTournament method, of class TournamentServiceImpl.
     */
    @Test
    public void testCreateTournament() {
        System.out.println("createTournament");
       
        TournamentServiceImpl instance = new TournamentServiceImpl();
        instance.createTournament(league1);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals();
    }

    /**
     * Test of removeTournament method, of class TournamentServiceImpl.
     */
    @Test
    public void testRemoveTournament() {
        System.out.println("removeTournament");
        Tournament tournament = null;
        TournamentServiceImpl instance = new TournamentServiceImpl();
        instance.removeTournament(tournament);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTrainer method, of class TournamentServiceImpl.
     */
    @Test
    public void testRemoveTrainer() {
        System.out.println("removeTrainer");
        Tournament tournament = 
        Trainer trainer =
       
        TournamentServiceImpl instance = new TournamentServiceImpl();
        instance.removeTrainer(tournament, trainer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllTournaments method, of class TournamentServiceImpl.
     */
    @Test
    public void testGetAllTournaments() {
        System.out.println("getAllTournaments");
        TournamentServiceImpl instance = new TournamentServiceImpl();
        List<Tournament> expResult = null;
        List<Tournament> result = instance.getAllTournaments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateTournaments method, of class TournamentServiceImpl.
     */
    @Test
    public void testUpdateTournaments() {
        System.out.println("updateTournaments");
        Tournament turnament = null;
        TournamentServiceImpl instance = new TournamentServiceImpl();
        instance.updateTournaments(turnament);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllTournaments method, of class TournamentServiceImpl.
     */
    @Test
    public void testFindAllTournaments() {
        System.out.println("findAllTournaments");
        TournamentServiceImpl instance = new TournamentServiceImpl();
        List<Tournament> expResult = null;
        List<Tournament> result = instance.findAllTournaments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findTournmanetById method, of class TournamentServiceImpl.
     */
    @Test
    public void testFindTournmanetById() {
        System.out.println("findTournmanetById");
        Long id = null;
        TournamentServiceImpl instance = new TournamentServiceImpl();
        Tournament expResult = null;
        Tournament result = instance.findTournmanetById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findTournamentByName method, of class TournamentServiceImpl.
     */
    @Test
    public void testFindTournamentByName() {
        System.out.println("findTournamentByName");
        String name = "";
        TournamentServiceImpl instance = new TournamentServiceImpl();
        Tournament expResult = null;
        Tournament result = instance.findTournamentByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNameOfTournament method, of class TournamentServiceImpl.
     */
    @Test
    public void testSetNameOfTournament() {
        System.out.println("setNameOfTournament");
        Tournament tournament = null;
        String name = "";
        TournamentServiceImpl instance = new TournamentServiceImpl();
        instance.setNameOfTournament(tournament, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
