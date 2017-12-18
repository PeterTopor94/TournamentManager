package cz.muni.fi.pa165.pokemons.forms;

import cz.muni.fi.pa165.pokemons.DTO.GymCreateDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class GymCreateDTOValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz) {
        return GymCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        GymCreateDTO gymCreateDTO = (GymCreateDTO) target;
        if (gymCreateDTO.getCityName() == null || gymCreateDTO.getCityName().isEmpty())
        {
            errors.rejectValue("cityName", "GymCreateDTOValidator.empty.cityname");
        }
    }
}
