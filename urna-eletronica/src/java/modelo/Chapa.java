/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author helison
 */
@Entity
@Table(name = "chapa")
@NamedQueries({
    @NamedQuery(name = "Chapa.findAll", query = "SELECT c FROM Chapa c")
    , @NamedQuery(name = "Chapa.findByIdChapa", query = "SELECT c FROM Chapa c WHERE c.idChapa = :idChapa")
    , @NamedQuery(name = "Chapa.findByNumeroChapa", query = "SELECT c FROM Chapa c WHERE c.numeroChapa = :numeroChapa")})
public class Chapa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_chapa")
    private Integer idChapa;
    @Column(name = "numero_chapa")
    private Integer numeroChapa;
    @OneToMany(mappedBy = "idChapa")
    private List<Voto> votoList;
    @JoinColumn(name = "nome_candidato", referencedColumnName = "id_candidato")
    @ManyToOne
    private Candidato nomeCandidato;
    @JoinColumn(name = "nome_vice_candidato", referencedColumnName = "id_candidato")
    @ManyToOne
    private Candidato nomeViceCandidato;

    public Chapa() {
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

    public Candidato getNomeCandidato() {
        return nomeCandidato;
    }

    public void setNomeCandidato(Candidato nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
    }

    public Candidato getNomeViceCandidato() {
        return nomeViceCandidato;
    }

    public void setNomeViceCandidato(Candidato nomeViceCandidato) {
        this.nomeViceCandidato = nomeViceCandidato;
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
