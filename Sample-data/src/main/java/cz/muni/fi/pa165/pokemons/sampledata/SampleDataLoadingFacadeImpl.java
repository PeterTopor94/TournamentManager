package cz.muni.fi.pa165.pokemons.sampledata;

import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Pokemon;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.service.*;
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
    @Inject
    private PokemonService pokemonService;
    @Inject
    private BadgeService badgeService;
    @Inject
    private TournamentService tournamentService;

    @Override
    public void loadData() throws IOException
    {
        //trainers
        Trainer admin = trainer("Ash", "Kechum", "kechum", "kechum", new Date());
        Trainer trainer = trainer("John", "Trainer", "trainer", "trainer", new Date());

        Gym gym1 = gym("Brno", PokemonType.DRAGON, admin);
        Gym gym2 = gym("Prague", PokemonType.FIRE, trainer);
        
        Pokemon pok1 = pokemon("Pikachu", "Bolt", 15, PokemonType.ELECTRIC, admin);
        Pokemon pok2 = pokemon("Charizard", "Torch", 73, PokemonType.FIRE, trainer);

        Badge badge1 = badge(gym1);
        Badge badge2 = badge(gym2);
        
        Tournament grassTournament = tournament("Grass Tournament", trainer, badge1);

    }
    
     private Tournament tournament(String name,Trainer trainer, Badge badge)
    {
        trainer.addBadge(badge);
        Tournament tournament = new Tournament();
        tournament.setName(name);
        tournament.setNumRequiredBadges(1);
        tournament.addTrainer(trainer);
        
        tournamentService.createTournament(tournament);

        return tournament;

    }
    
    private Badge badge(Gym gym)
    {
        Badge badge = new Badge();
        badge.setCityOfOrigin(gym.getCityName());
        badge.setGym(gym);
        badgeService.createBadge(badge);

        return badge;

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
    
    private Pokemon pokemon(String name, String nickname, Integer level, PokemonType typology, Trainer owner)
    {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(name);
        pokemon.setNickname(nickname);
        pokemon.setLevel(level);
        pokemon.setType(typology);
        pokemon.setOwner(owner);

        pokemonService.createPokemon(pokemon);

        return pokemon;
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
