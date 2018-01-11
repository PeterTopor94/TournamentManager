package cz.muni.fi.pa165.pokemons.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

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

    @ManyToMany(mappedBy = "owners")
    private List<Badge> badges = new ArrayList<>();

    @OneToMany(mappedBy = "owner")
    private List<Pokemon> pokemons = new ArrayList<>();
    
    @ManyToMany
    private List<Tournament> placements = new ArrayList<>();
    
    @NotNull
    @Column(nullable = false)
    private Date dateOfBirth;

    @NotNull
    @Column(nullable = false)
    private String login;

    @Column
    private String passwordHash;

    @OneToOne(mappedBy = "gymLeader")
    private Gym gym;
    
    public Trainer(){
        
    }
    
    public Trainer(Long id) {
        this.id = id;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
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
    
    public void removeBadge(Badge b) {
        badges.remove(b);
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
    
    public List<Tournament> getPlacements() {
        return Collections.unmodifiableList(placements);
    }

    public void addPlacement(Tournament placement) {
        this.placements.add(placement);
    }
    
    public void removePlacement(Tournament placement) {
        this.placements.remove(placement);
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
        
        final Trainer trainer = (Trainer) obj;
        
        if (this.name != null ? !this.name.equals(trainer.name) : trainer.name != null) {
            return false;
        }
        if (this.surname != null ? !this.surname.equals(trainer.surname) : trainer.surname != null) {
            return false;
        }
        if (this.dateOfBirth != null ? !this.dateOfBirth.equals(trainer.dateOfBirth) : trainer.dateOfBirth != null) {
            return false;
        }

        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 49 * hash + Objects.hashCode(this.name != null ? this.name.hashCode() : 0);
        hash = 49 * hash + Objects.hashCode(this.surname != null ? this.surname.hashCode() : 0);
        hash = 49 * hash + Objects.hashCode(this.dateOfBirth != null ? this.dateOfBirth.hashCode() : 0);
        return hash;
    }

}
