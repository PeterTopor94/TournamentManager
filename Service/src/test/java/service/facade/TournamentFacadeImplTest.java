package service.facade;

import cz.muni.fi.pa165.pokemons.DTO.TournamentCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.TournamentDTO;
import cz.muni.fi.pa165.pokemons.DTO.TrainerDTO;
import cz.muni.fi.pa165.pokemons.entities.Tournament;
import cz.muni.fi.pa165.pokemons.entities.Trainer;
import cz.muni.fi.pa165.pokemons.facade.TournamentFacade;
import cz.muni.fi.pa165.pokemons.service.BeanMappingService;
import cz.muni.fi.pa165.pokemons.service.TournamentService;
import cz.muni.fi.pa165.pokemons.service.TrainerService;
import cz.muni.fi.pa165.pokemons.service.config.ServiceConfiguration;
import cz.muni.fi.pa165.pokemons.service.facade.TournamentFacadeImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Miroslav
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class TournamentFacadeImplTest {
    
    @Mock
    private BeanMappingService mappingService;

    @Mock
    private TournamentService tournamentService;  
    
    @Mock
    private TrainerService trainerService;
    
    private Tournament tournament;
    private TournamentDTO tournamentDTO; 
    private TournamentCreateDTO tournamentCreateDTO;
    private TournamentFacade tournamentFacade;
    private TrainerDTO trainerDTO;
    private Trainer trainer;
    
    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tournamentFacade = new TournamentFacadeImpl(mappingService, tournamentService);
    }
   
    @BeforeMethod
    public void prepareTest(){
        
        tournament = new Tournament(); 
        tournament.setId(1L);
        tournament.setName("heloween");
        tournament.setNumRequiredBadges(1);
        
        tournamentDTO = new TournamentDTO(); 
        tournamentDTO.setId(1L);
        tournamentDTO.setName("heloween");
        tournamentDTO.setNumRequiredBadges(1);
        
        tournamentCreateDTO = new TournamentCreateDTO();
        tournamentCreateDTO.setName("heloween"); 
        tournamentCreateDTO.setNumRequiredBadges(1);
        
        trainer = new Trainer();
        trainer.setName("Miroslav");
        trainer.setSurname("Jonny");
        trainer.setDateOfBirth(new Date());
        
        trainerDTO = new TrainerDTO();
        trainerDTO.setName("Miroslav");
        trainerDTO.setSurname("Jonny");
        trainerDTO.setDateOfBirth(new Date());
        
        
    }
    
    @Test
    public void testCreate() {
        when(mappingService.mapTo(tournamentCreateDTO, Tournament.class)).thenReturn(tournament);      
        when(tournamentService.createTournament(tournament)).thenReturn(tournament);
        tournamentFacade.createTournament(tournamentCreateDTO);
        verify(tournamentService, times(1)).createTournament(tournament);
    }

    @Test
    public void testRemoveTournament() {
        when(tournamentService.findTournmanetById(1L)).thenReturn(tournament);
        tournamentFacade.removeTournament(1L);
        verify(tournamentService, times(1)).removeTournament(tournament);
       
    }

    @Test
    public void testSetNameOfTournament() {
       when(tournamentService.findTournmanetById(1L)).thenReturn(tournament);
        tournamentFacade.setNameOfTournament(1L, "brof");
        verify(tournamentService, times(1)).setNameOfTournament(tournament, "brof");
    }

    @Test
    public void testGetAllTournaments() {
       when(tournamentService.getAllTournaments()).thenReturn(Arrays.asList(tournament));
        when(mappingService.mapTo(any(), eq(TournamentDTO.class))).thenReturn(Arrays.asList(tournamentDTO));
        List<TournamentDTO> tournaments = tournamentFacade.getAllTournaments();
        Assert.assertEquals(tournaments.size(), 1);
       
    }

    @Test
    public void testFindAll() {
        when(tournamentService.findAllTournaments()).thenReturn(Arrays.asList(tournament));
        when(mappingService.mapTo(any(), eq(TournamentDTO.class))).thenReturn(Arrays.asList(tournamentDTO));
        List<TournamentDTO> tournaments = tournamentFacade.findAll();
        Assert.assertEquals(tournaments.size(), 1);
        
    }

    @Test
    public void testFindById() {
        when(tournamentService.findTournmanetById(1L)).thenReturn(tournament);
        when(mappingService.mapTo(tournament, TournamentDTO.class)).thenReturn(tournamentDTO);
        TournamentDTO tournament1 = tournamentFacade.findById(1L);
        Assert.assertEquals(tournamentDTO, tournament1);
        
    }

    @Test
    public void testFindByName() {
        when(tournamentService.findTournamentByName("league1")).thenReturn(tournament);
        when(mappingService.mapTo(tournament, TournamentDTO.class)).thenReturn(tournamentDTO);
        TournamentDTO tournament1 = tournamentFacade.findByName("league1");
        Assert.assertEquals(tournamentDTO, tournament1);       
    }
    
}
