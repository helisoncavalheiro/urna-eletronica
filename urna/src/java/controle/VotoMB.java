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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
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

    private Integer idUrna;
    private Integer numChapa;
    private Urna urna;
    private Eleitor eleitor;
    private Chapa chapa;
    //private Voto voto; // variável que não está sendo usada mais
    private List<Voto> votos;
    private DAO<Urna> urnaDAO;
    private DAOvoto votoDAO;
    private DAOchapa chapaDAO;
    private DAOeleitor eleitorDAO;

    public VotoMB() {
    }

    @PostConstruct
    public void init() {

        urna = new Urna();
        chapa = new Chapa();
        eleitor = new Eleitor();
        votos = new ArrayList<Voto>();
        chapaDAO = new DAOchapa("urnaPU");
        urnaDAO = new DAO<Urna>("urnaPU");
        votoDAO = new DAOvoto("urnaPU");
        eleitorDAO = new DAOeleitor("urnaPU");
    }

    public Integer getIdUrna() {
        return idUrna;
    }

    public void setIdUrna(Integer idUrna) {
        this.idUrna = idUrna;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    public Integer getNumChapa() {
        return numChapa;
    }

    public void setNumChapa(Integer numChapa) {
        this.numChapa = numChapa;
    }

    public Urna getUrna() {
        return urna;
    }

    public void setUrna(Urna urna) {
        this.urna = urna;
    }

    public String iniciarVotacao() {

        //busca no banco de dados a urna corrrespondente à urna digitada
        //pelo usuário
        this.urna = this.urnaDAO.get(Urna.class, this.idUrna);

        // se a urna for diferente de null
        if (this.urna != null) {

            // recupera os votos do banco de dados, com o intuito de
            // provar que não há votos previamente registrados
            //este código está incorreto, poi sempre recupera os votos já registrados
            //e coloca na váriavel, fazendo o número de votos crescer
            //exponencialmente
            //this.votos = this.votoDAO.getCandidatos(Voto.class, "Voto.findAll");
            // redireciona para a página de relatórios de voto
            return "relatorio";

        } else {

            // se a urna não existir, reexibe a página de configuração da urna
            return "config_urna";

        }

    }

    public String processarVoto() {

        /*
        //busca no banco de dados a urna corrrespondente à urna digitada
        //pelo usuário
        this.urna = this.urnaDAO.get(Urna.class, this.idUrna);
         */
        // recupera a chapa de acordo com o numero digitado pelo eleitor
        this.chapa = this.chapaDAO.getByField("Chapa.findByNumeroChapa", this.numChapa).get(0);

        //recupera o eleitor da sessão
        this.eleitor = (Eleitor) util.Session.get("eleitor");

        // seta a situação do eleitor como presente
        this.eleitor.setSituacao("P");

        //registra a presença do eleitor
        this.eleitorDAO.update(this.eleitor);

        // adiciona um novo voto na lista de votos
        // para isso é criada uma variável fantasma
        // essa variável é instanciada a cada vez
        // que essa linha é executada
        this.votos.add(new Voto(this.urna, this.chapa, new Date())); // adiciona o voto à lista de votos da sessão

        // limpa o campo da chapa
        this.numChapa = 0;

        // redireciona para a pagina de finalização do voto
        return "final";
    }

    public String novoVoto() {

        // remove o eleitor atual da sessão
        // a variável eleitor passa a ser nula
        util.Session.remove("eleitor");

        //exibe a página do eleitor
        return "eleitor";
    }

    public String encerrarVotacao() {
        // salva no banco de dados a lista de votos
        this.votoDAO.saveList(this.votos);

        // limpa a lista de votos da memória
        this.votos.clear();

        // limpa da memória a variável chapa
        this.chapa = null;

        // limpa da memória a variável eleitor
        this.eleitor = null;

        // limpa os objetos na sessão
        util.Session.clear();

        // exibe a página de encerramento da votação
        return "encerrar";
    }

    public String logout() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession sessaoHttp = (HttpSession) facesContext.getExternalContext().getSession(true);
        sessaoHttp.removeAttribute("usuarioLogado");

        facesContext.addMessage("", new FacesMessage("Você fez logout!"));
        return "/login";
    }

}
