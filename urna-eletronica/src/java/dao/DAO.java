/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
    
    public void insert(T object){
        this.em.getTransaction().begin();
        this.em.persist(object);
        this.em.close();
    }
   
        public void update(T object) {
        this.em.getTransaction().begin();
        this.em.merge(object);
        this.em.getTransaction().commit();
    }

    public void delete(T object) {
        this.em.getTransaction().begin();
        this.em.remove(object);
        this.em.getTransaction().commit();
    }
    
    public T get(Class<T> c, long id) {
        return this.em.find(c, id);
    }
    
}
