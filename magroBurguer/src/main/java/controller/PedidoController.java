/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import model.Pedido;
import static model.Pedido.RetornaListaPedidos;

/**
 *
 * @author joaop
 */
public class PedidoController {
    
    /**
     *
     */
    public void EfetuaPedido() {
        int idCliente;
        int idProduto;
        int idVendedor;
        float valor;
        
        Scanner dados = new Scanner(System.in);
        
        System.out.printf("Informe o Id do cliente: ");
        idCliente = Integer.parseInt(dados.nextLine());
        
        System.out.printf("Informe o Id do produto: ");
        idProduto = Integer.parseInt(dados.nextLine());
        
        System.out.printf("Informe o Id do vendedor: ");
        idVendedor = Integer.parseInt(dados.nextLine());
        
        System.out.printf("Informe o valor do pedido: ");
        valor = dados.nextFloat();
        
        Pedido pedido = new Pedido(idCliente, idProduto, idVendedor, valor);
        
        pedido.GravaDadosPedido();
        
        NotaFiscalController.geraNotaFiscal(idVendedor, idCliente, idProduto);
    }
    
    public void CancelaPedido() {    
        int id;
        
        Scanner dados = new Scanner(System.in);
        
        System.out.printf("Informe o Id do pedido que deseja cancelar: ");
        id = dados.nextInt();  

        AlteraStatusPedido(id, 3); 
    }
   
    public void ImprimeDadosPedido() {
        int idPedido;
                
        Scanner dados = new Scanner(System.in);
        
        System.out.printf("Informe o Id do pedido que deseja imprimir: ");
        idPedido = dados.nextInt();
        
        Pedido[] lista = Pedido.RetornaListaPedidos();
        
        for (Pedido lista1 : lista) {
           if (lista1.getId() == idPedido) {
               Pedido pedido = new Pedido(lista1);
               System.out.println(pedido.toString());
           }
        }
    }
    
    /**
     *
     * @param idPedido
     * @param novoStatus
     */
    public void AlteraStatusPedido(int idPedido, int novoStatus) {
        Pedido pedido = new Pedido(idPedido, novoStatus);
        
        pedido.AlteraStatusPedido();
    }
    
    public void PesquisaPedidos() {}
    
    public ArrayList<Pedido> PesquisarPedidosPorIntervaloDeDatas(String inicioStr, String fimStr) {
    ArrayList<Pedido> resultado = new ArrayList<>();
    
    Pedido[] pedidos = RetornaListaPedidos();
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    try {
        Date inicio = dateFormat.parse(inicioStr);
        Date fim = dateFormat.parse(fimStr);
        for (Pedido pedido : pedidos) {
            if (dateFormat.parse(pedido.getDataHora()).after(inicio)  
                && dateFormat.parse(pedido.getDataHora()).before(fim)) {
          resultado.add(pedido);
            }
        }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultado;
    }   
}
