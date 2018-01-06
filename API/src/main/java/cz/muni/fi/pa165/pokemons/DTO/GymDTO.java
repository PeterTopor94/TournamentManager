package cz.muni.fi.pa165.pokemons.DTO;

import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import java.util.Objects;

/**
 * Data transfer object for Gym
 * @author Matus Krska
 */
public class GymDTO
{
    private Long id;

    private BadgeDTO badge;

    private String cityName;

    private TrainerDTO gymLeader;

    private PokemonType typology;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BadgeDTO getBadge() {
        return badge;
    }

    public void setBadge(BadgeDTO badge) {
        this.badge = badge;
    }

    public String getCityName()  {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public TrainerDTO getGymLeader() {
        return gymLeader;
    }

    public void setGymLeader(TrainerDTO gymLeader) {
        this.gymLeader = gymLeader;
    }

    public PokemonType getTypology() {
        return typology;
    }

    public void setTypology(PokemonType typology) {
        this.typology = typology;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final GymDTO gym = (GymDTO) o;

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
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(this.cityName != null ? this.cityName.hashCode() : 0);
        hash = 31 * hash + Objects.hashCode(this.typology != null ? this.typology.hashCode() : 0);
        return hash;
    }
}
