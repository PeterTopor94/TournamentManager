package cz.muni.fi.pa165.pokemons.DTO;

import java.util.Objects;

/**
 * @author Matus Krska
 */
public class AuthenticateTrainerDTO
{
    private String login;
    private String password;

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final AuthenticateTrainerDTO trainer = (AuthenticateTrainerDTO) obj;
        
        if (this.login != null ? !this.login.equals(trainer.login) : trainer.login != null) {
            return false;
        }
        return true;
    }
        
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.login != null ? this.login.hashCode() : 0);
        return hash;
    }
}
