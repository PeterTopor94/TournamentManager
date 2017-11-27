package cz.muni.fi.pa165.pokemons.DTO;

import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import javax.validation.constraints.NotNull;

public class NewGymTypologyDTO
{
    private Long gymId;

    @NotNull
    private PokemonType typology;

    public Long getGymId()
    {
        return gymId;
    }

    public void setGymId(Long gymId)
    {
        this.gymId = gymId;
    }

    public PokemonType getTypology()
    {
        return typology;
    }

    public void setTypology(PokemonType typology)
    {
        this.typology = typology;
    }
}
