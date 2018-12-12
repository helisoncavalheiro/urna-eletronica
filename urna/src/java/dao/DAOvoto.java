package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modelo.Voto;

/**
 *
 * @author helison
 */
public class DAOvoto {

    private EntityManager em;

    public DAOvoto(String pu) {

        this.em = Persistence.createEntityManagerFactory(pu).createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Voto> getCandidatos(Class<Voto> c, String sql) {
        /*
        String sql = "";
        
        Query query = this.em.createQuery(sql, c);
         */

        Query query = this.em.createNamedQuery(sql, c);
        return query.getResultList();
    }

    public void saveList(List<Voto> votos) {

        int c = votos.size();

        while (c > 0) {
            this.em.getTransaction().begin();
            this.em.persist(votos.get(c - 1));
            votos.remove(c - 1);
            this.em.getTransaction().commit();
            this.em.clear();
            c--;
        }

    }

}
