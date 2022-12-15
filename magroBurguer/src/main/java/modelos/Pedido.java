/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author pedro
 */
public class Pedido {
    private int id;
    private String descricaoDetalhada;
    private int identificadorDescricao;
    private float valor;
    private Date dataPedido;
    private Time horarioPedido;
    private Time horarioEntrega;
    private String adicionais;

    public Pedido(int id, String descricaoDetalhada, int identificadorDescricao, float valor, Date dataPedido, Time horarioPedido, Time horarioEntrega, String adicionais) {
        this.id = id;
        this.descricaoDetalhada = descricaoDetalhada;
        this.identificadorDescricao = identificadorDescricao;
        this.valor = valor;
        this.dataPedido = dataPedido;
        this.horarioPedido = horarioPedido;
        this.horarioEntrega = horarioEntrega;
        this.adicionais = adicionais;
    }

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    public int getIdentificadorDescricao() {
        return identificadorDescricao;
    }

    public void setIdentificadorDescricao(int identificadorDescricao) {
        this.identificadorDescricao = identificadorDescricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Time getHorarioPedido() {
        return horarioPedido;
    }

    public void setHorarioPedido(Time horarioPedido) {
        this.horarioPedido = horarioPedido;
    }

    public Time getHorarioEntrega() {
        return horarioEntrega;
    }

    public void setHorarioEntrega(Time horarioEntrega) {
        this.horarioEntrega = horarioEntrega;
    }

    public String getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(String adicionais) {
        this.adicionais = adicionais;
    }

   
    
    
}
