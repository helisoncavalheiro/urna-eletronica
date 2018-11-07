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
import modelo.Eleitor;

/**
 *
 * @author helison
 */
@Named(value = "eleitorMB")
@ViewScoped
public class EleitorMB implements Serializable {
    
    private Eleitor eleitor;
    
    public EleitorMB() {
    }
    
    @PostConstruct
    public void init(){
        eleitor = new Eleitor();
    }

    public Eleitor getEleitor() {
        return eleitor;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }
    
}
