


import controller.ClienteController;
import controller.PedidoController;
import java.io.IOException;

/**
 *
 * @author pedro
 */
public class Sistema  {
    
    public static void main(String[] args) throws IOException {

        ClienteController clienteController = new ClienteController();
        PedidoController pedidoController = new PedidoController();
        
//        clienteController.AlteraCliente();     
        clienteController.CadastraCliente();
        
//        pedidoController.EfetuaPedido();
//        pedidoController.ImprimeDadosPedido();
//        pedidoController.CancelaPedido();
//        pedidoController.AlteraStatusPedido(3, 4);
        
        
    }
    

     
}
    
