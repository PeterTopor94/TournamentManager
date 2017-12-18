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
public class TournamentDTO {

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + this.numRequiredBadges;
        hash = 89 * hash + Objects.hashCode(this.trainers);
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
        final TournamentDTO other = (TournamentDTO) obj;
        if (this.numRequiredBadges != other.numRequiredBadges) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.trainers, other.trainers)) {
            return false;
        }
        return true;
    }
    
    private Long id;
    private String name;
    private int numRequiredBadges;
    private List<TrainerDTO> trainers = new ArrayList<TrainerDTO>();
    
   public Long getId()
   {
       return id;
   } 
    
   public void setId(Long id){
       this.id = id;
   }
   
    private boolean verifyTrainer(TrainerDTO trainer){
    
    return (trainer.getBadges().size() >= numRequiredBadges);
}    
    
    public void addTrainer(TrainerDTO t){
    if (verifyTrainer(t)){
        trainers.add(t);
    }
}
    
    public void removeTrainer(TrainerDTO t)
    {
        trainers.remove(t);
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
