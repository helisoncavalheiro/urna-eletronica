/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Chapa;
import modelo.Eleitor;

/**
 *
 * @author helison
 */
@Named(value = "eleitorMB")
@ViewScoped
public class EleitorMB implements Serializable {

    private Eleitor eleitor;
    private Chapa chapa;
    
    
    public EleitorMB() {
    }
    
    @PostConstruct
    public void init(){
        eleitor = new Eleitor();
        chapa = new Chapa();
    }

    public Eleitor getEleitor() {
        return eleitor;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }

    public Chapa getChapa() {
        return chapa;
    }

    public void setChapa(Chapa chapa) {
        this.chapa = chapa;
    }
    
    
    /*MÉTODOS*/
    
    public void votar(){
        controle.UrnaMB.registrarVoto(chapa);
    }
}
