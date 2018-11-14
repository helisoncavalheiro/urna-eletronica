package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author helison
 */
public class DAOvoto {
    
    private EntityManager em;
    
    public void DAOvoto(String pu){
        this.em = Persistence.createEntityManagerFactory(pu).createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }   
    
}