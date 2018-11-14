/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAO;
import dao.DAOchapa;
import dao.DAOeleitor;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Chapa;
import modelo.Eleitor;
import modelo.Urna;
import modelo.Voto;

/**
 *
 * @author helison
 */
@Named(value = "urnaMB")
@ViewScoped
public class UrnaMB implements Serializable{

    private Urna urna;
    private int idUrna;
    private long titulo;
    private Eleitor eleitor;
    private DAOchapa chapaDAO;
    private DAO<Voto> votoDAO;
    private DAO<Urna> urnaDAO;
    private DAOeleitor eleitorDAO;
    private Voto voto;
    private Chapa chapa;
    private int numChapa;
    
    public UrnaMB() {
        
    }

    public int getNumChapa() {
        return numChapa;
    }

    public void setNumChapa(int numChapa) {
        this.numChapa = numChapa;
    }

    public Urna getUrna() {
        return urna;
    }

    public void setUrna(Urna urna) {
        this.urna = urna;
    }

    public Eleitor getEleitor() {
        return eleitor;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }

    public int getIdUrna() {
        return idUrna;
    }

    public void setIdUrna(int idUrna) {
        this.idUrna = idUrna;
    }

    public long getTitulo() {
        return titulo;
    }

    public void setTitulo(long titulo) {
        this.titulo = titulo;
    }
    
    
    
    
    
   
    @PostConstruct
    public void init() {
        urna = new Urna();
        voto = new Voto();
        chapa = new Chapa();
        eleitor = new Eleitor();
        chapaDAO = new DAOchapa("urnaPU");
        votoDAO = new DAO<Voto>("urnaPU");
        eleitorDAO = new DAOeleitor("urnaPU");
    }
    
    /*
    O método processar voto tem como intuito prepar os votos para serem
    registrados no banco de dados. Ele recebe como parâmetro um objeto do tipo chapa
    e usa a atual instância da urna.
    Estes objetos são passados como parâmetro para um método de VotoMB, que irá
    registrar no banco de dados o voto.
    */
    public String processarVoto(){
        
        this.chapa = this.chapaDAO.getByField("Chapa.findByNumeroChapa", this.numChapa).get(0);
        
        this.eleitor = (Eleitor) util.Session.get("eleitor");
        this.urna = (Urna) util.Session.get("urna");
        
        this.eleitor.setSituacao("P");
        this.eleitorDAO.update(this.eleitor);
        this.voto.setIdChapa(this.chapa);
        this.voto.setIdUrna(this.urna);
        this.votoDAO.insert(this.voto);
        return "final";
    }
    
    
    
    
}
