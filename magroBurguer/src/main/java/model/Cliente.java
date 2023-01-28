
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.ClienteController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public final class Cliente extends Pessoa {
    
    public Cliente (int id, String nome, String endereco, String celular) {
        super(id, nome, endereco, celular);
    }
    
    public Cliente(String nome) throws IOException {
        super(nome);
    }

    public Cliente(String nome, String endereco) throws IOException {
        super(nome, endereco);
    }
    
    public Cliente(String nome, String endereco, String celular) throws IOException {
        super(nome, endereco, celular);
    } 
    
    public void GravaDadosCliente() throws IOException { 
        List<Cliente> clientes = new ArrayList<>();
       
        Cliente[] lista = retornaListaClientes();
        
        //Adiciona os clientes ja existente no arquivo
        for (Cliente lista1 : lista) {
           clientes.add(lista1);
        }
        
        //Adiciona o novo cliente no arquivo
        clientes.add(this);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = gson.toJson(clientes);

        try ( 
            //Escreve Json convertido em arquivo chamado "cliente.json"
            FileWriter writer = new FileWriter("cliente.json")) {
            writer.write(json);
        }
    }
    
    public void AlteraCliente() {        
        Cliente[] lista = retornaListaClientes();
        
        List<Cliente> clientes = new ArrayList<>();
        
        
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].getId() == this.id) {
                if (!"".equals(nome)) {
                    lista[i].setNome(nome);
                }
                
                if (!"".equals(endereco)) {
                    lista[i].setEndereco(endereco);
                }
                
                if (!"".equals(celular)) {
                    lista[i].setCelular(celular);
                }
         
                clientes.add(lista[i]);
            } else {
                clientes.add(lista[i]);
            }
        }
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = gson.toJson(clientes);

        try ( 
            //Escreve Json convertido em arquivo chamado "cliente.json"
            FileWriter writer = new FileWriter("cliente.json")) {
            writer.write(json);
        } catch (IOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public Cliente[] retornaListaClientes() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        BufferedReader json = null;
        try {
            json = new BufferedReader(new FileReader("cliente.json"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        Cliente[] lista = gson.fromJson(json, Cliente[].class);

        return lista;
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

    @Override
    void GeraId() {
        Cliente[] lista = retornaListaClientes();
        
        if (lista != null) {
            this.id = lista.length + 1;
        } else {
            this.id = 1;
        } 
    }


}
