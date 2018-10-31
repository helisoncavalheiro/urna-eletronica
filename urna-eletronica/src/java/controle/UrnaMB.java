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
import modelo.Urna;

/**
 *
 * @author helison
 */
@Named(value = "urnaMB")
@ViewScoped
public class UrnaMB implements Serializable{

    private Urna urna;
    private DAO<Chapa> chapaDAO;
    private Voto voto;
    public UrnaMB() {
    }
    
    @PostConstruct
    public void init(){
        urna = new Urna();
    }
    
    /*
    O método processar voto tem como intuito prepar os votos para serem
    registrados no banco de dados. Ele recebe como parâmetro um objeto do tipo chapa
    e usa a atual instância da urna.
    Estes objetos são passados como parâmetro para um método de VotoMB, que irá
    registrar no banco de dados o voto.
    */
    public void processarVoto(Chapa chapa){
        votoMB.setChapa(chapa);
        votoMB.setUrna(this.urna);
        votoMB.registrarVoto(voto);
    }
    
    
    
}
