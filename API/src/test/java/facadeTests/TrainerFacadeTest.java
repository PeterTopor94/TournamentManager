package facadeTests;

import cz.muni.fi.pa165.pokemons.DTO.TrainerCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import cz.muni.fi.pa165.pokemons.facade.TrainerFacade;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Roman Gluszny
 */
public class TrainerFacadeTest {

    @Autowired
    private TrainerFacade tFacade;

    @BeforeMethod
    public void testSetup() {
        TrainerCreateDTO trainerDto = new TrainerCreateDTO();
        trainerDto.setName("Misty");
        trainerDto.setSurname("Blue");
        trainerDto.setDateOfBirth(new Date(1994, 1, 9));
        trainerDto.setGymId(new Long("1"));

        tFacade.createTrainer(trainerDto);
    }

    @Test
    public void create() {
        TrainerCreateDTO trainerDto = new TrainerCreateDTO();
        trainerDto.setName("Jon");
        trainerDto.setSurname("Red");
        trainerDto.setDateOfBirth(new Date(1990, 10, 5));

        tFacade.createTrainer(trainerDto);

        List<TrainerDTO> listTrainers = tFacade.getAllTrainers();
        Assert.assertEquals(listTrainers.size(), 2);
    }

    @Test
    public void delete() {
        Long id = tFacade.getAllTrainers().get(0).getId();
        tFacade.deleteTrainer(id);

        List<TrainerDTO> listTrainers = tFacade.getAllTrainers();
        Assert.assertEquals(listTrainers.size(), 0);
    }
    
    @Test
    public void findByNameAndSurname() {
        List<TrainerDTO> listTrainers =tFacade.getTrainersByNameAndSurname("Misty", "Blue");
        Assert.assertEquals(listTrainers.size(), 1);
    }
    
    @Test
    public void findByBirthdate() {
        List<TrainerDTO> listTrainers =tFacade.getTrainersByDateOfBirth(new Date(1994, 1, 9));
        Assert.assertEquals(listTrainers.size(), 1);
    }
    
    @Test
    public void findByGym() {
        TrainerDTO trainer =tFacade.getTrainerByGym(new Long("1"));
        Assert.assertEquals(trainer.getName(), "Misty");
    }
}
