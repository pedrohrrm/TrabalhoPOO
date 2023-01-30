/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaop
 */
public class NotaFiscal {
    private int idNota;
    private Pedido pedido;
    private Cliente cliente;
    private Produto produto; 
    
    public NotaFiscal(Pedido pedido, Cliente cliente, Produto produto) {
        this.pedido = pedido;
        this.cliente = cliente;
        this.produto = produto;
        this.GeraId();
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    private void GeraId() {
        NotaFiscal[] lista = retornaListaNotasFiscais();
        
        if (lista != null) {
            this.idNota = lista.length + 1;
        } else {
            this.idNota = 1;
        } 
    }

    private NotaFiscal[] retornaListaNotasFiscais() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        BufferedReader json = null;
        try {
            json = new BufferedReader(new FileReader("notaFiscal.json"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        NotaFiscal[] lista = gson.fromJson(json, NotaFiscal[].class);

        return lista;
    }
    
    public void GravaDadosNota() {
        List<NotaFiscal> notas = new ArrayList<>();
       
        NotaFiscal[] lista = retornaListaNotasFiscais();
        
        notas.addAll(Arrays.asList(lista));
        
        notas.add(this);
        
        EscreveArquivo(notas);
    } 
    
    private void EscreveArquivo(List<NotaFiscal> notas) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = gson.toJson(notas);

        try ( 
            FileWriter writer = new FileWriter("notaFiscal.json")) {
            writer.write(json);
        } catch (IOException ex) {
            Logger.getLogger(NotaFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String toString() {
        return ("Numero Nota: " + this.idNota
                + "\nNumero Pedido: " + this.pedido.getId()
                + "\nNumero Produto: " + this.produto.getId()
                + "\nNome Cliente: " + this.cliente.getNome()
                + "\nValor: " + this.pedido.getValor()); 
    }
}
