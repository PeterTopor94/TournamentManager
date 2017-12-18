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

    @NotNull
    @Column(nullable = false)
    private Date dateOfBirth;

    @NotNull
    @Column(nullable = false)
    private String login;

    @Column
    private String passwordHash;

    @OneToOne
    private Gym gym;

    public Trainer() {
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

    public void leaveTournament(Tournament t) {
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
        return Objects.equals(this.id, other.id);
    }

}
