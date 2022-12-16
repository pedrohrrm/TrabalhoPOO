//ATENÇÃO: AS IMAGENS E ÍCONES UTILIZADOS NESSE PROJETO PERTENCEM A: ICONIFY, ICONS8, UNSPLASH E PEXELS

package view;

import modelos.Cliente;
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
