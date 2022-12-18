package modelos;

import controller.PedidoController;
import java.util.Calendar;

/**
 *
 * @author pedro
 */
public class Pedido {
    private int id;
    private int idCliente;
    private int idProduto;
    private int idVendedor;
    private float valor;
    private Calendar dataHora;

    public Pedido(int idCliente, int idProduto, int idVendedor, float valor, Calendar dataHora) {
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.idVendedor = idVendedor;
        this.valor = valor;
        this.dataHora = dataHora;
        GeraId();
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    private void GeraId() {  
        PedidoController pedidoController = new PedidoController();
        Pedido[] lista = pedidoController.retornaListaPedidos();
        
        if (lista != null) {
            this.id = lista.length + 1;
        } else {
            this.id = 1;
        } 
    }            
}
