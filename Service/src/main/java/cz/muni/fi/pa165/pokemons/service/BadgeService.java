/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.service;

import cz.muni.fi.pa165.pokemons.entities.Badge;
import java.util.List;
/**
 *
 * @author lubos.beno
 */
public interface BadgeService {

    public Badge findById(Long id);

    public List<Badge> findAll();

    public Long createBadge(Badge b);

    public void deleteBadge(Badge b);

}
