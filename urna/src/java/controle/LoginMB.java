/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.NoResultException;
import modelo.Usuarios;

/**
 *
 * @author helison
 */
@Named(value = "loginMB")
@ViewScoped
public class LoginMB implements Serializable {

    private String login;
    private long senha;
    private Usuarios usuario;
    private DAO<Usuarios> DAOusuario;

    public LoginMB() {
    }

    @PostConstruct
    public void init() {
        this.usuario = new Usuarios();
        this.DAOusuario = new DAO<Usuarios>("urnaPU");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }

    public String autenticacao() {
        try {
            this.usuario = this.DAOusuario.getOneObject(Usuarios.class, "Usuarios.findByLoginUser", login);
            if (Long.parseLong(usuario.getPasswdUser().toString()) == this.senha) {
                return "admin/admin";
            } else {
                FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Senha incorreta"));
                return "login";
            }

        } catch (NoResultException e) {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Usuário não encontrado"));
            
        }
        
        return "login";
        

    }
}
