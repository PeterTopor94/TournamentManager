package cz.muni.fi.pa165.pokemons.service;

import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymServiceImpl implements GymService
{
    @Override
    public void createGym(Gym gym)
    {
        //TODO
    }

    @Override
    public void deleteGym(Gym gym)
    {
        //TODO
    }

    @Override
    public Gym findById(Long id)
    {
        //TODO
        return null;
    }

    @Override
    public List<Gym> findAllGyms()
    {
        //TODO
        return null;
    }

    @Override
    public void changeTypology(Gym gym, PokemonType newTypology)
    {
        //TODO
    }
}
