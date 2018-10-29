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
import modelo.Partido;

/**
 *
 * @author helison
 */
@Named(value = "partidoMB")
@ViewScoped
public class PartidoMB implements Serializable {

    private Partido partido;
    private DAO<Partido> partidoDAO;
    
    public PartidoMB() {
    }
    
    @PostConstruct
    public void init(){
        partido = new Partido();
        partidoDAO = new DAO<>("urna-eletronicaPU");
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public DAO<Partido> getPartidoDAO() {
        return partidoDAO;
    }

    public void setPartidoDAO(DAO<Partido> partidoDAO) {
        this.partidoDAO = partidoDAO;
    }
    
    //Método para registrar um novo partido
    public void registrarPartido(){
        this.partidoDAO.insert(partido);
    }
    
    
    
}
