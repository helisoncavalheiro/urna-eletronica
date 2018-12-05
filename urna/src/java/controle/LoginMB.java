/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author helison
 */
@Named(value = "loginMB")
@ViewScoped
public class LoginMB {
    
    
    private String login;
    private long senha;

    public LoginMB() {
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
    
    
    
    
    
    
    
    
}
