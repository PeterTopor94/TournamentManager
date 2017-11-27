package serviceBusinessFunctionTests;

import cz.muni.fi.pa165.pokemons.dao.TrainerDao;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.service.TrainerService;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Roman Gluszny
 */
public class TrainerServiceTest {

    @Mock
    private TrainerDao trainerDao;

    @Autowired
    @InjectMocks
    private TrainerService trainerService;

    private Tournament tournament;

    private Badge stoneBadge;

    private Trainer trainerQualified;
    private Trainer trainerNotQualified;

    @BeforeMethod
    public void createTrainers() {
        tournament = new Tournament();
        tournament.setNumRequiredBadges(1);
        
        stoneBadge = new Badge();

        trainerQualified = new Trainer();
        trainerNotQualified = new Trainer();
        
        trainerQualified.addBadge(stoneBadge);
    }

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
   public void trainerWithBadgeQualified() {
        Assert.assertTrue(trainerService.isTrainerQualifiedForTournament(trainerQualified, tournament), "order total price is wrong");
    }
   
   @Test
   public void trainerWithoutBadgeQualified() {
        Assert.assertFalse(trainerService.isTrainerQualifiedForTournament(trainerNotQualified, tournament), "order total price is wrong");
    }
}
