package cz.muni.fi.pa165.pokemons.sampledata;

import cz.muni.fi.pa165.pokemons.sampledata.SampleDataLoadingFacadeImpl;
import cz.muni.fi.pa165.pokemons.service.config.ServiceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;

/**
 * Configuration for sampledata module
 */
@Configuration
@Import(ServiceConfiguration.class)
@ComponentScan(basePackageClasses = {SampleDataLoadingFacadeImpl.class})
public class SampleDataConfiguration
{
    @Inject
    SampleDataLoadingFacade sampleDataLoadingFacade;

    @PostConstruct
    public void dataLoading() throws IOException
    {
        sampleDataLoadingFacade.loadData();
    }
}
