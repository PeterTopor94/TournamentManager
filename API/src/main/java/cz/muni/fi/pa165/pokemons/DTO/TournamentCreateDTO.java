package cz.muni.fi.pa165.pokemons.DTO;

import java.util.Objects;

/**
 *
 * @author Miroslav
 */
public class TournamentCreateDTO {
   
   
    private Long trainerID;
    private String tournamentName;
    private int numRequiredBadges;
    
    private Long trainerId;
    
   public void setTrainerID(Long id){
       this.trainerID = id;
   }
   
    public Long getTrainerID()
   {
       return trainerID;
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
   
    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
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

        final TournamentCreateDTO tournament = (TournamentCreateDTO) obj;
       
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
