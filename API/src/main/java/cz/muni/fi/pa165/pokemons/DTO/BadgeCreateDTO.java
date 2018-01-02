package cz.muni.fi.pa165.pokemons.DTO;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 *
 * @author lubos.beno
 */
public class BadgeCreateDTO {

    @NotNull
    private String cityOfOrigin;

    @NotNull
    private Long gymId;

    public String getCityOfOrigin() {
        return cityOfOrigin;
    }

    public void setCityOfOrigin(String cityOfOrigin) {
        this.cityOfOrigin = cityOfOrigin;
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
        
        final BadgeCreateDTO badge = (BadgeCreateDTO) obj;
        
        if (this.cityOfOrigin != null ? !this.cityOfOrigin.equals(badge.cityOfOrigin) : badge.cityOfOrigin != null) {
            return false;
        }
        if (this.gymId != null ? !this.gymId.equals(badge.gymId) : badge.gymId != null) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 11;
        hash = 37 * hash + Objects.hashCode(this.cityOfOrigin != null ? this.cityOfOrigin.hashCode() : 0);
        hash = 37 * hash + Objects.hashCode(this.gymId != null ? this.gymId.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "BadgeDTO{" + "cityOfOrigin=" + cityOfOrigin + ", gym=" + gymId + "}";
    }

}
