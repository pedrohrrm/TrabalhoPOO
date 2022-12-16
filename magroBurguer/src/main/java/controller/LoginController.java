package controller;

import controller.helper.LoginHelper;
import modelos.Usuario;
import view.Login;

/**
 *
 * @author pedro
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
        
    }
    
    public void entrarNoSistema(){
        //buscar user da view
        Usuario usuario = helper.gerarModelo();
        
        
        
        //pesquisar usuraio do banco
        //se o usuiari da view tiver o mesmo login e senha que o usuário vindo do banco, vou redirecionar para o menu principal.
        
        //se não for igual, mostrar uma mensagem de erro.
         
    }
    
    public void FizLogin(){
        System.out.println("Busca de dados para executar o login.");
        
        this.view.exibeMensagem("Executei o login");
    }
    
}
