/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.facade;

import cz.muni.fi.pa165.pokemons.DTO.BadgeCreateDTO;
import cz.muni.fi.pa165.pokemons.DTO.BadgeDTO;
import cz.muni.fi.pa165.pokemons.DTO.GymDTO;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.facade.BadgeFacade;
import cz.muni.fi.pa165.pokemons.service.BadgeService;
import cz.muni.fi.pa165.pokemons.service.BeanMappingService;
import cz.muni.fi.pa165.pokemons.service.config.ServiceConfiguration;
import java.util.Arrays;
import java.util.List;
import org.hibernate.service.spi.ServiceException;

/**
 *
 * @author lubos.beno
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class BadgeFacadeTest {

    @Mock
    private BeanMappingService mappingService;

    @Mock
    private BadgeService badgeService;

    @InjectMocks
    private BadgeFacade badgeFacade;

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    private GymDTO gymDTO;
    private Gym gym;
    private BadgeDTO badgeDTO;
    private Badge badge;
    private BadgeCreateDTO badgeCreateDTO;

    @BeforeMethod
    public void prepareBadges() {
        gym = new Gym();
        gym.setTypology(PokemonType.POISON);
        gym.setCityName("Bratislava");

        gymDTO = new GymDTO();
        gymDTO.setTypology(PokemonType.POISON);
        gymDTO.setCityName("Bratislava");

        badge = new Badge();
        badge.setCityOfOrigin("Opava");
        badge.setGym(gym);

        badgeDTO = new BadgeDTO();
        badgeDTO.setCityOfOrigin("Opava");
        badgeDTO.setGym(gymDTO);

        badgeCreateDTO = new BadgeCreateDTO();
        badgeCreateDTO.setCityOfOrigin("Opava");
        badgeCreateDTO.setGym(gymDTO);

    }

    @Test
    public void create() {
        when(mappingService.mapTo(badgeCreateDTO, Badge.class)).thenReturn(badge);

        badgeFacade.createBadge(badgeDTO);
        verify(badgeService, times(1)).createBadge(badge);
    }

    @Test
    public void getAll() {
        when(badgeService.findAll()).thenReturn(Arrays.asList(badge));
        when(mappingService.mapTo(any(), eq(BadgeDTO.class))).thenReturn(Arrays.asList(badgeDTO));
        List<BadgeDTO> badges = badgeFacade.getAllBadges();
        Assert.assertEquals(badges.size(), 1);
    }

    @Test
    public void remove() {
        when(badgeService.findById(8L)).thenReturn(badge);
        badgeDTO.setId(8L);
        badgeFacade.removeBadge(badgeDTO);
        verify(badgeService, times(1)).removeBadge(badge);
    }

}
