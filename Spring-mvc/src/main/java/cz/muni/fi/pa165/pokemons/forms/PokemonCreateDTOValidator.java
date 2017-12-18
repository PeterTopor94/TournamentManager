package cz.muni.fi.pa165.pokemons.forms;

import cz.muni.fi.pa165.pokemons.DTO.PokemonCreateDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Peter Topor
 */
public class PokemonCreateDTOValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz) {
        return PokemonCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PokemonCreateDTO pokemonCreateDTO = (PokemonCreateDTO) target;
        if (pokemonCreateDTO.getName() == null)
        {
            errors.rejectValue("name", "PokemonCreateDTOValidator.empty.name");
        }
        if (pokemonCreateDTO.getNickname() == null)
        {
            errors.rejectValue("nickame", "PokemonCreateDTOValidator.empty.nickname");
        }
        if (pokemonCreateDTO.getLevel() == null)
        {
            errors.rejectValue("level", "PokemonCreateDTOValidator.empty.level");
        }
    }
}
