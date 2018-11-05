/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author helison
 */
@Entity
@Table(name = "chapa")
@NamedQueries({
    @NamedQuery(name = "Chapa.findAll", query = "SELECT c FROM Chapa c")
    , @NamedQuery(name = "Chapa.findByIdChapa", query = "SELECT c FROM Chapa c WHERE c.idChapa = :idChapa")
    , @NamedQuery(name = "Chapa.findByNomeCandidato", query = "SELECT c FROM Chapa c WHERE c.nomeCandidato = :nomeCandidato")
    , @NamedQuery(name = "Chapa.findByNomeViceCandidato", query = "SELECT c FROM Chapa c WHERE c.nomeViceCandidato = :nomeViceCandidato")
    , @NamedQuery(name = "Chapa.findByNumeroChapa", query = "SELECT c FROM Chapa c WHERE c.numeroChapa = :numeroChapa")})
public class Chapa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_chapa")
    private Integer idChapa;
    @Size(max = 100)
    @Column(name = "nome_candidato")
    private String nomeCandidato;
    @Size(max = 100)
    @Column(name = "nome_vice_candidato")
    private String nomeViceCandidato;
    @Column(name = "numero_chapa")
    private Integer numeroChapa;
    @OneToMany(mappedBy = "idChapa")
    private List<Voto> votoList;
    
    public Chapa(){
    }
    public Chapa(Integer idChapa) {
        this.idChapa = idChapa;
    }

    public Integer getIdChapa() {
        return idChapa;
    }

    public void setIdChapa(Integer idChapa) {
        this.idChapa = idChapa;
    }

    public String getNomeCandidato() {
        return nomeCandidato;
    }

    public void setNomeCandidato(String nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
    }

    public String getNomeViceCandidato() {
        return nomeViceCandidato;
    }

    public void setNomeViceCandidato(String nomeViceCandidato) {
        this.nomeViceCandidato = nomeViceCandidato;
    }

    public Integer getNumeroChapa() {
        return numeroChapa;
    }

    public void setNumeroChapa(Integer numeroChapa) {
        this.numeroChapa = numeroChapa;
    }

    public List<Voto> getVotoList() {
        return votoList;
    }

    public void setVotoList(List<Voto> votoList) {
        this.votoList = votoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChapa != null ? idChapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chapa)) {
            return false;
        }
        Chapa other = (Chapa) object;
        if ((this.idChapa == null && other.idChapa != null) || (this.idChapa != null && !this.idChapa.equals(other.idChapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Chapa[ idChapa=" + idChapa + " ]";
    }
}
