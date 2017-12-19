/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miroslav
 */
public class TournamentCreateDTO {
   
   
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
