package cz.muni.fi.pa165.pokemons.sampledata;

import java.io.IOException;

/**
 * Interface to load sample data to database
 * @author Matus Krska
 */
public interface SampleDataLoadingFacade
{
    void loadData() throws IOException;
}
