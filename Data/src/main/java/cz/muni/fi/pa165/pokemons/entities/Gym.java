package cz.muni.fi.pa165.pokemons.entities;

import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Entity class representing gym object
 *
 * @author Matus Krska
 */
@Entity
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    //@NotNull 
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Trainer getGymLeader() {
        return gymLeader;
    }

    public void setGymLeader(Trainer gymLeader) {
        this.gymLeader = gymLeader;
    }

    public PokemonType getTypology() {
        return typology;
    }

    public void setTypology(PokemonType typology) {
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
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        final Gym gym = (Gym) obj;

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
        int hash = 19;
        hash = 31 * hash + Objects.hashCode(this.cityName != null ? this.cityName.hashCode() : 0);
        hash = 31 * hash + Objects.hashCode(this.typology != null ? this.typology.hashCode() : 0);
        return hash;
    }
}
