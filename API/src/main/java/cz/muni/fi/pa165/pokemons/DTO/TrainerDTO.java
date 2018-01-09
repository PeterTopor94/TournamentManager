package cz.muni.fi.pa165.pokemons.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Roman Gluszny
 */
public class TrainerDTO {
    private Long id;
    
    private String name;
    
    private String surname;
    
    private List<BadgeDTO> badges = new ArrayList<>();
    
    private List<PokemonDTO> pokemons = new ArrayList<>();
    
    private Date dateOfBirth;
    
    private GymDTO gym;
    
    private TournamentDTO placement;

    private String login;

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<BadgeDTO> getBadges() {
        return badges;
    }

    public void setBadges(List<BadgeDTO> badges) {
        this.badges = badges;
    }

    public List<PokemonDTO> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<PokemonDTO> pokemons) {
        this.pokemons = pokemons;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public GymDTO getGym() {
        return gym;
    }

    public void setGym(GymDTO gym) {
        this.gym = gym;
    }
    
    public TournamentDTO getPlacement() {
        return placement;
    }

    public void setPlacement(TournamentDTO placement) {
        this.placement = placement;
   }
    
    /**
     * placeholder for demo purposes
     * @return
     */
    public boolean isAdmin()
    {
        return login.equals("kechum");
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
        
        final TrainerDTO trainer = (TrainerDTO) obj;
        
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
        int hash = 23;
        hash = 49 * hash + Objects.hashCode(this.name != null ? this.name.hashCode() : 0);
        hash = 49 * hash + Objects.hashCode(this.surname != null ? this.surname.hashCode() : 0);
        hash = 49 * hash + Objects.hashCode(this.dateOfBirth != null ? this.dateOfBirth.hashCode() : 0);
        return hash;
    }
}
