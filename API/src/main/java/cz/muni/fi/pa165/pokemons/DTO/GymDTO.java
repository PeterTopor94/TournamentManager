package cz.muni.fi.pa165.pokemons.DTO;

import cz.muni.fi.pa165.pokemons.enums.PokemonType;

/**
 * Data transfer object for Gym
 * @author Matus Krska
 */
public class GymDTO
{
    private Long id;

    private BadgeDTO badge;

    private String cityName;

    private GymLeaderDTO gymLeader;

    private PokemonType typology;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public BadgeDTO getBadge()
    {
        return badge;
    }

    public void setBadge(BadgeDTO badge)
    {
        this.badge = badge;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public GymLeaderDTO getGymLeader()
    {
        return gymLeader;
    }

    public void setGymLeader(GymLeaderDTO gymLeader)
    {
        this.gymLeader = gymLeader;
    }

    public PokemonType getTypology()
    {
        return typology;
    }

    public void setTypology(PokemonType typology)
    {
        this.typology = typology;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GymDTO gymDTO = (GymDTO) o;

        if (getId() != null ? !getId().equals(gymDTO.getId()) : gymDTO.getId() != null) return false;
        if (getCityName() != null ? !getCityName().equals(gymDTO.getCityName()) : gymDTO.getCityName() != null)
            return false;
        return getTypology() == gymDTO.getTypology();
    }

    @Override
    public int hashCode()
    {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCityName() != null ? getCityName().hashCode() : 0);
        result = 31 * result + getTypology().hashCode();
        return result;
    }
}
