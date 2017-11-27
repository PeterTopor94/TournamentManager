package cz.muni.fi.pa165.pokemons.service.config;

import cz.muni.fi.pa165.pokemons.DTO.GymDTO;
import cz.muni.fi.pa165.pokemons.DataApplicationContext;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataApplicationContext.class)
@ComponentScan(basePackages={"cz.muni.fi.pa165.pokemons"})
public class ServiceConfiguration
{
    @Bean
    public Mapper dozer() {
        DozerBeanMapper dozer = new DozerBeanMapper();
        dozer.addMapping(new DozerCustomConfig());
        return dozer;
    }

    /**
     * Custom config for Dozer
     */
    public class DozerCustomConfig extends BeanMappingBuilder
    {
        @Override
        protected void configure() {
            mapping(Gym.class, GymDTO.class);
        }
    }
}
