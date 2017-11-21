
package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.DataApplicationContext;
import cz.muni.fi.pa165.pokemons.entities.*;
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

import java.util.Calendar;


/**
 *
 * @author Peter Topor
 */
@ContextConfiguration(classes = DataApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class TournamentDaoTest extends AbstractTestNGSpringContextTests{
    
    @Autowired
    private TournamentDao tournamentDao;   
    private Tournament t1;
    private Tournament t2;
    
    @Autowired
    private TrainerDao trainerDao;
    private Trainer tr1;
    private Trainer tr2;   
    private Trainer gl1;
    private Trainer gl2;
    
    @Autowired
    private GymDao gymDao;
    private Gym g1;
    private Gym g2;
    
    @Autowired
    private BadgeDao badgeDao;
    private Badge b1;
    private Badge b2;
    
    @Autowired
    private PokemonDao pokemonDao;
    private Pokemon p1;
    private Pokemon p2;
    private Pokemon p3;
    private Pokemon p4;
    
    @BeforeMethod
    public void testSetup() {
        g1 = new Gym();
        g1.setCityName("London");      
        g1.setTypology(PokemonType.POISON);
        
        g2 = new Gym();
        g2.setCityName("Paris");
        g2.setTypology(PokemonType.BUG);
        
        b1 = new Badge();
        b1.setGym(g1);
        b1.setCityOfOrigin("Palley");
        
        b2 = new Badge();
        b2.setGym(g2);
        b2.setCityOfOrigin("Dakota");
        
        Calendar cal = Calendar.getInstance();
        tr1 = new Trainer();
        tr1.setName("John");
        tr1.setSurname("Smith");     
        cal.set(1999, 5, 12);
        tr1.setDateOfBirth(cal.getTime());
        tr1.addBadge(b1);
        tr1.addBadge(b2);
        
        tr2 = new Trainer();
        tr2.setName("Mike");
        tr2.setSurname("Lemon");
        cal.set(1994, 11, 10);
        tr2.setDateOfBirth(cal.getTime());
        tr2.addBadge(b1);
        tr2.addBadge(b2);
        
        gl1 = new Trainer();
        gl1.setName("Sarah");
        gl1.setSurname("Prescot");
        cal.set(1997, 1, 3);
        gl1.setDateOfBirth(cal.getTime());
        gl1.setGym(g1);
        g1.setGymLeader(gl1);
        
        gl2 = new Trainer();
        gl2.setName("Phill");
        gl2.setSurname("Rush");
        cal.set(1997, 10, 3);
        gl2.setDateOfBirth(cal.getTime());
        gl2.setGym(g2);
        g2.setGymLeader(gl2);
        
        p1 = new Pokemon();
        p1.setOwner(tr1);
        p1.setLevel(5);
        p1.setName("Pikachu");
        p1.setNickname("Bolt");
        p1.setType(PokemonType.ELECTRIC);
        
        p2 = new Pokemon();
        p2.setOwner(tr2);
        p2.setLevel(12);
        p2.setName("Catterpie");
        p2.setNickname("Worm");
        p2.setType(PokemonType.BUG);
        
        p3 = new Pokemon();
        p3.setOwner(gl1);
        p3.setLevel(15);
        p3.setName("Charmeleon");
        p3.setNickname("Torch");
        p3.setType(PokemonType.FIRE);
        
        p4 = new Pokemon();
        p4.setOwner(gl2);
        p4.setLevel(5);
        p4.setName("Bulbasaur");
        p4.setNickname("Bulby");
        p4.setType(PokemonType.GRASS);
        
        tr1.addPokemon(p1);
        tr2.addPokemon(p2);
        gl1.addPokemon(p3);
        gl2.addPokemon(p4);

        t1 = new Tournament();
        t1.setName("Masters");
        t1.setNumRequiredBadges(2);
        t1.addTrainer(tr1);
        
        t2 = new Tournament();
        t2.setName("Brawl");
        t2.setNumRequiredBadges(2);
        t2.addTrainer(tr1);
        
        trainerDao.create(tr1);
        trainerDao.create(tr2);
        trainerDao.create(gl1);
        trainerDao.create(gl2);
        
        pokemonDao.create(p1);
        pokemonDao.create(p2);
        pokemonDao.create(p3);
        pokemonDao.create(p4);
        gymDao.create(g1);
        gymDao.create(g2);
        badgeDao.create(b1);
        badgeDao.create(b2);
        
        tournamentDao.create(t1);
        tournamentDao.create(t2);

    }
    
    @Test
    public void findAll(){
       int size = tournamentDao.findAll().size();
       Assert.assertEquals(size, 2);
    }
    
    @Test
    public void findById(){
        Tournament t3 = tournamentDao.findById(t1.getId());
        Assert.assertEquals(t3, t1);
    }
    
    @Test
    public void findByName(){
        Tournament t3 = tournamentDao.findByName("Masters");
        Assert.assertEquals(t3, t1);
    }
    
    @Test
    public void remove(){
        tournamentDao.remove(t1);
        int size = tournamentDao.findAll().size();
        Assert.assertEquals(size, 1);
    }
    
    @Test
    public void update(){
        t1.setName("Masters2");
        tournamentDao.update(t1);
        Assert.assertEquals(t1.getName(), "Masters2");
        
    }
}
