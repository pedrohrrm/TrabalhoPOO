/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Cliente;
import static model.Cliente.RetornaCliente;
import model.NotaFiscal;
import model.Pedido;
import static model.Pedido.RetornaPedido;
import model.Produto;
import static model.Produto.RetornaProduto;

/**
 *
 * @author joaop
 */
public class NotaFiscalController {
    static public void geraNotaFiscal(int idPedido, int idCliente, int idProduto) {
        Pedido pedido = RetornaPedido(idPedido);
        Cliente cliente = RetornaCliente(idCliente);
        Produto produto = RetornaProduto(idProduto);
 
        NotaFiscal nota = new NotaFiscal (pedido, cliente, produto);
        
        nota.GravaDadosNota();
    }
}
