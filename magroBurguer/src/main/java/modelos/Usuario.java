package modelos;

/**
 *
 * @author pedro
 */
public class Usuario extends Pessoa {
    protected String CPF;
    protected String nivelAcesso;
    protected String senha;

   
    
    
    
    public Usuario(int id, String nome, String senha) {
        super(id, nome);
        this.senha = senha;
    }

    public Usuario(int id, String nome, String nivelAcesso, String senha) {
        super(id, nome);
        this.nivelAcesso = nivelAcesso;
        this.senha = senha;
    }

    public Usuario(String CPF, String nivelAcesso, String senha, int id, String nome, String endereco, String celular) {
        super(id, nome, endereco, celular);
        this.CPF = CPF;
        this.nivelAcesso = nivelAcesso;
        this.senha = senha;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
 
