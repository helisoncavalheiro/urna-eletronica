/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Candidato;
import modelo.Partido;

/**
 *
 * @author helison
 */
@Named(value = "candidatoMB")
@ViewScoped
public class CandidatoMB implements Serializable{

    private Candidato candidato;
    private List<Partido> partido;
    private DAO<Candidato> daoCandidato;
    
    
    public CandidatoMB() {
    }
    
    @PostConstruct
    public void inicializar(){
        candidato = new Candidato();
        daoCandidato = new DAO<>("urna-eletronicaPU");
    }
    
    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public DAO<Candidato> getDaoCandidato() {
        return daoCandidato;
    }

    public void setDaoCandidato(DAO<Candidato> daoCandidato) {
        this.daoCandidato = daoCandidato;
    }

    public List<Partido> getPartido() {
        return partido;
    }

    public void setPartido(List<Partido> partido) {
        this.partido = partido;
    }
    
    
    
    public void registrarCandidato(){
        this.daoCandidato.insert(this.candidato);
    }
    
}
