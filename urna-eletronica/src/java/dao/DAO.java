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
        this.em.getTransaction().commit();
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
    
    public List<T> getAll(Class<T> c, String sql){
        Query query = this.em.createNamedQuery(sql, c);
        return query.getResultList();
    }
    
    public List<T> getByFields(Class<T> c, String sql, String... param){
        Query query = this.em.createQuery(sql, c);
        for(int x=0; x<param.length; x++)
            query.setParameter(x+1, param[x]);
        return query.getResultList();
    }
        
    public void close() {
        this.em.close();
    }

    
}
