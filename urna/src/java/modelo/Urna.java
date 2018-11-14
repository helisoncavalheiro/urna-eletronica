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
@Table(name = "urna")
@NamedQueries({
    @NamedQuery(name = "Urna.findAll", query = "SELECT u FROM Urna u")
    , @NamedQuery(name = "Urna.findByIdUrna", query = "SELECT u FROM Urna u WHERE u.idUrna = :idUrna")
    , @NamedQuery(name = "Urna.findBySecao", query = "SELECT u FROM Urna u WHERE u.secao = :secao")
    , @NamedQuery(name = "Urna.findByZona", query = "SELECT u FROM Urna u WHERE u.zona = :zona")
    , @NamedQuery(name = "Urna.findByPresidenteSecao", query = "SELECT u FROM Urna u WHERE u.presidenteSecao = :presidenteSecao")})
public class Urna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_urna")
    private Integer idUrna;
    @Column(name = "secao")
    private Integer secao;
    @Column(name = "zona")
    private Integer zona;
    @Size(max = 80)
    @Column(name = "presidente_secao")
    private String presidenteSecao;
    @OneToMany(mappedBy = "idUrna")
    private List<Voto> votoList;
    @OneToMany(mappedBy = "idUrna")
    private List<Eleitor> eleitorList;

    public Urna() {
    }

    public Urna(Integer idUrna) {
        this.idUrna = idUrna;
    }

    public Integer getIdUrna() {
        return idUrna;
    }

    public void setIdUrna(Integer idUrna) {
        this.idUrna = idUrna;
    }

    public Integer getSecao() {
        return secao;
    }

    public void setSecao(Integer secao) {
        this.secao = secao;
    }

    public Integer getZona() {
        return zona;
    }

    public void setZona(Integer zona) {
        this.zona = zona;
    }

    public String getPresidenteSecao() {
        return presidenteSecao;
    }

    public void setPresidenteSecao(String presidenteSecao) {
        this.presidenteSecao = presidenteSecao;
    }

    public List<Voto> getVotoList() {
        return votoList;
    }

    public void setVotoList(List<Voto> votoList) {
        this.votoList = votoList;
    }

    public List<Eleitor> getEleitorList() {
        return eleitorList;
    }

    public void setEleitorList(List<Eleitor> eleitorList) {
        this.eleitorList = eleitorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUrna != null ? idUrna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Urna)) {
            return false;
        }
        Urna other = (Urna) object;
        if ((this.idUrna == null && other.idUrna != null) || (this.idUrna != null && !this.idUrna.equals(other.idUrna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Urna[ idUrna=" + idUrna + " ]";
    }
    
}
