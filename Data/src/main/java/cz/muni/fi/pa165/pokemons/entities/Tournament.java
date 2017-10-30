/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Miroslav
 */
@Getter
@Setter
@Entity
@Table(name = "Tournament")
public class Tournament {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
   
   
@OneToMany(mappedBy = "trainers")
private List<Trainer> memebers = new ArrayList<Trainer>();


@ManyToMany(mappedBy = "required_badges")
private static int numRequiredBadges;
    

   
    
private static boolean verifyTrainer(Trainer trainer){
    
    return (trainer.getBadges().size() >= numRequiredBadges);
}    
    
public void addTrainer(Trainer t){
    if (verifyTrainer(t)){
        memebers.add(t);
    }
}
    
 public void removeTrainer(Trainer t)
    {
        memebers.remove(t);
}    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
}
