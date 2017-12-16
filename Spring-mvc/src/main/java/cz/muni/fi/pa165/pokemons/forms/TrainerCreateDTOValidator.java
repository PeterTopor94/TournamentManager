/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.forms;

import cz.muni.fi.pa165.pokemons.DTO.TrainerCreateDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Roman
 */
public class TrainerCreateDTOValidator implements Validator{
     @Override
    public boolean supports(Class<?> clazz) {
        return TrainerCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TrainerCreateDTO trainerCreateDTO = (TrainerCreateDTO) target;
        if (trainerCreateDTO.getName() == null)
            errors.rejectValue("name", "TrainerCreateDTOValidator.empty.name");
        if (trainerCreateDTO.getSurname()== null)
            errors.rejectValue("surname", "TrainerCreateDTOValidator.empty.surname");
        if (trainerCreateDTO.getDateOfBirth()== null)
            errors.rejectValue("dateOfBirth", "TrainerCreateDTOValidator.empty.dateOfBirth");
    }
}