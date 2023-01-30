
package model;

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
    
    public Pessoa(int id, String nome, String endereco, String celular) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.celular = celular;
    }
    
    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, String endereco) {
        GeraId();
        this.nome = nome;
        this.endereco = endereco;
        
    }

    public Pessoa(String nome, String endereco, String celular) {
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
    
    abstract void GeraId(); 
 
}
