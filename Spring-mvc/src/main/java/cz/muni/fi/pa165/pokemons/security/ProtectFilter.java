package cz.muni.fi.pa165.pokemons.security;

import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Protects application from unauthorised access
 * @author Matus Krska
 */
@WebFilter(urlPatterns = {"/gym/*", "/trainer/*", "/badge/*"})
public class ProtectFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest r, ServletResponse s, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) r;
        HttpServletResponse response = (HttpServletResponse) s;

        TrainerDTO trainerDTO = (TrainerDTO) request.getSession().getAttribute("authenticatedUser");

        if (trainerDTO == null)
        {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void destroy()
    {

    }
}
