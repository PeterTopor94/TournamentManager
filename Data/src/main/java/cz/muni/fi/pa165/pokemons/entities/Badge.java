/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    @NotNull
    @Column(nullable = false)
    private Gym gym;

    @ManyToMany
    private ArrayList<Trainer> owners;

    public Badge() {

    }

    public Badge(String cityOfOrigin, Gym gym, ArrayList<Trainer> owners) {
        this.cityOfOrigin = cityOfOrigin;
        this.gym = gym;
        this.owners = new ArrayList(owners);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public ArrayList<Trainer> getOwners() {
        return Collections.unmodifiableList(owners);
    }

    public void addOwner(Trainer owner) {
        owners.add(owner);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.cityOfOrigin);
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.gym);
        hash = 37 * hash + Objects.hashCode(this.owners);
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
        final Badge other = (Badge) obj;
        return true;
    }

}
