/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.entities;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lubos.beno
 */
@Entity
public class Badge {
    @NotNull
    @Column(nullable = false)
    private String cityOfOrigin;
    
    @Id
    @GeneratedValue
    private Long id;
    
    @NotNull
    @Column(nullable = false)
    private Gym gym;

    private ArrayList<Trainer> owners;

    public Badge(String cityOfOrigin, Gym gym, ArrayList<Trainer> owners) {
        this.cityOfOrigin = cityOfOrigin;
        this.gym = gym;
        this.owners = owners;
    }

    public String getCityOfOrigin() {
        return cityOfOrigin;
    }

    public void setCityOfOrigin(String cityOfOrigin) {
        this.cityOfOrigin = cityOfOrigin;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public ArrayList<Trainer> getOwners() {
        return owners;
    }

    public void addOwner(Trainer owner) {
        owners.add(owner);
    }
}
