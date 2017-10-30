/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Trainer;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import cz.muni.fi.pa165.pokemons.dao.BadgeDao;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.junit.JUnit3TestClass;
import cz.muni.fi.pa165.pokemons.DataApplicationContext;
import cz.muni.fi.pa165.pokemons.dao.GymDao;
import cz.muni.fi.pa165.pokemons.dao.TrainerDao;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import java.util.Date;


/**
 *
 * @author Miroslav
 */
public class TrainerDaoTest {
     @Autowired
    private GymDao gymDao;
    private Gym gym1;
    private Gym gym2;
    private Gym gym3;

    @Autowired
    private TrainerDao trainerDao;
    private Trainer trainer1;
    private Trainer trainer2;
    private Trainer trainer3;

    @Autowired
    private BadgeDao badgeDao;
    private Badge badge1;
    private Badge badge2;
    private Badge badge3;

    @PersistenceContext
    private EntityManager em;
    
    
    
    public TrainerDaoTest() {
    }
    
   @BeforeMethod
    public void testSetup() {
       
        trainer1 = new Trainer();
        trainer1.setName("Anthony");
        trainer1.setSurname("Hamilton");
        trainer1.setGym(gym1);
        
        trainer2 = new Trainer();
        trainer2.setName("Arnold");
        trainer2.setSurname("Balboa");
        trainer2.setGym(gym2);

        trainer3 = new Trainer();
        trainer3.setName("Viktor");
        trainer3.setSurname("Holmes");
        trainer3.setGym(gym3);

        trainerDao.create(trainer1);
        trainerDao.create(trainer2);
        trainerDao.create(trainer3);

        badge1 = new Badge();
        badge1.setGym(gym1);
        badge1.addOwner(trainer1);

        badge2 = new Badge();
        badge2.setGym(gym2);
        badge2.addOwner(trainer2);

        badge3 = new Badge();
        badge3.setGym(gym3);
        badge3.addOwner(trainer3);

        badgeDao.create(badge1);
        badgeDao.create(badge2);
        badgeDao.create(badge3);

        gym1 = new Gym();
        gym1.setBadge(badge1);
        gym1.setGymLeader(trainer1);
        gym1.setCityName("Tokyo");

        gym2 = new Gym();
        gym2.setBadge(badge2);
        gym2.setGymLeader(trainer2);
        gym2.setCityName("Montreal");

        gymDao.create(gym1);
        gymDao.create(gym2);

    }
        
   @Test
    public void create() {
        Trainer trainer3 = new Trainer();
        trainer3.setName("jon");
        trainer3.setSurname("bobrik");
        trainer3.setDateOfBirth(new Date("1989-09-07"));
        trainer3.setGym(gym1);
        trainerDao.create(trainer3);

        List<Trainer> listTrainers = trainerDao.findAll();
        Assert.assertEquals(listTrainers.size(), 4);
    }    
        
        
    @Test
    public void findAll() {
        List<Trainer> trainers = trainerDao.findAll();
        Assert.assertEquals(trainers.size(), 4);
    }   
        
      @Test
    public void remove() {
        trainerDao.remove(trainer3);
        List<Trainer> trainer = trainerDao.findAll();
        Assert.assertEquals(trainer.size(), 2);
    }   
        
    @Test
    public void update() {
      
        trainer1.setName("bruklin");
        trainerDao.update(trainer1);
        Assert.assertEquals(trainer1.getName(), "Ohio");
    }   
        
   

    
    
}
