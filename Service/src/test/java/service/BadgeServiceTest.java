/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cz.muni.fi.pa165.pokemons.dao.BadgeDao;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.entities.Gym;
import cz.muni.fi.pa165.pokemons.enums.PokemonType;
import cz.muni.fi.pa165.pokemons.service.BadgeService;
import cz.muni.fi.pa165.pokemons.service.config.ServiceConfiguration;
import java.util.Arrays;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author lubos.beno
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class BadgeServiceTest {

    @Mock
    private BadgeDao badgeDao;

    @Autowired
    @InjectMocks
    private BadgeService badgeService;
    
    private Badge tBadge;
    private Gym tGym;

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void prepareTest() {

        tGym = new Gym();
        tGym.setTypology(PokemonType.POISON);
        tGym.setCityName("Opava");

        tBadge = new Badge();
        tBadge.setCityOfOrigin(tGym.getCityName());
        tBadge.setGym(tGym);

    }

    @Test
    public void create() {
        badgeService.createBadge(tBadge);
        verify(badgeDao, times(1)).create(tBadge);
    }

    @Test
    public void findAll() {
        when(badgeDao.findAll()).thenReturn(Arrays.asList(tBadge));
        List<Badge> badges = badgeService.findAll();
        Assert.assertEquals(badges.size(), 1);
    }

    @Test
    public void findById() {
        when(badgeDao.findById(8L)).thenReturn(tBadge);
        Badge badge = badgeDao.findById(8L);
        Assert.assertEquals(tBadge.getCityOfOrigin(), badge.getCityOfOrigin());
    }

    @Test
    public void delete() {
        badgeService.deleteBadge(tBadge);
        verify(badgeDao, times(1)).remove(tBadge);
    }
}