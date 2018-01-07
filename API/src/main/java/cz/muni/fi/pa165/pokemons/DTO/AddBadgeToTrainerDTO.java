/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.DTO;

import java.util.Objects;

/**
 *
 * @author Roman Gluszny
 */
public class AddBadgeToTrainerDTO {
    private Long trainerId;
    private Long badgeId;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.trainerId);
        hash = 19 * hash + Objects.hashCode(this.badgeId);
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
        final AddBadgeToTrainerDTO other = (AddBadgeToTrainerDTO) obj;
        if (!Objects.equals(this.trainerId, other.trainerId)) {
            return false;
        }
        if (!Objects.equals(this.badgeId, other.badgeId)) {
            return false;
        }
        return true;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public Long getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(Long badgeId) {
        this.badgeId = badgeId;
    }
    
}
