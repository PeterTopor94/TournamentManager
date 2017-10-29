
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lubos.beno
 */
@ContextConfiguration
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class GymDaoTest extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private GymDao gymDao;
    private Gym gym1;
    private Gym gym2;
    
    @Autowired
    private TrainerDao trainerDao;
    private Trainer trainer1;
    private Trainer trainer2;
    
    @Autowired
    private BadgeDao badgeDao;
    private Badge badge1;
    private Badge badge2;
    
    @PersistenceContext
    private EntityManager em;
    
    @BeforeMethod
    public void testSetup(){
        trainer1 = new Trainer();
        trainer1.setName("Anthony");
        trainer1.setSurname("Hamilton");
        trainer1.setGym(gym1);
        
        trainer2 = new Trainer();
        trainer2.setName("Arnold");
        trainer2.setSurname("Balboa");
        trainer2.setGym(gym2);
        
        trainerDao.create(trainer1);
        trainerDao.create(trainer2);
        
        badge1 = new Badge();
        badge1.setGym(gym1);
        badge1.addOwner(trainer1);
        
        badge2 = new Badge();
        badge2.setGym(gym2);
        badge2.addOwner(trainer2);
        
        badgeDao.create(badge1);
        badgeDao.create(badge2);
        
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
   public void findAll(){
       List<Gym> gyms = gymDao.findAll();
       Assert.assertEquals(gyms.size(), 2);
   }
   
   @Test
   public void remove(){
       gymDao.remove(gym1);
       List<Gym> gyms = gymDao.findAll();
       Assert.assertEquals(gyms.size(), 1);
   }
   
   @Test
   public void getGymByBadge(){
       Gym gym = gymDao.findByBadge(badge1);
       Assert.assertEquals(gym, gym1);    
   }
   
   @Test
   public void getGymByLeader(){
       Gym gym = gymDao.getGymByLeader(trainer2);
       Assert.assertEquals(gym, gym2);       
   }
   
   @Test
   public void getGymByCity(){
       String city = "Tokyo";
       Gym gym = gymDao.getGymByCity(city);
       Assert.assertEquals(gym, gym1);
   }
    
   
    
    
}
