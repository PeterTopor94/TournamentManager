package cz.muni.fi.pa165.pokemons.DTO;

import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Roman Gluszny
 */
public class TrainerCreateDTO {

     @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Size(min = 3, max = 50)
    private String surname;
    
    private Long gymId;

    private Long badgeId;

    private Long pokemonId;

    private String login;

    @NotNull
    private Date dateOfBirth;

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
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

    public Long getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(Long badgeId) {
        this.badgeId = badgeId;
    }

    public Long getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Long pokemonId) {
        this.pokemonId = pokemonId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getGymId() {
        return gymId;
    }

    public void setGymId(Long gymId) {
        this.gymId = gymId;
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
        
        final TrainerCreateDTO trainer = (TrainerCreateDTO) obj;
        
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
        int hash = 19;
        hash = 49 * hash + Objects.hashCode(this.name != null ? this.name.hashCode() : 0);
        hash = 49 * hash + Objects.hashCode(this.surname != null ? this.surname.hashCode() : 0);
        hash = 49 * hash + Objects.hashCode(this.dateOfBirth != null ? this.dateOfBirth.hashCode() : 0);
        return hash;
    }
    
}
