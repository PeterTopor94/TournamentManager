package cz.muni.fi.pa165.pokemons.service;

import cz.muni.fi.pa165.pokemons.dao.GymDao;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implemantation of {@link GymService}
 * @author Matus Krska
 */
@Service
public class GymServiceImpl implements GymService
{

    public GymServiceImpl(GymDao gymDao)
    {
        this.gymDao = gymDao;
    }

    @Autowired
    private GymDao gymDao;

    @Override
    public void createGym(Gym gym)
    {
        gymDao.create(gym);
    }

    @Override
    public void deleteGym(Gym gym)
    {
        gymDao.remove(gym);
    }

    @Override
    public Gym findById(Long id)
    {
        return gymDao.getGymById(id);
    }

    @Override
    public List<Gym> findAllGyms()
    {
        return gymDao.getAllGyms();
    }

    @Override
    public void changeTypology(Gym gym, PokemonType newTypology)
    {
        gym.setTypology(newTypology);
        gymDao.update(gym);
    }

    @Override
    public Gym findGymByCity(String cityName)
    {
        return gymDao.getGymByCity(cityName);
    }

    @Override
    public Gym findGymByGymLeader(Trainer gymLeader)
    {
        return gymDao.getGymByLeader(gymLeader);
    }

    @Override
    public Gym findGymByBadge(Badge badge)
    {
        return gymDao.getGymByBadge(badge);
    }
}
