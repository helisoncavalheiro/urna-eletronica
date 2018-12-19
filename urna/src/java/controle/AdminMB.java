/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Urna;
import modelo.Usuario;

/**
 *
 * @author helison
 */
@Named(value = "adminMB")
@SessionScoped
public class AdminMB implements Serializable {

    private Usuario usuarioLogado;
    private Usuario novoUsuario;
    private String loginUser;
    private BigInteger senhaUser;
    private String tipoUser;
    private Urna urnaUser;
    private DAO<Usuario> userDAO;
    private DAO<Urna> urnaDAO;
    private List<Urna> urnas;

    public AdminMB() {
    }

    @PostConstruct
    public void init() {
        usuarioLogado = new Usuario();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession sessaoHttp = (HttpSession) facesContext.getExternalContext().getSession(true);
        usuarioLogado = (Usuario) sessaoHttp.getAttribute("usuarioLogado");

        novoUsuario = new Usuario();
        urnaUser = new Urna();
        userDAO = new DAO<Usuario>("urnaPU");
        urnaDAO = new DAO<Urna>("urnaPU");
        urnas = new ArrayList<Urna>();

    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;
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
    

    public void cadastrar() {
        this.novoUsuario.setLoginUser(loginUser);
        this.novoUsuario.setPasswdUser(senhaUser);
        this.novoUsuario.setTipoUser(tipoUser);
        this.urnaUser = this.urnaDAO.get(Urna.class, 1);
        this.novoUsuario.setUrnaUser(urnaUser);
        this.userDAO.insert(novoUsuario);
    }

    public String logout() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession sessaoHttp = (HttpSession) facesContext.getExternalContext().getSession(true);
        sessaoHttp.removeAttribute("usuarioLogado");

        facesContext.addMessage("", new FacesMessage("Você fez logout!"));
        return "/login";
    }

}
