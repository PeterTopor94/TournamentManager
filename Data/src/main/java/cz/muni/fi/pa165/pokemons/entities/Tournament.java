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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void addTrainer(Trainer trainer) {
        this.trainers.add(trainer);
    }
    
    public void removeTrainer(Trainer trainer) {
        this.trainers.remove(trainer);
    }

    public void setName(String name) {
        this.name = name;
    }
    
     public String getName() {
        return name;
    }

    public int getNumRequiredBadges() {
        return numRequiredBadges;
    }

    public void setNumRequiredBadges(int numRequiredBadges) {
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

        final Tournament tournament = (Tournament) obj;
       
        if (this.name != null ? !this.name.equals(tournament.name) : tournament.name != null) {
            return false;
        }
     
        return true;
    } 
    
    @Override
    public int hashCode() {
        int hash = 53;    
        hash = 83 * hash + Objects.hashCode(this.name != null ? this.name.hashCode() : 0);     
        return hash;
    }
}
