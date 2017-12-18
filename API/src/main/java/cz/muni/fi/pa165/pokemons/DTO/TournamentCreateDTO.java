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
 * @author Miroslav
 */
public class TournamentCreateDTO {

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.trainerID);
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + this.numRequiredBadges;
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
        final TournamentCreateDTO other = (TournamentCreateDTO) obj;
        if (this.numRequiredBadges != other.numRequiredBadges) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.trainerID, other.trainerID)) {
            return false;
        }
        return true;
    }
   
   
    private Long trainerID;
    private String name;
    private int numRequiredBadges;
    
    
   public void setTrainerID(Long id){
       this.trainerID = id;
   }
   
    public Long getTrainerID()
   {
       return trainerID;
   } 

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getNumRequiredBadges()
    {
        return numRequiredBadges;
    }

    public void setNumRequiredBadges(int numRequiredBadges)
    {
        this.numRequiredBadges = numRequiredBadges;
    }
   
    
}
