/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Urna;
import modelo.Voto;

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
    private DAO<Voto> votoDAO;
    private List<Voto> votos;
    
    public ConfigMB() {
    }

    @PostConstruct
    public void init() {
        urna = new Urna();
        urnaDAO = new DAO<Urna>("urnaPU");
        votos = new ArrayList<Voto>();
        votoDAO = new DAO<Voto>("urnaPU");
    }

    public int getIdUrna() {
        return idUrna;
    }

    public void setIdUrna(int idUrna) {
        this.idUrna = idUrna;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }
    
    
    
    

    public String iniciarVotacao() {

        this.urna = this.urnaDAO.get(Urna.class, idUrna);
        util.Session.put("urna", this.urna);
        
        this.votos = this.votoDAO.getAll(Voto.class, "Voto.findAll");
        util.Session.put("votos", votos);
        
        if (this.urna != null) {
            this.votos = this.votoDAO.getAll(Voto.class, "Voto.findAll");
            return "zeresima";            
        } else {
            return "index";
        }
        
    }

    public String novoVoto() {

        util.Session.remove("eleitor");

        return "eleitor";
    }

    public String encerrarVotacao() {

        util.Session.clear();

        return "zeresima";
    }

}
