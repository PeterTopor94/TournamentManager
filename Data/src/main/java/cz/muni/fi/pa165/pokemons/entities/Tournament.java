/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Miroslav
 */
@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String name;



    @OneToMany
    private List<Trainer> trainers = new ArrayList<Trainer>();
   

    @NotNull
    @Column
    private int numRequiredBadges;

    public Tournament(){

    }

    public Tournament(String name){
        this.name = name;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 53;
        hash = 83 * hash + Objects.hashCode(this.id != null ? this.id.hashCode() : 0);      
        hash = 83 * hash + Objects.hashCode(this.name != null ? this.name.hashCode() : 0);
       
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
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        final Tournament tournament = (Tournament) obj;

        if (this.id != null ? !this.id.equals(tournament.id) : tournament.id != null) {
            return false;
        }
       
        if (this.name != null ? !this.name.equals(tournament.name) : tournament.name != null) {
            return false;
        }
       
        
        
       return true;
    }
    
    
    
    
    
    

    private boolean verifyTrainer(Trainer trainer){
    
    return (trainer.getBadges().size() >= numRequiredBadges);
    }    
    
    public void addTrainer(Trainer t){
    if (verifyTrainer(t)){
        trainers.add(t);
    }
    }
    
    public void removeTrainer(Trainer t)
    {
        trainers.remove(t);
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
