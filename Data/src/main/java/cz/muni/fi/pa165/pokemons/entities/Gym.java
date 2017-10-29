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
    private Trainer gymLeader;

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

        if (this.id != null ? !this.id.equals(gym.id) : gym.id != null) return false;
        if (this.badge != null ? !this.badge.equals(gym.badge) : gym.badge != null) return false;
        if (this.cityName != null ? !this.cityName.equals(gym.cityName) : gym.cityName != null) return false;
        if (this.gymLeader != null ? !this.gymLeader.equals(gym.gymLeader) : gym.gymLeader != null) return false;
        return this.typology == gym.typology;
    }

    @Override
    public int hashCode()
    {
        int result = this.id != null ? this.id.hashCode() : 0;
        result = 31 * result + (this.badge != null ? this.badge.hashCode() : 0);
        result = 31 * result + (this.cityName != null ? this.cityName.hashCode() : 0);
        result = 31 * result + (this.gymLeader != null ? this.gymLeader.hashCode() : 0);
        result = 31 * result + (this.typology != null ? this.typology.hashCode() : 0);
        return result;
    }
}
