package cz.muni.fi.pa165.pokemons.DTO;

import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 *
 * @author Peter Topor
 */
public class PokemonCreateDTO {

    @NotNull
    @Min(1)
    private Integer level;

    @NotNull
    private String name;

    @NotNull
    private String nickname;
    
    private Long ownerId;

    @NotNull
    private PokemonType typology;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public PokemonType getPokemonType() {
        return typology;
    }

    public void setPokemonType(PokemonType typology) {
        this.typology = typology;
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

        final PokemonCreateDTO pokemon = (PokemonCreateDTO) obj;

       
        if (this.level != null ? !this.level.equals(pokemon.level) : pokemon.level != null) {
            return false;
        }
        if (this.name != null ? !this.name.equals(pokemon.name) : pokemon.name != null) {
            return false;
        }
        if (this.nickname != null ? !this.nickname.equals(pokemon.nickname) : pokemon.nickname != null) {
            return false;
        }
        if (this.typology != null ? this.typology.equals(pokemon.typology) : pokemon.typology == null) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 13;
        hash = 43 * hash + Objects.hashCode(this.level != null ? this.level.hashCode() : 0);
        hash = 43 * hash + Objects.hashCode(this.name != null ? this.name.hashCode() : 0);
        hash = 43 * hash + Objects.hashCode(this.nickname != null ? this.nickname.hashCode() : 0);
        hash = 43 * hash + Objects.hashCode(this.typology != null ? this.typology.hashCode() : 0);
        return hash;
    }
    
}
