/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.entities;

import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Peter Topor
 */
@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Integer level;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String nickname;

    @ManyToOne
    private Trainer owner;

    @NotNull
    @Column(nullable = false)
    private PokemonType type;

    public Pokemon() {
    }

    public Pokemon(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Trainer getOwner() {
        return owner;
    }

    public void setOwner(Trainer owner) {
        this.owner = owner;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 43 * hash + Objects.hashCode(this.id != null ? this.id.hashCode() : 0);
        hash = 43 * hash + Objects.hashCode(this.level != null ? this.level.hashCode() : 0);
        hash = 43 * hash + Objects.hashCode(this.name != null ? this.name.hashCode() : 0);
        hash = 43 * hash + Objects.hashCode(this.nickname != null ? this.nickname.hashCode() : 0);
        hash = 43 * hash + Objects.hashCode(this.owner != null ? this.owner.hashCode() : 0);
        hash = 43 * hash + Objects.hashCode(this.type != null ? this.type.hashCode() : 0);
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

        final Pokemon pokemon = (Pokemon) obj;

        if (this.id != null ? !this.id.equals(pokemon.id) : pokemon.id != null) {
            return false;
        }
        if (this.level != null ? !this.level.equals(pokemon.level) : pokemon.level != null) {
            return false;
        }
        if (this.name != null ? !this.name.equals(pokemon.name) : pokemon.name != null) {
            return false;
        }
        if (this.nickname != null ? !this.nickname.equals(pokemon.id) : pokemon.nickname != null) {
            return false;
        }
        if (this.owner != null ? !this.owner.equals(pokemon.owner) : pokemon.owner != null) {
            return false;
        }
        if (this.type != null ? !this.type.equals(pokemon.type) : pokemon.type != null) {
            return false;
        }

        return true;
    }

}
