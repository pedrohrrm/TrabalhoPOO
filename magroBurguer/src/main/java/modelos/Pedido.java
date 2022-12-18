package modelos;

import controller.PedidoController;
import java.util.Calendar;

/**
 *
 * @author pedro
 * 
 * Status do pedido:
 * 0 = Em preparo;
 * 1 = Pedido saiu para entrega;
 * 2 = Pedido entregue;
 * 3 = Pedido cancelado;
 */
public class Pedido {
    private int id;
    private int idCliente;
    private int idProduto;
    private int idVendedor;
    private int status;
    private float valor;
    private String dataHora;

    public Pedido(int idCliente, int idProduto, int idVendedor, float valor, String dataHora) {
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.idVendedor = idVendedor;
        this.status = 0;
        this.valor = valor;
        this.dataHora = dataHora;
        GeraId();
    }
    
    public Pedido(Pedido pedido) {
        this.id = pedido.id;
        this.idCliente = pedido.idCliente;
        this.idProduto = pedido.idProduto;
        this.idVendedor = pedido.idVendedor;
        this.status = pedido.status;
        this.valor = pedido.valor;
        this.dataHora = pedido.dataHora; 
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    private void GeraId() {  
        PedidoController pedidoController = new PedidoController();
        Pedido[] lista = pedidoController.RetornaListaPedidos();
        
        if (lista != null) {
            this.id = lista.length + 1;
        } else {
            this.id = 1;
        } 
    } 
    
    public String DefineStatusPedido() {
        return switch (this.status) {
            case 0 -> "Em preparo";
            case 1 -> "Pedido saiu para entrega";
            case 2 -> "Pedido entregue";
            case 3 -> "Pedido cancelado";
            default -> "";
        };
    }
    
//    public String FormataDataHora() {
//        return (
//            "\nPedido efetuado em: " + this.dataHora.get(5) + "/" 
//            + this.dataHora.get(2) + "/" + this.dataHora.get(1) 
//            + " as " + this.dataHora.get(4) + ":" + this.dataHora.get(5) + "H"
//        );
//    }
    
    @Override
    public String toString() {
        return ("Id Pedido: " + this.id
            + "\nId Cliente: " + this.idCliente
            + "\nId Vendedor: " + this.idVendedor
            + "\nId Produto: " + this.idProduto
            + "\nStatus: " + DefineStatusPedido()
            + "\nValor: " + this.valor
            + "\nPedido efetuado em: " + this.dataHora);

    }
}
