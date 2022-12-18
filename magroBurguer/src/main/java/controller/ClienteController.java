/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Cliente;

/**
 *
 * @author joaop
 */
public class ClienteController {
    
    public void CadastraCliente() throws IOException {
        String nome;
        String endereco;
        String celular = "";
        
        Scanner dados = new Scanner(System.in);
        System.out.printf("Informe o nome: ");
        nome = dados.nextLine();
        
        System.out.printf("Informe o endereço: ");
        endereco = dados.nextLine();
        
        System.out.printf("Informe o celular: ");
        celular = dados.nextLine();
        
        if (!ValidaCliente(nome, endereco)) {
            System.out.println("Dados do cliente inválidos");
            return;
        }   
        
        GravaDadosCliente(nome, endereco, celular);  
    }
    
    public void AlteraCliente() {
        String id;
        String nome = "";
        String endereco = "";
        String celular = "";
        
        Scanner dados = new Scanner(System.in);
        
        System.out.printf("Informe o Id do cliente que deseja alterar: ");
        id = dados.nextLine();        
        
        System.out.printf("Informe o nome: ");
        nome = dados.nextLine();
        
        System.out.printf("Informe o endereço: ");
        endereco = dados.nextLine();
        
        System.out.printf("Informe o celular: ");
        celular = dados.nextLine();
        
        if ((!"".equals(nome)) && (!"".equals(endereco)) && (!"".equals(celular))) {
            if (!ValidaCliente(nome, endereco, celular)) {
                return;
            }
        } else if ((!"".equals(nome)) && (!"".equals(endereco)))  {
            if (!ValidaCliente(nome, endereco)) {
                return;
            } 
        } else {
            if (!ValidaCliente(nome)) {
                return;
            } 
        }
        
        Cliente[] lista = retornaListaClientes();
        
        List<Cliente> clientes = new ArrayList<>();
        
        
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].getId() == Integer.parseInt(id)) {
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
    
    public Boolean ValidaCliente(String nome) {
        return !(("".equals(nome)));
    }
    
    public Boolean ValidaCliente(String nome, String endereco) {
        return !(("".equals(nome)) || ("".equals(endereco)));      
    }
    
    public Boolean ValidaCliente(String nome, String endereco, String celular) {
        return !(("".equals(nome)) || ("".equals(endereco)) || ("".equals(celular)));      
    }

    private void GravaDadosCliente(String nome, String endereco, String celular) throws IOException {
        Cliente cliente = new Cliente(nome, endereco, celular);
        List<Cliente> clientes = new ArrayList<>();
       
        Cliente[] lista = retornaListaClientes();
        
        //Adiciona os clientes ja existente no arquivo
        for (Cliente lista1 : lista) {
           clientes.add(lista1);
        }
        
        //Adiciona o novo cliente no arquivo
        clientes.add(cliente);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = gson.toJson(clientes);

        try ( 
            //Escreve Json convertido em arquivo chamado "cliente.json"
            FileWriter writer = new FileWriter("cliente.json")) {
            writer.write(json);
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
}
