package cz.muni.fi.pa165.pokemons.service;

import cz.muni.fi.pa165.pokemons.entities.Badge;
import cz.muni.fi.pa165.pokemons.dao.BadgeDao;
import cz.muni.fi.pa165.pokemons.entities.Trainer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author lubos.beno
 */
@Service
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
    public Long createBadge(Badge b) {
        return badgeDao.create(b);
    }

    @Override
    public void deleteBadge(Badge b) {
        badgeDao.remove(b);
    }

    @Override
    public void addOwner(Trainer trainer, Badge badge) {
	if (!badge.getOwners().contains(trainer)) {
			badge.addOwner(trainer);
		}    }

}
