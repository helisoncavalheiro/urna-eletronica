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
import modelo.Chapa;
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
    private DAO<Chapa> chapaDAO;
    private DAO<Voto> votoDAO;
    private Voto voto;
    private Chapa chapa;
    public UrnaMB() {
    }
    
    @PostConstruct
    public void init(){
        urna = new Urna();
        voto = new Voto();
        chapa = new Chapa();
        chapaDAO = new DAO<Chapa>("eleicaoPU");
        votoDAO = new DAO<Voto>("eleicaoPU");
    }
    
    /*
    O método processar voto tem como intuito prepar os votos para serem
    registrados no banco de dados. Ele recebe como parâmetro um objeto do tipo chapa
    e usa a atual instância da urna.
    Estes objetos são passados como parâmetro para um método de VotoMB, que irá
    registrar no banco de dados o voto.
    */
    public void processarVoto(int numChapa){
        this.chapa = this.chapaDAO.get(Chapa.class, numChapa);
        this.voto.setIdChapa(this.chapa);
        this.voto.setIdUrna(this.urna);
        this.votoDAO.insert(this.voto);
    }
    
    
    
    
}
