package cz.muni.fi.pa165.pokemons.entities;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Roman Gluszny
 */
public class GymLeader extends Trainer{
    @NotNull
    @Column(nullable = false)
    private Gym gym;

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    } 
}

