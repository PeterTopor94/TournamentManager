package cz.muni.fi.pa165.pokemons.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lubos.beno
 */
@Entity
public class Badge {

    @NotNull
    @Column(nullable = false)
    private String cityOfOrigin;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull
    private Gym gym;

    @ManyToMany
    private List<Trainer> owners = new ArrayList<>();

    public Badge() {

    }

    public Badge(String cityOfOrigin, Gym gym, ArrayList<Trainer> owners) {
        this.cityOfOrigin = cityOfOrigin;
        this.gym = gym;
        this.owners = new ArrayList(owners);
    }

    public String getCityOfOrigin() {
        return this.cityOfOrigin;
    }

    public void setCityOfOrigin(String cityOfOrigin) {
        this.cityOfOrigin = cityOfOrigin;
    }

    public Gym getGym() {
        return this.gym;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public List<Trainer> getOwners() {
        return Collections.unmodifiableList(owners);
    }

    public void addOwner(Trainer owner) {
        this.owners.add(owner);
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
        
        final Badge badge = (Badge) obj;
        
        if (this.cityOfOrigin != null ? !this.cityOfOrigin.equals(badge.cityOfOrigin) : badge.cityOfOrigin != null) {
            return false;
        }
        if (this.gym != null ? !this.gym.getId().equals(badge.gym.getId()) : badge.gym.getId() != null) {
            return false;
        }
        return true;
    }
    
     @Override
     public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.cityOfOrigin != null ? this.cityOfOrigin.hashCode() : 0);
        hash = 37 * hash + Objects.hashCode(this.gym != null ? this.gym.getId().hashCode() : 0);
        return hash;
    }

}
