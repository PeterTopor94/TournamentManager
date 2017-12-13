/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.service;

import java.util.List;
import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.dao.BadgeDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.inject.Inject;

/**
 *
 * @author lubos.beno
 */
@Service
@Transactional
public class BadgeServiceImpl implements BadgeService {

    @Inject
    private BadgeDao badgeDao;

    public BadgeServiceImpl(BadgeDao badgeDao) {
        this.badgeDao = badgeDao;
    }

    @Override
    public Badge findById(Long id) {
        return badgeDao.findById(id);
    }

    @Override
    public List<Badge> findAll() {
        return badgeDao.findAll();
    }

    @Override
    public void createBadge(Badge b) {
        badgeDao.create(b);
    }

    @Override
    public void deleteBadge(Badge b) {
        badgeDao.remove(b);
    }

}
