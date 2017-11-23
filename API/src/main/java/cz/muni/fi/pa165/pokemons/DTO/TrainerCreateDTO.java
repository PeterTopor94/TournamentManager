/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Roman Gluszny
 */
public class TrainerCreateDTO {

     @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Size(min = 3, max = 50)
    private String surname;

    private List<Long> badgeIDs = new ArrayList<>();

    private List<Long> pokemonIDs = new ArrayList<>();

    @NotNull
    private Date dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Long> getBadgeIDs() {
        return badgeIDs;
    }

    public void setBadgeIDs(List<Long> badgeIDs) {
        this.badgeIDs = badgeIDs;
    }

    public List<Long> getPokemonIDs() {
        return pokemonIDs;
    }

    public void setPokemonIDs(List<Long> pokemonIDs) {
        this.pokemonIDs = pokemonIDs;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getGymId() {
        return gymId;
    }

    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }

    private Long gymId;
}
