
package controller.helper;

import modelos.Usuario;
import view.Login;

/**
 *
 * @author pedro
 */
public class LoginHelper {
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    public Usuario gerarModelo(){
        String nome = view.getTextUsuario().getText();
        String senha = view.getTextSenha().getText();
        Usuario padrao = new Usuario(0, nome, senha);
        return padrao;

    }
    public void setarModelo(Usuario padrao){
        String nome = padrao.getNome();
        String senha = padrao.getSenha();
        
        view.getTextUsuario().setText(nome);
        view.getTextSenha().setText(senha);
    }
    public void limpezaDeTela(){
        view.getTextUsuario().setText("");
        view.getTextSenha().setText("");
    }
    
}
