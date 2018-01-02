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
public class TournamentDTO {
    
    private Long id;
    private String tournamentName;
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
        return tournamentName;
    }

    public void setName(String name)
    {
        this.tournamentName = name;
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
