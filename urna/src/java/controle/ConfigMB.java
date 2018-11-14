/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Urna;

/**
 *
 * @author helison
 */
@Named(value = "configMB")
@ViewScoped
public class ConfigMB implements Serializable {

    private Urna urna;
    private int idUrna;
    private DAO<Urna> urnaDAO;

    public ConfigMB() {
    }

    @PostConstruct
    public void init() {
        urna = new Urna();
        urnaDAO = new DAO<Urna>("urnaPU");
    }

    public int getIdUrna() {
        return idUrna;
    }

    public void setIdUrna(int idUrna) {
        this.idUrna = idUrna;
    }
    
    
    

    public String iniciarVotacao() {

        this.urna = this.urnaDAO.get(Urna.class, idUrna);
        util.Session.put("urna", this.urna);

        if (this.urna != null) {
            return "eleitor";
        }
        else{
            return "index";
        }

    }

}
