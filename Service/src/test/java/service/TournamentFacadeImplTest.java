/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cz.muni.fi.pa165.pokemons.DTO.TournamentDTO;
import cz.muni.fi.pa165.pokemons.service.facade.TournamentFacadeImpl;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miroslav
 */
public class TournamentFacadeImplTest {
    
    public TournamentFacadeImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class TournamentFacadeImpl.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        TournamentDTO tournament = null;
        TournamentFacadeImpl instance = new TournamentFacadeImpl();
        Long expResult = null;
        Long result = instance.create(tournament);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removTrainer method, of class TournamentFacadeImpl.
     */
    @Test
    public void testRemovTrainer() {
        System.out.println("removTrainer");
        Long idTournament = null;
        Long idTrainer = null;
        TournamentFacadeImpl instance = new TournamentFacadeImpl();
        instance.removTrainer(idTournament, idTrainer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTournament method, of class TournamentFacadeImpl.
     */
    @Test
    public void testRemoveTournament() {
        System.out.println("removeTournament");
        Long id = null;
        TournamentFacadeImpl instance = new TournamentFacadeImpl();
        instance.removeTournament(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNameOfTournament method, of class TournamentFacadeImpl.
     */
    @Test
    public void testSetNameOfTournament() {
        System.out.println("setNameOfTournament");
        Long id = null;
        String name = "";
        TournamentFacadeImpl instance = new TournamentFacadeImpl();
        instance.setNameOfTournament(id, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllTournaments method, of class TournamentFacadeImpl.
     */
    @Test
    public void testGetAllTournaments() {
        System.out.println("getAllTournaments");
        TournamentFacadeImpl instance = new TournamentFacadeImpl();
        List<TournamentDTO> expResult = null;
        List<TournamentDTO> result = instance.getAllTournaments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class TournamentFacadeImpl.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        TournamentFacadeImpl instance = new TournamentFacadeImpl();
        List<TournamentDTO> expResult = null;
        List<TournamentDTO> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class TournamentFacadeImpl.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = null;
        TournamentFacadeImpl instance = new TournamentFacadeImpl();
        TournamentDTO expResult = null;
        TournamentDTO result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByName method, of class TournamentFacadeImpl.
     */
    @Test
    public void testFindByName() {
        System.out.println("findByName");
        String name = "";
        TournamentFacadeImpl instance = new TournamentFacadeImpl();
        TournamentDTO expResult = null;
        TournamentDTO result = instance.findByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
