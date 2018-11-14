/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modelo.Chapa;

/**
 *
 * @author helison
 */
public class DAOchapa {
    
    private EntityManager em;
    
    public DAOchapa(String pu){
        if(this.em == null){
            this.em = Persistence.createEntityManagerFactory(pu).createEntityManager();
        }
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public Chapa get(int r){
        return this.em.find(Chapa.class, r);
    }
    
    public List<Chapa> getByField(String sql, int value) {
        Query query = this.em.createNamedQuery(sql, Chapa.class);
        query.setParameter("numeroChapa", value);
        return query.getResultList();
    }
    
    
}