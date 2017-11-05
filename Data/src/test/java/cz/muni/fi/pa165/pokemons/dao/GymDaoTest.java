package cz.muni.fi.pa165.pokemons.dao;

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
import org.testng.annotations.Test;
import cz.muni.fi.pa165.pokemons.DataApplicationContext;
import cz.muni.fi.pa165.pokemons.dao.GymDao;
import cz.muni.fi.pa165.pokemons.dao.TrainerDao;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lubos.beno
 */
@ContextConfiguration (classes = DataApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class GymDaoTest extends AbstractTestNGSpringContextTests {

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
        trainer1.setDateOfBirth(new Date(1990,10,5));
       // trainer1.setGym(gym1);
        
        
        trainer2 = new Trainer();
        trainer2.setName("Arnold");
        trainer2.setSurname("Balboa");
        trainer2.setDateOfBirth(new Date(1992,11,5));
       // trainer2.setGym(gym2);
       

        trainerDao.create(trainer1);
        trainerDao.create(trainer2);
        //trainerDao.create(trainer3);
        
        gym1 = new Gym();
       // gym1.setBadge(badge1);
        gym1.setGymLeader(trainer1);
        gym1.setCityName("Tokyo");
        gym1.setTypology(PokemonType.FIRE);

        gym2 = new Gym();
      //  gym2.setBadge(badge2);
        gym2.setGymLeader(trainer2);
        gym2.setCityName("Montreal");
        gym2.setTypology(PokemonType.POISON);

        gymDao.create(gym1);
        gymDao.create(gym2);
        
        badge1 = new Badge();
        badge1.setGym(gym1);
        badge1.setCityOfOrigin("Dublin");
       // badge1.addOwner(trainer1);

        badge2 = new Badge();
        badge2.setGym(gym2);
        badge2.setCityOfOrigin("Malawi");
      

        badgeDao.create(badge1);
        badgeDao.create(badge2);
        
        trainer3 = new Trainer();
        trainer3.setName("Viktor");
        trainer3.setSurname("Holmes");
        trainer3.setDateOfBirth(new Date(1996,10,6));
       
        trainerDao.create(trainer3);
        
       //gym1.setBadge(badge1);
        
       
    }

    @Test
    public void create() {
        Gym gym3 = new Gym();
        gym3.setGymLeader(trainer3);
        gym3.setCityName("Trstena");
        gym3.setTypology(PokemonType.POISON);
      
        gymDao.create(gym3);
       
        List<Gym> gyms = gymDao.getAllGyms();
        Assert.assertEquals(gyms.size(), 3);
    }

    @Test
    public void findAll() {
        List<Gym> gyms = gymDao.getAllGyms();
        Assert.assertEquals(gyms.size(), 2);
    }

    @Test
    public void remove() {
       /* 
        if(gym1.getGymLeader() != null){
            trainerDao.remove(gym1.getGymLeader());
        }
        if (gym1.getBadge()!= null){
            badgeDao.remove(gym1.getBadge());
        }*/
       /* gymDao.remove(gym1);
        List<Gym> gyms = gymDao.getAllGyms();
        Assert.assertEquals(gyms.size(), 1);
*/
    }

   

    @Test
    public void getGymByLeader() {
        Gym gym = gymDao.getGymByLeader(trainer2);
        Assert.assertEquals(gym, gym2);
    }

    @Test
    public void getGymByCity() {
        String city = "Tokyo";
        Gym gym = gymDao.getGymByCity(city);
        Assert.assertEquals(gym, gym1);
    }

    @Test
    public void update() {
        
        gym1.setCityName("Ohio");
        gymDao.update(gym1);
        Assert.assertEquals(gym1.getCityName(), "Ohio");
    }
}
