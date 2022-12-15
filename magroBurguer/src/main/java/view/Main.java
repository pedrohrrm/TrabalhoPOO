/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Calendar;
import modelos.Cliente;
import modelos.Pedido;
import modelos.Usuario;

/**
 *
 * @author pedro
 */
public class Main {

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente(1, "Pedro", "Rua x", "CEP", "pedidos");
        System.out.println(cliente.getNome());

        Usuario user = new Usuario(1, "Henrique", "Adminitrador", "******");
        System.out.println(user.getNome());
        
        
//        Calendar c = Calendar.getInstance();
//        Pedido pedido = new Pedido(cliente, 12,"Data/Hora Pedido:"+c.getTime(), "sem adicionais");
//        System.out.println(pedido);
    }

}
