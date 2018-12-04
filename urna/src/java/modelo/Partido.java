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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author helison
 */
@Entity
@Table(name = "partido")
@NamedQueries({
    @NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p")
    , @NamedQuery(name = "Partido.findByNumeroPartido", query = "SELECT p FROM Partido p WHERE p.numeroPartido = :numeroPartido")
    , @NamedQuery(name = "Partido.findByNomePartido", query = "SELECT p FROM Partido p WHERE p.nomePartido = :nomePartido")
    , @NamedQuery(name = "Partido.findByLegendaPartido", query = "SELECT p FROM Partido p WHERE p.legendaPartido = :legendaPartido")})
public class Partido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_partido")
    private Integer numeroPartido;
    @Size(max = 50)
    @Column(name = "nome_partido")
    private String nomePartido;
    @Size(max = 10)
    @Column(name = "legenda_partido")
    private String legendaPartido;
    @OneToMany(mappedBy = "partidoCandidato")
    private List<Candidato> candidatoList;

    public Partido() {
    }

    public Partido(Integer numeroPartido) {
        this.numeroPartido = numeroPartido;
    }

    public Integer getNumeroPartido() {
        return numeroPartido;
    }

    public void setNumeroPartido(Integer numeroPartido) {
        this.numeroPartido = numeroPartido;
    }

    public String getNomePartido() {
        return nomePartido;
    }

    public void setNomePartido(String nomePartido) {
        this.nomePartido = nomePartido;
    }

    public String getLegendaPartido() {
        return legendaPartido;
    }

    public void setLegendaPartido(String legendaPartido) {
        this.legendaPartido = legendaPartido;
    }

    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }

    public void setCandidatoList(List<Candidato> candidatoList) {
        this.candidatoList = candidatoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroPartido != null ? numeroPartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partido)) {
            return false;
        }
        Partido other = (Partido) object;
        if ((this.numeroPartido == null && other.numeroPartido != null) || (this.numeroPartido != null && !this.numeroPartido.equals(other.numeroPartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Partido[ numeroPartido=" + numeroPartido + " ]";
    }
    
}
