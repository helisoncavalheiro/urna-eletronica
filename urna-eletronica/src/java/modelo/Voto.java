/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author helison
 */
@Entity
@Table(name = "voto")
@NamedQueries({
    @NamedQuery(name = "Voto.findAll", query = "SELECT v FROM Voto v")
    , @NamedQuery(name = "Voto.findByIdVoto", query = "SELECT v FROM Voto v WHERE v.idVoto = :idVoto")})
public class Voto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_voto")
    private Integer idVoto;
    @JoinColumn(name = "id_chapa", referencedColumnName = "id_chapa")
    @ManyToOne
    private Chapa idChapa;
    @JoinColumn(name = "id_urna", referencedColumnName = "id_urna")
    @ManyToOne
    private Urna idUrna;

    public Voto() {
    }

    public Voto(Integer idVoto) {
        this.idVoto = idVoto;
    }

    public Integer getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(Integer idVoto) {
        this.idVoto = idVoto;
    }

    public Chapa getIdChapa() {
        return idChapa;
    }

    public void setIdChapa(Chapa idChapa) {
        this.idChapa = idChapa;
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
        hash += (idVoto != null ? idVoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voto)) {
            return false;
        }
        Voto other = (Voto) object;
        if ((this.idVoto == null && other.idVoto != null) || (this.idVoto != null && !this.idVoto.equals(other.idVoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Voto[ idVoto=" + idVoto + " ]";
    }
    
}
