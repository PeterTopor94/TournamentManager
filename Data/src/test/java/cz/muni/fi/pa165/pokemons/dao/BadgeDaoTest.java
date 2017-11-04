package cz.muni.fi.pa165.pokemons.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.muni.fi.pa165.pokemons.DataApplicationContext;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Roman Gluszny
 */
@ContextConfiguration(classes = DataApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class BadgeDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private BadgeDao badgeDao;

    private Badge b1;
    private Badge b2;

    @Autowired
    private GymDao gymDao;

    private Gym g1;
    private Gym g2;

    private Trainer t1;
    private Trainer t2;

    @Autowired
    private TrainerDao trainerDao;
    private Trainer t3;

    @PersistenceContext
    private EntityManager em;

    @BeforeMethod
    public void testSetup() {
        t1 = new Trainer();
        t1.setDateOfBirth(new Date(1992, 2, 5));
        t1.setName("John");
        t1.setSurname("Neuman");
        t1.setGym(g1);

        t2 = new Trainer();
        t2.setDateOfBirth(new Date(1995, 11, 9));
        t2.setName("Amelia");
        t2.setSurname("Stone");
        t2.setGym(g2);

        t3 = new Trainer();
        t3.setDateOfBirth(new Date(1996, 7, 9));
        t3.setName("Ash");
        t3.setSurname("Red");

        g1 = new Gym();
        g1.setBadge(b1);
        g1.setGymLeader(t1);
        g1.setCityName("Opal Town");
        g1.setTypology(PokemonType.FIRE);

        g2 = new Gym();
        g2.setBadge(b2);
        g2.setGymLeader(t2);
        g2.setCityName("Opal Town");
        g2.setTypology(PokemonType.WATER);

       

        b1 = new Badge();
        b1.setGym(g1);
        b1.addOwner(t3);

        b2 = new Badge();
        b2.setGym(g2);
        b2.addOwner(t1);
        b2.addOwner(t3);
        
        gymDao.create(g1);
        gymDao.create(g2);

        badgeDao.create(b1);
        badgeDao.create(b2);
        
        trainerDao.create(t1);
        trainerDao.create(t2);
        trainerDao.create(t3);
    }

    @Test
    public void findAll() {
        List<Badge> badges = badgeDao.findAll();
        Assert.assertEquals(badges.size(), 2);
    }

    @Test
    public void findByOwners() {
        List<Badge> badges = badgeDao.findByOwner(t3);
        Assert.assertEquals(badges.size(), 2);

        badges = badgeDao.findByOwner(t2);
        Assert.assertEquals(badges.size(), 0);
    }

    @Test
    public void remove() {
        badgeDao.remove(b1);
        List<Badge> badges = badgeDao.findAll();
        Assert.assertEquals(badges.size(), 1);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createBadgeWithNoGym() {
        Badge b = new Badge();
        b.setGym(null);
        badgeDao.create(b);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void addBadgeToOriginalGymLeader() {
        b1.addOwner(t1);
    }
}
