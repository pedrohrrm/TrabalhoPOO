package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.PedidoController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Pedido(int idCliente, int idProduto, int idVendedor, float valor) {
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.idVendedor = idVendedor;
        this.status = 0;
        this.valor = valor;
        this.dataHora = GeraDataHora();
        GeraId();
    }
    
    public Pedido(int idPedido, int novoStatus) {
        this.id = idPedido;
         this.status = novoStatus;
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
        Pedido[] lista = RetornaListaPedidos();
        
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
    
    public void GravaDadosPedido() {
        String dataHora = GeraDataHora();
        
        List<Pedido> pedidos = new ArrayList<>();
        
        Pedido[] lista = RetornaListaPedidos();
        
        if (lista != null) {
            //Adiciona os clientes ja existente no arquivo
            for (Pedido lista1 : lista) {
               pedidos.add(lista1);
            }
        } 

        //Adiciona o novo cliente no arquivo
        pedidos.add(this);
        
        EscreveArquivo(pedidos);   
    }
    
    private String GeraDataHora() {
        Date date = new Date(); 
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  
        String strDate = dateFormat.format(date);  
        
        return strDate;
    }

    static public Pedido[] RetornaListaPedidos() {
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
    
    public void AlteraStatusPedido() {
        List<Pedido> pedidos = new ArrayList<>();
        Pedido[] lista = RetornaListaPedidos();
      
        for (Pedido lista1 : lista) {
           if (lista1.getId() != this.id) {              
               pedidos.add(lista1);
           } else {
               lista1.setStatus(this.status);
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
