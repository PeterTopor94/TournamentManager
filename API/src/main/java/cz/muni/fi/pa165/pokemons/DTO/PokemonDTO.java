package cz.muni.fi.pa165.pokemons.DTO;

import cz.muni.fi.pa165.pokemons.enums.PokemonType;

import java.util.Objects;

/**
 *
 * @author Peter Topor
 */
public class PokemonDTO {
    

    private Long id;
    
    private Integer level;

    private String name;

    private String nickname;

    private TrainerDTO owner;

    private PokemonType typology;

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

    public TrainerDTO getOwner() {
        return owner;
    }

    public void setOwner(TrainerDTO owner) {
        this.owner = owner;
    }

    public PokemonType getType() {
        return typology;
    }

    public void setType(PokemonType type) {
        this.typology = type;
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

        final PokemonDTO pokemon = (PokemonDTO) obj;

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
        int hash = 17;
        hash = 43 * hash + Objects.hashCode(this.level != null ? this.level.hashCode() : 0);
        hash = 43 * hash + Objects.hashCode(this.name != null ? this.name.hashCode() : 0);
        hash = 43 * hash + Objects.hashCode(this.nickname != null ? this.nickname.hashCode() : 0);
        hash = 43 * hash + Objects.hashCode(this.typology != null ? this.typology.hashCode() : 0);
        return hash;
    }
    
}
