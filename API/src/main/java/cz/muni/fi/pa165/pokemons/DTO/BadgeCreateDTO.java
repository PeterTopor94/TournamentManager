/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.DTO;

import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lubos.beno
 */
public class BadgeCreateDTO {

    /**
     *
     * @author lubos.beno
     */
    @NotNull
    private String cityOfOrigin;

    @NotNull
    private Long gymId;

    //private List<TrainerDTO> owners = new ArrayList<>();

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

//    public List<TrainerDTO> getOwners() {
//        return owners;
//    }
//
//    public void setOwners(List<TrainerDTO> owners) {
//        this.owners = owners;
//    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final BadgeDTO other = (BadgeDTO) obj;
        if (!Objects.equals(this.cityOfOrigin, other.getCityOfOrigin())) {
            return false;
        }
        if (!Objects.equals(this.gymId, other.getGym())) {
            return false;
        }
//        if (!Objects.equals(this.owners, other.getOwners())) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        //return "BadgeDTO{" + "cityOfOrigin=" + cityOfOrigin + ", gymId=" + gymId + ", owners=" + owners + '}';
        return "BadgeDTO{" + "cityOfOrigin=" + cityOfOrigin + ", gym=" + gymId + "}";
    }

}
