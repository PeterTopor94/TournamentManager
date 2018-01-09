/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.DTO;

import java.util.Objects;

/**
 *
 * @author Miroslav
 */
public class AddTrainerToTournamentDTO {
    private Long tournametnId;
    private Long trainerId;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.tournametnId);
        hash = 19 * hash + Objects.hashCode(this.trainerId);
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
        final AddTrainerToTournamentDTO other = (AddTrainerToTournamentDTO) obj;
        if (!Objects.equals(this.tournametnId, other.tournametnId)) {
            return false;
        }
        if (!Objects.equals(this.trainerId, other.trainerId)) {
            return false;
        }
        return true;
    }

    public Long getTournamentId() {
        return tournametnId;
    }

    public void setTournamentId(Long tournametnId) {
        this.tournametnId = tournametnId;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }
    
}