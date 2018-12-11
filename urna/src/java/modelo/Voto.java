/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author helison
 */
@Entity
@Table(name = "voto")
@NamedQueries({
    @NamedQuery(name = "Voto.findAll", query = "SELECT v FROM Voto v")
    , @NamedQuery(name = "Voto.findByIdVoto", query = "SELECT v FROM Voto v WHERE v.idVoto = :idVoto")
    , @NamedQuery(name = "Voto.findByDataVoto", query = "SELECT v FROM Voto v WHERE v.dataVoto = :dataVoto")})
public class Voto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_voto")
    private Integer idVoto;
    @Column(name = "data_voto")
    @Temporal(TemporalType.DATE)
    private Date dataVoto;
    @JoinColumn(name = "id_chapa_voto", referencedColumnName = "id_chapa")
    @ManyToOne
    private Chapa idChapaVoto;
    @JoinColumn(name = "id_urna", referencedColumnName = "id_urna")
    @ManyToOne
    private Urna idUrna;

    public Voto() {
    }
    
    public Voto(Urna urna, Chapa idChapaVoto, Date dataVoto){
        
        this.dataVoto = dataVoto;
        this.idChapaVoto = idChapaVoto;
        this.idUrna = urna;
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

    public Date getDataVoto() {
        return dataVoto;
    }

    public void setDataVoto(Date dataVoto) {
        this.dataVoto = dataVoto;
    }

    public Chapa getIdChapaVoto() {
        return idChapaVoto;
    }

    public void setIdChapaVoto(Chapa idChapaVoto) {
        this.idChapaVoto = idChapaVoto;
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
