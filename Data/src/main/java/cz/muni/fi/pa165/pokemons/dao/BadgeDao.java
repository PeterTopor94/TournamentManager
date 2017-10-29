/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.pokemons.dao;

import cz.muni.fi.pa165.pokemons.entities.Badge;
/**
 *
 * @author lubos.beno
 */
public interface BadgeDao {
    
    public void create (Badge b);
    
    
    public void remove (Badge b);
    
    public Badge findById(Long id);
    
    public void update (Badge b);
    
    
    
    
    
    
    
    
}
