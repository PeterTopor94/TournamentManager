package cz.muni.fi.pa165.pokemons.DTO;

import cz.muni.fi.pa165.pokemons.enums.PokemonType;

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

    private PokemonType pokemonType;

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
        return pokemonType;
    }

    public void setType(PokemonType type) {
        this.pokemonType = type;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 37 * hash + this.level.hashCode();
        hash = 37 * hash + this.name.hashCode();
        hash = 37 * hash + this.nickname.hashCode();
        hash = 37 * hash + this.pokemonType.hashCode();
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
        return this.pokemonType != null ? this.pokemonType.equals(pokemon.pokemonType) : pokemon.pokemonType == null;
    }

    
}
