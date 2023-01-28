/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.Scanner;
import model.Cliente;

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
        
        Cliente cliente = new Cliente(nome, endereco, celular);
        
        cliente.GravaDadosCliente();  
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
        
        Cliente cliente = new Cliente(Integer.parseInt(id), nome, endereco, celular);
        
        cliente.AlteraCliente();
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

    
    
    
}
