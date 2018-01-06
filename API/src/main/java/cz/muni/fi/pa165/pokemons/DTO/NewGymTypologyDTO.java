package cz.muni.fi.pa165.pokemons.DTO;

import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import javax.validation.constraints.NotNull;
import java.util.Objects;

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
        final NewGymTypologyDTO gym = (NewGymTypologyDTO) obj;
        
        if (this.gymId != null ? !this.gymId.equals(gym.gymId) : gym.gymId != null) {
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
        hash = 41 * hash + Objects.hashCode(this.gymId != null ? this.gymId.hashCode() : 0);
        hash = 41 * hash + Objects.hashCode(this.typology != null ? this.typology.hashCode() : 0);
        return hash;
    }
}
