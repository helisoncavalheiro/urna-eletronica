/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author helison
 */

@WebFilter(filterName = "FiltroLogin", urlPatterns = {"/votacao/*", "/admin/*"})
public class FiltroLogin implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        
    }
    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpSession sessao = ((HttpServletRequest) request).getSession();
        Usuario usr = (Usuario) sessao.getAttribute("usuarioLogado");
        
        if(usr == null){
            ((HttpServletResponse) response).sendRedirect("../faces/login.xhtml");
        }
        else
            chain.doFilter(request, response);
            
    }
    
    @Override
    public void destroy(){
        
    }
    
    
    
}
