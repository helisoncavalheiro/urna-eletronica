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
    private DAO<Chapa> chapaDAO;
    
    
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
    
    
    /*O eleitor digita o numero da chapa na view.
    Ao apertar o botão confirma, a view manda o numero da chapa
    para a instância de chapa contida neste bean gerenciado.
    O método votar é chamado.
    Neste método, um objeto do tipo chapa é recuperado do banco de dados e o objeto
    chapa já instanciado recebe esse dados recuperados do banco de dados.
    Após isso, é chamado o método registrarVoto do bean gerenciado UrnaMB,
    passando como parâmetro o objeto chapa.
    */
    public void votar(){
        this.chapa = this.chapaDAO.get(List<Chapa> res, this.chapa.getNumeroChapa());
        controle.UrnaMB.processarVoto(chapa);
    }
}
