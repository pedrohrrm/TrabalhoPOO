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
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Pedido;

/**
 *
 * @author joaop
 */
public class PedidoController {
    
    public void EfetuaPedido() {
        String idCliente;
        String idProduto;
        String idVendedor;
        float valor;
        
        Scanner dados = new Scanner(System.in);
        
        System.out.printf("Informe o Id do cliente: ");
        idCliente = dados.nextLine();
        
        System.out.printf("Informe o Id do produto: ");
        idProduto = dados.nextLine();
        
        System.out.printf("Informe o Id do vendedor: ");
        idVendedor = dados.nextLine();
        
        System.out.printf("Informe o valor do pedido: ");
        valor = dados.nextFloat();
        
        GravaDadosPedido(idCliente, idProduto, idVendedor, valor);
    }
    
    public void ExcluiPedido() {    
        String id;
        
        Scanner dados = new Scanner(System.in);
        
        System.out.printf("Informe o Id do pedido que deseja excluir: ");
        id = dados.nextLine();  

        List<Pedido> pedidos = new ArrayList<>();
        Pedido[] lista = retornaListaPedidos();
        
        for (int i = 0; i < lista.length; i++) {
            if (!(lista[i].getId() == Integer.parseInt(id))) {         
                pedidos.add(lista[i]);
            } 
        }
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = gson.toJson(pedidos);

        try ( 
            //Escreve Json convertido em arquivo chamado "pedido.json"
            FileWriter writer = new FileWriter("pedido.json")) {
            writer.write(json);
        } catch (IOException ex) {
            Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    

    private void GravaDadosPedido(String idCliente, String idProduto, String idVendedor, float valor) {
        Calendar dataHora = GeraDataHora();
        
        Pedido pedido = new Pedido(Integer.parseInt(idCliente), 
                Integer.parseInt(idProduto), Integer.parseInt(idVendedor), valor, dataHora);
        
        List<Pedido> pedidos = new ArrayList<>();
        
        Pedido[] lista = retornaListaPedidos();
        
        //Adiciona os clientes ja existente no arquivo
        for (Pedido lista1 : lista) {
           pedidos.add(lista1);
        }
        
        //Adiciona o novo cliente no arquivo
        pedidos.add(pedido);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = gson.toJson(pedidos);
        
       //Escreve Json convertido em arquivo chamado "cliente.json"

        try ( 
            //Escreve Json convertido em arquivo chamado "pedido.json"
            FileWriter writer = new FileWriter("pedido.json")) {
            writer.write(json);
        } catch (IOException ex) {
            Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    private Calendar GeraDataHora() {
        Calendar dataHora = Calendar.getInstance();
        
        return dataHora;
    }

    public Pedido[] retornaListaPedidos() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        BufferedReader json = null;
        try {
            json = new BufferedReader(new FileReader("pedido.json"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        Pedido[] lista = gson.fromJson(json, Pedido[].class);

        return lista;
    }
}
