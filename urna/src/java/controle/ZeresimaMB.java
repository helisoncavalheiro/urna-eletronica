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
import modelo.Voto;

/**
 *
 * @author helison
 */
@Named(value = "zeresimaMB")
@ViewScoped
public class ZeresimaMB implements Serializable {

    private List<Voto> votos;
    private DAO<Voto> votoDAO;
            
    public ZeresimaMB() {
    }
    
    @PostConstruct
    public void init(){
        this.votos = new ArrayList<Voto>();
        this.votoDAO = new DAO<Voto>("urnaPU");
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }
    
    
    
    public String gerarZeresima(){
        this.votos = this.votoDAO.getAll(Voto.class, "Voto.findAll");
        return "zeresima";
    }
    
    
    
    
}
