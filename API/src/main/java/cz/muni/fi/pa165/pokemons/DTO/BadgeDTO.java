/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.DTO;

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
        if (!Objects.equals(this.cityOfOrigin, other.cityOfOrigin)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.gym, other.gym)) {
            return false;
        }
        if (!Objects.equals(this.owners, other.owners)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BadgeDTO{" + "cityOfOrigin=" + cityOfOrigin + ", id=" + id + ", gym=" + gym + ", owners=" + owners + '}';
    }

}
