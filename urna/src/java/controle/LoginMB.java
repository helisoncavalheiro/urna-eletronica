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
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author helison
 */
@Named(value = "loginMB")
@RequestScoped
public class LoginMB implements Serializable {

    private String login;
    private Long senha;
    private Usuario usuario;
    private DAO<Usuario> DAOusuario;

    public LoginMB() {
    }

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.DAOusuario = new DAO<Usuario>("urnaPU");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getSenha() {
        return senha;
    }

    public void setSenha(Long senha) {
        this.senha = senha;
    }

    public String autenticacao() {
        //tenta executar as ações
        try {

            // busca no banco de dados o usuário
            // se não encontrar, a execução do código para aqui
            // se parar, significa que o usuário não existe
            this.usuario = this.DAOusuario.getOneObject(Usuario.class, "Usuario.findByLoginUser", login);

            // testa se a senha digitada na view for igual a senha registrada no banco
            if (Long.parseLong(usuario.getPasswdUser().toString()) == this.senha) {

                //se o usuário for do tip SU
                if ("SU".equals(usuario.getTipoUser())){ // redireciona para a página de administração
                
                    
                    // coloca o usuário na sessão
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    HttpSession sessaoHttp = (HttpSession) facesContext.getExternalContext().getSession(true);
                    sessaoHttp.setAttribute("usuarioLogado", usuario);
                    
                    
                    //retorna a página de administração
                    return "admin/admin";
                    
                    
                } 
                
                else{ // se for de outro tipo, redireciona para a página de votação
                    
                    // coloca o usuário na sessão
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    HttpSession sessaoHttp = (HttpSession) facesContext.getExternalContext().getSession(true);
                    sessaoHttp.setAttribute("usuarioLogado", usuario);
                    
                    // retorna a página de configuração da urna
                    return "votacao/config_urna";
                }

            } 

            // se as senhas diferirem, exibe uma mensagem de senha incorreta
            else {
                FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Senha incorreta"));
                return "login";
            }

        } catch (NoResultException e) { // caso não consiga
            //exibe uma mensagem dizendo que o usuário não existe
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Usuário não encontrado"));

        }

        // se nada funcionar, reexibe a página de login
        return "login";
    }
}
