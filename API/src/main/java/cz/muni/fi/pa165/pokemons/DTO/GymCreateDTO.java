package cz.muni.fi.pa165.pokemons.DTO;

import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import javax.validation.constraints.NotNull;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final GymCreateDTO gym = (GymCreateDTO) obj;
        
        if (this.cityName != null ? !this.cityName.equals(gym.cityName) : gym.cityName != null) {
            return false;
        }
        if (this.typology != null ? !this.typology.equals(gym.typology) : gym.typology != null) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.cityName != null ? this.cityName.hashCode() : 0);
        hash = 67 * hash + Objects.hashCode(this.typology != null ? this.typology.hashCode() : 0);
        return hash;
    }
}
