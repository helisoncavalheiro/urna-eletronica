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

/**
 *
 * @author helison
 */
public class DAO<T> {
    
    private EntityManager em;
    
    public DAO(String pu){
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
    
    public T get(Class<T> r, long id){
        return this.em.find(r, id);
    }
    
    public void insert(Object c){
        this.em.getTransaction().begin();
        this.em.persist(c);
        this.em.getTransaction().commit();
        this.em.close();
    }
    
    
    
}