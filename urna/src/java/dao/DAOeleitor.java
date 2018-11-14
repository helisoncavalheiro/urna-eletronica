/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modelo.Eleitor;

/**
 *
 * @author helison
 */
public class DAOeleitor {
        private EntityManager em;
    
    public DAOeleitor(String pu){
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
    
    public Eleitor get(Class<Eleitor> r, long id){
        return this.em.find(r, id);
    }
    
    public void update(Eleitor eleitor){
        this.em.getTransaction().begin();
        this.em.merge(eleitor);
        this.em.getTransaction().commit();
        this.em.close();
    }
    
    public List<Eleitor> getByField(String sql, int value) {
        Query query = this.em.createNamedQuery(sql, Eleitor.class);
        query.setParameter("numeroChapa", value);
        return query.getResultList();
    }
    
    
}

