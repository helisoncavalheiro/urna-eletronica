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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author helison
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUser", query = "SELECT u FROM Usuario u WHERE u.idUser = :idUser")
    , @NamedQuery(name = "Usuario.findByLoginUser", query = "SELECT u FROM Usuario u WHERE u.loginUser = :loginUser")
    , @NamedQuery(name = "Usuario.findByPasswdUser", query = "SELECT u FROM Usuario u WHERE u.passwdUser = :passwdUser")
    , @NamedQuery(name = "Usuario.findByTipoUser", query = "SELECT u FROM Usuario u WHERE u.tipoUser = :tipoUser")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    @Size(max = 16)
    @Column(name = "login_user")
    private String loginUser;
    @Column(name = "passwd_user")
    private BigInteger passwdUser;
    @Size(max = 50)
    @Column(name = "tipo_user")
    private String tipoUser;
    @JoinColumn(name = "urna_user", referencedColumnName = "id_urna")
    @ManyToOne
    private Urna urnaUser;

    public Usuario() {
    }

    public Usuario(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public BigInteger getPasswdUser() {
        return passwdUser;
    }

    public void setPasswdUser(BigInteger passwdUser) {
        this.passwdUser = passwdUser;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public Urna getUrnaUser() {
        return urnaUser;
    }

    public void setUrnaUser(Urna urnaUser) {
        this.urnaUser = urnaUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ idUser=" + idUser + " ]";
    }
    
}
