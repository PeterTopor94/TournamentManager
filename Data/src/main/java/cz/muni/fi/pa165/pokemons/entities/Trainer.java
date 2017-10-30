package cz.muni.fi.pa165.pokemons.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Roman Gluszny
 */
@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String surname;

    @ManyToMany(mappedBy = "trainers")
    private Set<Badge> badges = new HashSet<Badge>();
    
    @OneToMany
    private List<Pokemon> pokemons = new ArrayList<>();

    @NotNull
    @Column(nullable = false)
    private Date dateOfBirth;
    
    @OneToOne
    @Column(nullable = true)
    private Gym gym;

    @Column
    private Gym gym;

    public Trainer() {
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public Trainer(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Badge> getBadges() {
        return Collections.unmodifiableList(badges);
    }

    public void addBadge(Badge b) {
        badges.add(b);
    }
    
    public List<Pokemon> getPokemons() {
        return pokemons;
    }
    
    public void addPokemon(Pokemon p) {
        pokemons.add(p);
    }
    
    public void removePokemon(Pokemon p) {
        pokemons.remove(p);
    }
    
    public void leaveTournament(Tournament t)
    {
        t.removeTrainer(this);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
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
        final Trainer other = (Trainer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    


}
