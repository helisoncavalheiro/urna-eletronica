/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;

/**
 *
 * @author helison
 */
@Entity
@Table(name = "candidato")
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c")
    , @NamedQuery(name = "Candidato.findByIdCandidato", query = "SELECT c FROM Candidato c WHERE c.idCandidato = :idCandidato")
    , @NamedQuery(name = "Candidato.findByNome", query = "SELECT c FROM Candidato c WHERE c.nome = :nome")
    , @NamedQuery(name = "Candidato.findByNumeroCandidato", query = "SELECT c FROM Candidato c WHERE c.numeroCandidato = :numeroCandidato")
    , @NamedQuery(name = "Candidato.findByUfCandidato", query = "SELECT c FROM Candidato c WHERE c.ufCandidato = :ufCandidato")
    , @NamedQuery(name = "Candidato.findByTipoCandidato", query = "SELECT c FROM Candidato c WHERE c.tipoCandidato = :tipoCandidato")})
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_candidato")
    private Integer idCandidato;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Column(name = "numero_candidato")
    private BigInteger numeroCandidato;
    @Size(max = 10)
    @Column(name = "uf_candidato")
    private String ufCandidato;
    @Size(max = 50)
    @Column(name = "tipo_candidato")
    private String tipoCandidato;
    @JoinColumn(name = "partido_candidato", referencedColumnName = "numero_partido")
    @ManyToOne
    private Partido partidoCandidato;
    @OneToMany(mappedBy = "nomeCandidato")
    private List<Chapa> chapaList;
    @OneToMany(mappedBy = "nomeViceCandidato")
    private List<Chapa> chapaList1;

    public Candidato() {
    }

    public Candidato(Integer idCandidato) {
        this.idCandidato = idCandidato;
    }

    public Integer getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(Integer idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigInteger getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(BigInteger numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public String getUfCandidato() {
        return ufCandidato;
    }

    public void setUfCandidato(String ufCandidato) {
        this.ufCandidato = ufCandidato;
    }

    public String getTipoCandidato() {
        return tipoCandidato;
    }

    public void setTipoCandidato(String tipoCandidato) {
        this.tipoCandidato = tipoCandidato;
    }

    public Partido getPartidoCandidato() {
        return partidoCandidato;
    }

    public void setPartidoCandidato(Partido partidoCandidato) {
        this.partidoCandidato = partidoCandidato;
    }

    public List<Chapa> getChapaList() {
        return chapaList;
    }

    public void setChapaList(List<Chapa> chapaList) {
        this.chapaList = chapaList;
    }

    public List<Chapa> getChapaList1() {
        return chapaList1;
    }

    public void setChapaList1(List<Chapa> chapaList1) {
        this.chapaList1 = chapaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCandidato != null ? idCandidato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.idCandidato == null && other.idCandidato != null) || (this.idCandidato != null && !this.idCandidato.equals(other.idCandidato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Candidato[ idCandidato=" + idCandidato + " ]";
    }
    
}
