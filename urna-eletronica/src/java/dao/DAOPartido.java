/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import modelo.Partido;

/**
 *
 * @author helison
 */
public class DAOPartido<T> {
    
    private EntityManager em;
    
    public DAOPartido(String pu){
        if (this.em == null)
            this.em = Persistence.createEntityManagerFactory(pu).createEntityManager();
    }   
    
    
}
