/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.DataApplicationContext;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Miroslav
 */
@ContextConfiguration(classes = DataApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class TrainerDaoTest  extends AbstractTestNGSpringContextTests
{
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

   @BeforeMethod
    public void testSetup() {


       trainer1 = new Trainer();
       trainer1.setName("Anthony");
       trainer1.setSurname("Hamilton");
       trainer1.setDateOfBirth(new Date(1990, 10, 5));
       trainer1.setLogin("hamilton");

       trainer2 = new Trainer();
       trainer2.setName("Arnold");
       trainer2.setSurname("Balboa");
       trainer2.setLogin("balboa");
       trainer2.setDateOfBirth(new Date(1990, 10, 5));

       trainer3 = new Trainer();
       trainer3.setName("Viktor");
       trainer3.setSurname("Holmes");
       trainer3.setLogin("holmes");
       trainer3.setDateOfBirth(new Date(1990, 10, 5));

       trainerDao.create(trainer1);
       trainerDao.create(trainer2);
       trainerDao.create(trainer3);

       gym1 = new Gym();
       gym1.setGymLeader(trainer1);
       gym1.setCityName("Tokyo");
       gym1.setTypology(PokemonType.FIRE);

       gym2 = new Gym();
       gym2.setGymLeader(trainer2);
       gym2.setCityName("Montreal");
       gym2.setTypology(PokemonType.FIRE);

       gym3 = new Gym();
       gym3.setGymLeader(trainer3);
       gym3.setCityName("New York");
       gym3.setTypology(PokemonType.FIRE);

       gymDao.create(gym1);
       gymDao.create(gym2);
       gymDao.create(gym3);


       trainer1.setGym(gym1);
       trainer2.setGym(gym2);
       trainer3.setGym(gym3);

       trainerDao.update(trainer1);
       trainerDao.update(trainer2);
       trainerDao.update(trainer3);

       badge1 = new Badge();
       badge1.setGym(gym1);
       badge1.addOwner(trainer1);
       badge1.setCityOfOrigin("Dakota");

       badge2 = new Badge();
       badge2.setGym(gym2);
       badge2.addOwner(trainer2);
       badge2.setCityOfOrigin("Dakota");

       badge3 = new Badge();
       badge3.setGym(gym3);
       badge3.addOwner(trainer3);
       badge3.setCityOfOrigin("Dakota");

       badgeDao.create(badge1);
       badgeDao.create(badge2);
       badgeDao.create(badge3);


       gym1.setBadge(badge1);
       gym2.setBadge(badge2);
       gym3.setBadge(badge3);

       badgeDao.update(badge1);
       badgeDao.update(badge2);
       badgeDao.update(badge3);
    }
        
   @Test
    public void create() {
        Trainer trainer3 = new Trainer();
        trainer3.setName("jon");
        trainer3.setSurname("bobrik");
        trainer3.setLogin("bobrik");
        trainer3.setDateOfBirth(new Date(1990, 10, 5));
        trainer3.setGym(gym1);
        trainerDao.create(trainer3);

        List<Trainer> listTrainers = trainerDao.findAll();
        Assert.assertEquals(listTrainers.size(), 4);
    }    
        
        
    @Test
    public void findAll() {
        List<Trainer> trainers = trainerDao.findAll();
        Assert.assertEquals(trainers.size(), 3);
    }   
        
      @Test
    public void remove() {
       /*gym3.setGymLeader(trainer2);
       gymDao.update(gym3);
       trainer3.removeBadge(badge3);
       trainerDao.update(trainer3);
        trainerDao.remove(trainer3);
        List<Trainer> trainer = trainerDao.findAll();
        Assert.assertEquals(trainer.size(), 2);*/
    }   
        
    @Test
    public void update() {
      
        trainer1.setName("bruklin");
        trainer1.setSurname("ovce");
        trainerDao.update(trainer1);
        Assert.assertEquals(trainer1.getName(), "bruklin");
    }   
        
   @Test
    public void getTrainerByNameSurename() {
        List<Trainer> trainers = trainerDao.findByNameAndSurname("Arnold", "Balboa");
        Assert.assertEquals(trainers.size(), 1);
    }

    @Test
    public void getTrainerByID() {
        Trainer tr = trainerDao.findById(trainer1.getId());
        Assert.assertEquals(tr, trainer1);
    }
    
}
