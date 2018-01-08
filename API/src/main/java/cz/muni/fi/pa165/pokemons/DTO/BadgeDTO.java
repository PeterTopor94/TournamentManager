package cz.muni.fi.pa165.pokemons.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lubos.beno
 */
public class BadgeDTO {

    private String cityOfOrigin;

    private Long id;

    private GymDTO gym;

    @JsonBackReference
    private List<TrainerDTO> owners = new ArrayList<>();

    public String getCityOfOrigin() {
        return cityOfOrigin;
    }

    public void setCityOfOrigin(String cityOfOrigin) {
        this.cityOfOrigin = cityOfOrigin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GymDTO getGym() {
        return gym;
    }

    public void setGym(GymDTO gym) {
        this.gym = gym;
    }

    public List<TrainerDTO> getOwners() {
        return owners;
    }

    public void setOwners(List<TrainerDTO> owners) {
        this.owners = owners;
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
        
        final BadgeDTO badge = (BadgeDTO) obj;
        
        if (this.cityOfOrigin != null ? !this.cityOfOrigin.equals(badge.cityOfOrigin) : badge.cityOfOrigin != null) {
            return false;
        }
        if (this.gym.getId() != null ? !this.gym.getId().equals(badge.gym.getId()) : badge.gym.getId() != null) {
            return false;
        }
        return true;
    }
    
      @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.cityOfOrigin != null ? this.cityOfOrigin.hashCode() : 0);
        hash = 37 * hash + Objects.hashCode(this.gym != null ? this.gym.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "BadgeDTO{" + "cityOfOrigin=" + cityOfOrigin + ", id=" + id + ", gym=" + gym + ", owners=" + owners + '}';
    }

}
