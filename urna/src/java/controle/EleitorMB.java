/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAOeleitor;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Eleitor;

/**
 *
 * @author helison
 */
@Named(value = "eleitorMB")
@ViewScoped
public class EleitorMB implements Serializable {

    private Eleitor eleitor;
    private long titulo;
    private DAOeleitor eleitorDAO;
    private String erro;

    public EleitorMB() {
    }

    @PostConstruct
    public void init() {
        eleitor = new Eleitor();
        eleitorDAO = new DAOeleitor("urnaPU");
    }

    public long getTitulo() {
        return titulo;
    }

    public void setTitulo(long titulo) {
        this.titulo = titulo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }    

    public String liberarVoto() {
        
        
        // faz a busca pelo eleitor no banco de dados
        this.eleitor = this.eleitorDAO.get(Eleitor.class, titulo);

        
        // testa se a situação do eleitor for P
        if (this.eleitor.getSituacao().equals("P")) {
            // coloca em uma variável de erro uma 
            // mensagem dizendo que o eleitor já votou
            erro = "Eleitor já votou";
            
            // coloca essa variável na sessão
            util.Session.put("erro", this.erro);
            
            // exibe uma página de erro
            return "error";
        } 
        
        // se o eleitor não estiver presente
        else {
            
            // coloca o usuário na sessão
            util.Session.put("eleitor", this.eleitor);
            
            //se o eleitor for diferente de null
            if (this.eleitor != null) {
                
                // exibe a página de votação
                return "urna";
            } else {
                
                // se for diferente de null
                // reexibe a página de eleitor
                return "eleitor";
            }
            
        }
    }

}
