package model;




import controller.ClienteController;
import controller.PedidoController;
import java.io.IOException;

/**
 
 * @author pedro
 */
public class Sistema  {
    static int contadorClientes = 0;
    protected static int contadorClientesProtected = 0;
    public static void main(String[] args) throws IOException {

        ClienteController clienteController = new ClienteController();
        PedidoController pedidoController = new PedidoController();
        
        
//        clienteController.AlteraCliente();     
//        clienteController.CadastraCliente();
        
//        pedidoController.EfetuaPedido();
//        pedidoController.ImprimeDadosPedido();
//        pedidoController.CancelaPedido();
//        pedidoController.AlteraStatusPedido(3, 4);
        String inicioStr = "17/12/2022 03:32:10";
        String fimStr = "28/01/2023 03:32:10";
        System.out.print(pedidoController.PesquisarPedidosPorIntervaloDeDatas(inicioStr, fimStr));
        
        
    }
    
    public static void setContadorClientes(int contadorClientes) {
        Sistema.contadorClientes = contadorClientes;
    }
    
    public static int getContadorClientes() {
        return contadorClientes;
    }
    
    public static int getContadorClientesProtected() {
        return contadorClientesProtected;
    }
     
}
    

