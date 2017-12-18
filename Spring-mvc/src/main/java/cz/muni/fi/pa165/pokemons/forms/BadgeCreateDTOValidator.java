/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.forms;

import cz.muni.fi.pa165.pokemons.DTO.BadgeCreateDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author lubos.beno
 */
public class BadgeCreateDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BadgeCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BadgeCreateDTO badgeCreateDTO = (BadgeCreateDTO) target;

        if (badgeCreateDTO.getCityOfOrigin() == null) {
            errors.rejectValue("cityOfOrigin", "BadgeCreateDTOValidator.empty.cityOfOrigin");
        }
        if (badgeCreateDTO.getGym() == null) {
            errors.rejectValue("gym", "BadgeCreateDTOValidator.empty.gym");
        }
    }
}
