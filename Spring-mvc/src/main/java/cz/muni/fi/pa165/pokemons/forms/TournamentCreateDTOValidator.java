/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.forms;
import cz.muni.fi.pa165.pokemons.DTO.TournamentCreateDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
/**
 *
 * @author Miroslav
 */
public class TournamentCreateDTOValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return TournamentCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TournamentCreateDTO tournamentCreateDTO = (TournamentCreateDTO) target;
       

        if (tournamentCreateDTO.getName().isEmpty()) {
            errors.rejectValue("tournamentName", "TournamentCreateDTOValidator.empty.tournamentName");
        }
      
    }
}
