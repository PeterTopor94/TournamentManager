package cz.muni.fi.pa165.pokemons.sampledata;

import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.service.GymService;
import cz.muni.fi.pa165.pokemons.service.Password;
import cz.muni.fi.pa165.pokemons.service.TrainerService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Date;

/**
 * @author Matus Krska
 */
@Component
@Transactional
public class SampleDataLoadingFacadeImpl implements SampleDataLoadingFacade
{
    @Inject
    private GymService gymService;
    @Inject
    private TrainerService trainerService;

    @Override
    public void loadData() throws IOException
    {
        //trainers
        Trainer admin = trainer("Ash", "Kechum", "kechum", "kechum", new Date());
        Trainer trainer = trainer("John", "Trainer", "trainer", "trainer", new Date());

        Gym gym1 = gym("Brno", PokemonType.DRAGON, admin);
        Gym gym2 = gym("Prague", PokemonType.FIRE, trainer);

    }

    private Gym gym(String cityName, PokemonType typology, Trainer gymleader)
    {
        Gym gym = new Gym();
        gym.setGymLeader(gymleader);
        gym.setCityName(cityName);
        gym.setTypology(typology);

        gymService.createGym(gym);

        return gym;
    }

    private Trainer trainer(String name, String surname, String login, String password, Date dateOfBirth)
    {
        Trainer trainer = new Trainer();
        trainer.setSurname(surname);
        trainer.setName(name);
        trainer.setLogin(login);
        trainer.setDateOfBirth(dateOfBirth);

        Password p = new Password();
        trainer.setPasswordHash(p.hash(password.toCharArray()));

        trainerService.createTrainer(trainer);

        return trainer;
    }
}
