package cz.muni.fi.pa165.pokemons.DTO;

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
}
