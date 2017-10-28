package cz.muni.fi.pa165.pokemons.entities;

import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity class representing gym object
 * @author Matus Krska
 */
@Entity
@Getter
@Setter
public class Gym
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull
    private Badge badge;

    /**
     * cityName where the gym is located
     */
    @Column
    private String cityName;

    @OneToOne
    @NotNull
    private GymLeader gymLeader;

    /**
     * dominant typology of gym
     */
    @Column(nullable = false)
    @Enumerated
    @NotNull
    private PokemonType typology;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gym gym = (Gym) o;

        if (id != null ? !id.equals(gym.id) : gym.id != null) return false;
        if (badge != null ? !badge.equals(gym.badge) : gym.badge != null) return false;
        if (cityName != null ? !cityName.equals(gym.cityName) : gym.cityName != null) return false;
        if (gymLeader != null ? !gymLeader.equals(gym.gymLeader) : gym.gymLeader != null) return false;
        return typology == gym.typology;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (badge != null ? badge.hashCode() : 0);
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (gymLeader != null ? gymLeader.hashCode() : 0);
        result = 31 * result + (typology != null ? typology.hashCode() : 0);
        return result;
    }
}
