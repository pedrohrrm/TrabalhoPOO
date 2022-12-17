
package modelos;

import java.io.IOException;

/**
 *
 * @author pedro
 */
public final class Cliente extends Pessoa {
    
    public Cliente () {}
    
    public Cliente(String nome) throws IOException {
        super(nome);
    }

    public Cliente(String nome, String endereco) throws IOException {
        super(nome, endereco);
    }
    
    public Cliente(String nome, String endereco, String celular) throws IOException {
        super(nome, endereco, celular);
    }    
    
    @Override
    public String toString() {
        if (!"".equals(this.celular)) {
            return ("Nome: " + this.nome
                + "\nEndereço: " + this.endereco
                + "\nCelular: " + this.celular); 
        } else {
            return ("Cliente gerado.\nNome: " + this.nome
                + "\nEndereço: " + this.endereco);
        }
    }


}
