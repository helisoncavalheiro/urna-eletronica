/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import dao.DAO;
import dao.DAOchapa;
import dao.DAOeleitor;
import dao.DAOvoto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.Chapa;
import modelo.Eleitor;
import modelo.Urna;
import modelo.Voto;

/**
 *
 * @author helison
 */
@Named(value = "votoMB")
@SessionScoped
public class VotoMB implements Serializable {

    private int idUrna;
    private int numChapa;
    private int cursor = 0;
    private Urna urna;    
    private Eleitor eleitor;
    private Chapa chapa;
    private Voto voto;
    private List<Voto> votos;
    private DAO<Urna> urnaDAO;
    private DAOvoto votoDAO;
    private DAOchapa chapaDAO;
    private DAOeleitor eleitorDAO;

    public VotoMB() {
    }

    @PostConstruct
    public void init(){
        
        urna = new Urna();
        chapa = new Chapa();
        eleitor = new Eleitor();
        voto = new Voto();
        votos = new ArrayList<Voto>();        
        chapaDAO = new DAOchapa("urnaPU");
        urnaDAO = new DAO<Urna>("urnaPU");
        votoDAO = new DAOvoto("urnaPU");
        eleitorDAO = new DAOeleitor("urnaPU");
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
    
    
    
    
    
    

    public String iniciarVotacao() {

        this.urna = this.urnaDAO.get(Urna.class, this.idUrna); // provisório
        if (this.urna != null) {
            this.votos = this.votoDAO.getCandidatos(Voto.class, "Voto.findAll");
            return "relatorio";
            //return "eleitor";
        } else {
            return "config_urna";
        }

    }

    public String novoVoto() {

        util.Session.remove("eleitor");
        return "eleitor";
    }

    public String processarVoto() {
        
        //Voto voto2;
        
        
        // este teste foi adicionado pois o voto nunca mudava, então foi necessário limpar a memória e inicilizar novamente
        //if(this.cursor != 0)
        //voto2 = new Voto();
        
        // recupera a chapa de acordo com o numero digitado pelo eleitor
        this.chapa = this.chapaDAO.getByField("Chapa.findByNumeroChapa", this.numChapa).get(0); 
        //recupera o eleitor da sessão
        this.eleitor = (Eleitor) util.Session.get("eleitor");
        // recupera a urna do banco de dados, de acordo com a urna digitada no início da sessão
        //this.urna = urnaDAO.get(Urna.class, idUrna); removido por duplicidade. Já está no método iniciar votação
        this.eleitor.setSituacao("P"); // seta a situação do eleitor como presente
        this.eleitorDAO.update(this.eleitor);//o código para aqui com um exception java.NullPointerException
        /*
        voto2.setIdChapaVoto(this.chapa); // seta a chapa votada
        voto2.setIdUrna(this.urna); // seta a urna do voto
        voto2.setDataVoto(new Date()); // seta a data do voto
        voto = voto2;
        //this.votoDAO.saveList(voto);
        */
        this.votos.add(new Voto(this.urna, this.chapa, new Date())); // adiciona o voto à lista de votos da sessão
        //this.voto = null; // limpa a variável voto
        this.numChapa = 0; // limpa o campo da chapa
        this.cursor ++; // representa o número de vezes que entrou nesse método
        
        return "final"; // redireciona para a pagina de finalização do voto
    }
       
    // limpa os objetos da sessão
    public String encerrarVotacao(){
        this.votoDAO.saveList(this.votos); // salva a lista de votos
        this.votos.clear(); // limpa a lista de votos da memória
        //this.urna = null; // limpa a urna
        this.chapa = null;
        this.voto = null;
        this.eleitor = null;
        util.Session.clear(); // limpa os objetos na sessão
        return "encerrar";
    }
    /*
    public int listarVotos(){
        int c = this.votos.size();
        int sum;
        while(c > 0){
            if 
        }
               
    }
    */
    
    

}
