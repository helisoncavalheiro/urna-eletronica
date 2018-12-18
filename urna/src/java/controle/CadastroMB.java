/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAO;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import modelo.Urna;
import modelo.Usuario;

/**
 *
 * @author helison
 */
@Named(value = "cadastroMB")
@ViewScoped
public class CadastroMB implements Serializable {

    private Usuario usuario;
    private String loginUser;
    private BigInteger senhaUser;
    private String tipoUser;
    private Urna urnaUser;
    private DAO<Usuario> userDAO;
    private DAO<Urna> urnaDAO;
    private List<Urna> urnas;

    public CadastroMB() {
    }

    @PostConstruct
    public void init(){
        usuario = new Usuario();
        urnaUser = new Urna();
        userDAO = new DAO<Usuario>("urnaPU");
        urnaDAO = new DAO<Urna>("urnaPU");
        urnas = new ArrayList<Urna>();        
        
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public BigInteger getSenhaUser() {
        return senhaUser;
    }

    public void setSenhaUser(BigInteger senhaUser) {
        this.senhaUser = senhaUser;
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

    public List<Urna> getUrnas() {
        return urnas;
    }

    public void setUrnas(List<Urna> urnas) {
        this.urnas = urnas;
    }
        
    public void cadastrar(){
        this.usuario.setLoginUser(loginUser);
        this.usuario.setPasswdUser(senhaUser);
        this.usuario.setTipoUser(tipoUser);
        this.urnaUser = this.urnaDAO.get(Urna.class, 1);
        this.usuario.setUrnaUser(urnaUser);        
        this.userDAO.insert(usuario);        
    }
    
}
