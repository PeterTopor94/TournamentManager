package cz.muni.fi.pa165.pokemons.entities;

import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity class representing gym object
 * @author Matus Krska
 */
@Entity
public class Gym
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    //TODO uncomment when Trainer and Badge entities are ready
//    @OneToOne
//    @NotNull
//    private Badge badge;
//
//    /**
//     * city where the gym is located
//     */
//    @Column
//    private String city;
//
//    @OneToOne
//    @NotNull
//    private Trainer gymLeader;
//
//    /**
//     * dominant type of gym
//     */
//    @Column(nullable = false)
//    @Enumerated
//    @NotNull
//    private PokemonType type;
//
//    @Override
//    public boolean equals(Object o)
//    {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Gym gym = (Gym) o;
//
//        if (id != null ? !id.equals(gym.id) : gym.id != null) return false;
//        if (badge != null ? !badge.equals(gym.badge) : gym.badge != null) return false;
//        if (city != null ? !city.equals(gym.city) : gym.city != null) return false;
//        if (gymLeader != null ? !gymLeader.equals(gym.gymLeader) : gym.gymLeader != null) return false;
//        return type == gym.type;
//    }
//
//    @Override
//    public int hashCode()
//    {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (badge != null ? badge.hashCode() : 0);
//        result = 31 * result + (city != null ? city.hashCode() : 0);
//        result = 31 * result + (gymLeader != null ? gymLeader.hashCode() : 0);
//        result = 31 * result + (type != null ? type.hashCode() : 0);
//        return result;
//    }
}
