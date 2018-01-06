package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.DataApplicationContext;
import cz.muni.fi.pa165.pokemons.entities.Pokemon;
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
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.List;

/**
 * Class testing functionality of {@link PokemonDao}
 * @author Matus Krska
 */
@ContextConfiguration(classes = DataApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class PokemonDaoTest extends AbstractTestNGSpringContextTests
{

    @Autowired
    private PokemonDao pokemonDao;

    @Autowired
    private TrainerDao trainerDao;

    @PersistenceContext
    private EntityManager em;

    private Pokemon p1;
    private Pokemon p2;
    private Pokemon p3;

    private Trainer t1;
    private Trainer t2;

    @BeforeMethod
    public void testSetup()
    {
        t1 = new Trainer();
        t1.setDateOfBirth(new Date(1992, 2, 5));
        t1.setName("John");
        t1.setSurname("Neuman");
        t1.setLogin("neuman");

        t2 = new Trainer();
        t2.setDateOfBirth(new Date(1995, 11, 9));
        t2.setName("Amelia");
        t2.setSurname("Stone");
        t2.setLogin("stone");

        trainerDao.create(t1);
        trainerDao.create(t2);

        p1 = new Pokemon();
        p1.setLevel(2);
        p1.setName("Pikachu");
        p1.setNickname("PikaPika");
        p1.setOwner(t1);
        p1.setType(PokemonType.ELECTRIC);

        p2 = new Pokemon();
        p2.setLevel(10);
        p2.setName("Bulbasaur");
        p2.setNickname("Bubu");
        p2.setOwner(t1);
        p2.setType(PokemonType.GRASS);

        p3 = new Pokemon();
        p3.setLevel(100);
        p3.setName("Charmander");
        p3.setNickname("Char");
        p3.setOwner(t2);
        p3.setType(PokemonType.FIRE);

        pokemonDao.create(p1);
        pokemonDao.create(p2);
        pokemonDao.create(p3);
    }

    @Test
    public void findAll()
    {
        List<Pokemon> found = pokemonDao.findAll();
        Assert.assertEquals(found.size(), 3);
    }

    @Test
    public void findById()
    {
        Pokemon found = pokemonDao.findById(p1.getId());
        Assert.assertEquals(found.getId(), p1.getId());
    }

    @Test
    public void findByOwner()
    {
        List<Pokemon> found = pokemonDao.findByOwner(t1);
        Assert.assertEquals(found.size(),2);

        List<Pokemon> found2 = pokemonDao.findByOwner(t2);
        Assert.assertEquals(found2.size(),1);
        Assert.assertEquals(found2.get(0).getId(),p3.getId());
    }

    @Test
    public void getByName()
    {
        List<Pokemon> found = pokemonDao.getPokemonsWithName("Pikachu");
        Assert.assertEquals(found.size(),1);
        Assert.assertEquals(found.get(0).getName(),"Pikachu");
    }

    @Test
    public void getByNickname()
    {
        List<Pokemon> found = pokemonDao.getPokemonsWithNickname("PikaPika");
        Assert.assertEquals(found.size(),1);
        Assert.assertEquals(found.get(0).getNickname(),"PikaPika");
    }

    @Test
    public void getByType()
    {
        List<Pokemon> found = pokemonDao.getPokemonsWithtype(PokemonType.FIRE);
        Assert.assertEquals(found.size(),1);
        Assert.assertEquals(found.get(0).getType(),PokemonType.FIRE);
    }

    @Test
    public void remove()
    {
        pokemonDao.remove(p1);

        Pokemon found = pokemonDao.findById(p1.getId());

        Assert.assertNull(found);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createPokemonWithNullName()
    {
        Pokemon p = new Pokemon();
        p.setType(PokemonType.FIRE);
        p.setOwner(t1);
        p.setNickname("a");
        p.setName(null);
        p.setLevel(1);

        pokemonDao.create(p);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createPokemonWithNullNickname()
    {
        Pokemon p = new Pokemon();
        p.setType(PokemonType.FIRE);
        p.setOwner(t1);
        p.setNickname(null);
        p.setName("a");
        p.setLevel(1);

        pokemonDao.create(p);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createPokemonWithNullType()
    {
        Pokemon p = new Pokemon();
        p.setType(null);
        p.setOwner(t1);
        p.setNickname("a");
        p.setName("a");
        p.setLevel(1);

        pokemonDao.create(p);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createPokemonWithNullLevel()
    {
        Pokemon p = new Pokemon();
        p.setType(PokemonType.FIRE);
        p.setOwner(t1);
        p.setNickname("a");
        p.setName("a");

        pokemonDao.create(p);
    }
}
