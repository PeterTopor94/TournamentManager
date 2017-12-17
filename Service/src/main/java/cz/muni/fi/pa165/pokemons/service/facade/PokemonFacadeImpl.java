/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.service.facade;

import javax.inject.Inject;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.muni.fi.pa165.pokemons.facade.PokemonFacade;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import cz.muni.fi.pa165.pokemons.DTO.PokemonCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.PokemonDTO;

import cz.muni.fi.pa165.pokemons.service.BeanMappingService;
import cz.muni.fi.pa165.pokemons.service.PokemonService;
import cz.muni.fi.pa165.pokemons.service.TrainerService;

import cz.muni.fi.pa165.pokemons.entities.Pokemon;
import cz.muni.fi.pa165.pokemons.entities.Trainer;



/**
 *
 * @author Peter Topor
 */
@Service
@Transactional
public class PokemonFacadeImpl implements PokemonFacade{
    
    @Inject
    PokemonService pokemonService;
    
    @Inject
    TrainerService trainerService;
    
    @Autowired
    BeanMappingService beanMappingService;
    
    public PokemonFacadeImpl(PokemonService pokemonService, BeanMappingService beanMappingService, TrainerService trainerService)
    {
        this.pokemonService = pokemonService;
        this.beanMappingService = beanMappingService;
        this.trainerService = trainerService;
    }
    
    @Override
    public Long createPokemon(PokemonCreateDTO p){
        Pokemon mappedPokemon = beanMappingService.mapTo(p, Pokemon.class);
        mappedPokemon.setLevel(p.getLevel());
        mappedPokemon.setName(p.getName());
        mappedPokemon.setNickname(p.getNickname());
        mappedPokemon.setType(p.getPokemonType());
        mappedPokemon.setOwner(trainerService.findTrainerById(p.getOwnerId()));
        Pokemon newPokemon = pokemonService.createPokemon(mappedPokemon);
        return newPokemon.getId();
    }

    @Override
    public void setOwner(Long pokemonId, Long trainerId){
        pokemonService.setOwner(pokemonService.findById(pokemonId),
                trainerService.findTrainerById(trainerId));
    }
    
    @Override
    public void setLevel(Long pokemonId, int level){
        pokemonService.setLevel(pokemonService.findById(pokemonId), level);
    }
    
    @Override
    public void setName(Long pokemonId, String name){
        pokemonService.setName(pokemonService.findById(pokemonId), name);
    }
    
    @Override
    public void setNickname(Long pokemonId, String nickname){
        pokemonService.setNickname(pokemonService.findById(pokemonId), nickname);
    }
    
    @Override
    public void setPokemonType(Long pokemonId, PokemonType pokemonType){
        pokemonService.setPokemonType(pokemonService.findById(pokemonId), pokemonType);
    }
    
    @Override
    public void deletePokemon(Long pokemonId){
        pokemonService.deletePokemon(pokemonService.findById(pokemonId));
    }
    
    @Override
    public List<PokemonDTO> getAllPokemon(){
        return beanMappingService.mapTo(pokemonService.findAll(), PokemonDTO.class);
    }
    
    @Override
    public List<PokemonDTO> getPokemonByTrainer(Long trainerId){
        Trainer t = trainerService.findTrainerById(trainerId);
	return beanMappingService.mapTo(t.getPokemons(), PokemonDTO.class);
    }
    
    @Override
    public PokemonDTO getPokemonById(Long pokemonId){
        Pokemon p = pokemonService.findById(pokemonId);
	return (p == null) ? null : beanMappingService.mapTo(p, PokemonDTO.class);
    }
    
}
