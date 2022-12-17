
package modelos;

import controller.ClienteController;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author pedro
 */
abstract public class Pessoa {
    protected int id;
    protected String nome;
    protected String endereco;
    protected String celular;
    
    public Pessoa() {}
    
    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, String endereco) throws IOException {
        GeraId();
        this.nome = nome;
        this.endereco = endereco;
        
    }

    public Pessoa(String nome, String endereco, String celular) throws IOException {
        GeraId();
        this.nome = nome;
        this.endereco = endereco;
        this.celular = celular;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    /**
     * 
     * Gera Id para pessoa
     * 
     */
    private void GeraId() throws FileNotFoundException {  
        ClienteController clienteController = new ClienteController();
        Cliente[] lista = clienteController.retornaListaClientes();
        
        if (lista != null) {
            this.id = lista.length + 1;
        } else {
            this.id = 1;
        }
        
      
    } 
}
