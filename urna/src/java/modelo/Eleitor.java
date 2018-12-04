/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author helison
 */
@Entity
@Table(name = "eleitor")
@NamedQueries({
    @NamedQuery(name = "Eleitor.findAll", query = "SELECT e FROM Eleitor e")
    , @NamedQuery(name = "Eleitor.findByTituloEleitoral", query = "SELECT e FROM Eleitor e WHERE e.tituloEleitoral = :tituloEleitoral")
    , @NamedQuery(name = "Eleitor.findByNome", query = "SELECT e FROM Eleitor e WHERE e.nome = :nome")
    , @NamedQuery(name = "Eleitor.findByCpf", query = "SELECT e FROM Eleitor e WHERE e.cpf = :cpf")
    , @NamedQuery(name = "Eleitor.findByUf", query = "SELECT e FROM Eleitor e WHERE e.uf = :uf")
    , @NamedQuery(name = "Eleitor.findBySituacao", query = "SELECT e FROM Eleitor e WHERE e.situacao = :situacao")})
public class Eleitor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "titulo_eleitoral")
    private Long tituloEleitoral;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private BigInteger cpf;
    @Size(max = 5)
    @Column(name = "uf")
    private String uf;
    @Size(max = 10)
    @Column(name = "situacao")
    private String situacao;
    @JoinColumn(name = "id_urna", referencedColumnName = "id_urna")
    @ManyToOne
    private Urna idUrna;

    public Eleitor() {
    }

    public Eleitor(Long tituloEleitoral) {
        this.tituloEleitoral = tituloEleitoral;
    }

    public Long getTituloEleitoral() {
        return tituloEleitoral;
    }

    public void setTituloEleitoral(Long tituloEleitoral) {
        this.tituloEleitoral = tituloEleitoral;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigInteger getCpf() {
        return cpf;
    }

    public void setCpf(BigInteger cpf) {
        this.cpf = cpf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Urna getIdUrna() {
        return idUrna;
    }

    public void setIdUrna(Urna idUrna) {
        this.idUrna = idUrna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tituloEleitoral != null ? tituloEleitoral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleitor)) {
            return false;
        }
        Eleitor other = (Eleitor) object;
        if ((this.tituloEleitoral == null && other.tituloEleitoral != null) || (this.tituloEleitoral != null && !this.tituloEleitoral.equals(other.tituloEleitoral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Eleitor[ tituloEleitoral=" + tituloEleitoral + " ]";
    }
    
}
