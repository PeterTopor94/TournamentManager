/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne 
    @NotNull
    private Gym gym;

    @ManyToMany
    private List<Trainer> owners;

    public Badge() {

    }

    public Badge(String cityOfOrigin, Gym gym, ArrayList<Trainer> owners) {
        this.cityOfOrigin = cityOfOrigin;
        this.gym = gym;
        this.owners = new ArrayList(owners);
    }

    /**
     * Returns city of origin
     * @return City of origin
     */
    public String getCityOfOrigin() {
        return this.cityOfOrigin;
    }

    /**
     * Set city of origin
     * @param cityOfOrigin 
     */
    public void setCityOfOrigin(String cityOfOrigin) {
        this.cityOfOrigin = cityOfOrigin;
    }

    /**
     * Returns gym
     * @return Gym
     */
    public Gym getGym() {
        return this.gym;
    }

    /**
     * Returns Id of the Badge
     * @return 
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Set Id of the badge
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set Gym of the badge
     * @param gym 
     */
    public void setGym(Gym gym) {
        this.gym = gym;
    }

    /**
     * Returns list of owners of the badge
     * @return List<Trainer> 
     */
    public List<Trainer> getOwners() {
        return Collections.unmodifiableList(owners);
    }

    /**
     * Add trainer to owners list
     * @param owner 
     */
    public void addOwner(Trainer owner) {
        this.owners.add(owner);
    }

    /**
     * Generates hashCode
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.cityOfOrigin);
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.gym);
        hash = 37 * hash + Objects.hashCode(this.owners);
        return hash;
    }

    /**
     * Method equals
     * @param obj
     * @return boolean value
     */
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
        final Badge other = (Badge) obj;
        return true;
    }

}
