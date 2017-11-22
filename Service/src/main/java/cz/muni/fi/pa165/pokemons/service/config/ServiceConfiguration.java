package cz.muni.fi.pa165.pokemons.service.config;

import cz.muni.fi.pa165.pokemons.DataApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataApplicationContext.class)
@ComponentScan(basePackages={"cz.muni.fi.pa165.pokemons"})
public class ServiceConfiguration
{
    //TODO dozer
}
