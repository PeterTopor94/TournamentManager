package cz.muni.fi.pa165.pokemons.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Miroslav
 */
public class TournamentDTO {
    
    private Long id;
    private String tournamentName;
    private int numRequiredBadges;
    
    @JsonBackReference
    private List<TrainerDTO> trainers = new ArrayList<>();
    
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
    
    public List<TrainerDTO> getTrainers() {
        return trainers;
    }
    
    public void setNumRequiredBadges(int numRequiredBadges)
    {
        this.numRequiredBadges = numRequiredBadges;
    }
   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        final TournamentDTO tournament = (TournamentDTO) obj;
       
        if (this.tournamentName != null ? !this.tournamentName.equals(tournament.tournamentName) : tournament.tournamentName != null) {
            return false;
        }
     
        return true;
    } 
    
    @Override
    public int hashCode() {
        int hash = 53;    
        hash = 83 * hash + Objects.hashCode(this.tournamentName != null ? this.tournamentName.hashCode() : 0);     
        return hash;
    }
}
