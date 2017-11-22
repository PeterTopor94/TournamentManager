package cz.muni.fi.pa165.pokemons.DTO;

import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import javax.validation.constraints.NotNull;

public class GymCreateDTO
{
    private Long badgeId;

    private Long gymLeaderId;

    private String cityName;

    @NotNull
    private PokemonType typology;

    public Long getBadgeId()
    {
        return badgeId;
    }

    public void setBadgeId(Long badgeId)
    {
        this.badgeId = badgeId;
    }

    public Long getGymLeaderId()
    {
        return gymLeaderId;
    }

    public void setGymLeaderId(Long gymLeaderId)
    {
        this.gymLeaderId = gymLeaderId;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
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
