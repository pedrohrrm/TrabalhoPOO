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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    public void CancelaPedido() {    
        int id;
        
        Scanner dados = new Scanner(System.in);
        
        System.out.printf("Informe o Id do pedido que deseja cancelar: ");
        id = dados.nextInt();  

        AlteraStatusPedido(id, 3); 
    }
   
    private void GravaDadosPedido(String idCliente, String idProduto, String idVendedor, float valor) {
        String dataHora = GeraDataHora();
        
        Pedido pedido = new Pedido(Integer.parseInt(idCliente), 
                Integer.parseInt(idProduto), Integer.parseInt(idVendedor), valor, dataHora);
        
        List<Pedido> pedidos = new ArrayList<>();
        
        Pedido[] lista = RetornaListaPedidos();
        
        if (lista != null) {
            //Adiciona os clientes ja existente no arquivo
            for (Pedido lista1 : lista) {
               pedidos.add(lista1);
            }
        } 

        //Adiciona o novo cliente no arquivo
        pedidos.add(pedido);
        
        EscreveArquivo(pedidos);   
    }
    
    private String GeraDataHora() {
        Date date = new Date(); 
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
        String strDate = dateFormat.format(date);  
        
        return strDate;
    }

    public Pedido[] RetornaListaPedidos() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        BufferedReader json;
        try {
            json = new BufferedReader(new FileReader("pedido.json"));
        } catch (FileNotFoundException ex) {
            return null;
        }
            
        Pedido[] lista = gson.fromJson(json, Pedido[].class);

        return lista;
    }
    
    public void ImprimeDadosPedido() {
        int idPedido;
                
        Scanner dados = new Scanner(System.in);
        
        System.out.printf("Informe o Id do pedido que deseja imprimir: ");
        idPedido = dados.nextInt();
        
        Pedido[] lista = RetornaListaPedidos();
        
        for (Pedido lista1 : lista) {
           if (lista1.getId() == idPedido) {
               Pedido pedido = new Pedido(lista1);
               System.out.println(pedido.toString());
           }
        }
    }
    
    public void AlteraStatusPedido(int idPedido, int novoStatus) {
        List<Pedido> pedidos = new ArrayList<>();
        Pedido[] lista = RetornaListaPedidos();
      
        for (Pedido lista1 : lista) {
           if (lista1.getId() != idPedido) {              
               pedidos.add(lista1);
           } else {
               lista1.setStatus(novoStatus);
               pedidos.add(lista1);
           }
        }
        
        EscreveArquivo(pedidos);
    }
    
    public void EscreveArquivo(List<Pedido> pedidos) {
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
    
}
