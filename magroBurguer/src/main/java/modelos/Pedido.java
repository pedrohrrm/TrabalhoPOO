package modelos;

import java.util.Calendar;



/**
 *
 * @author pedro
 */
public class Pedido {
    private int id;
    private Cliente cliente;
    private String descricaoDetalhada;
    private int identificadorDescricao;
    private float valor;
    private Calendar dataHoraPedido;
    private String horarioEntrega;
    private String adicionais;
    

    public Pedido(Cliente cliente, float valor, Calendar dataHoraPedido, String adicionais) {
        this.cliente = cliente;
        this.valor = valor;
        this.dataHoraPedido = dataHoraPedido;
        this.adicionais = adicionais;
    }

    public Pedido(int id, Cliente cliente, String descricaoDetalhada, int identificadorDescricao, float valor, Calendar dataHoraPedido, String horarioEntrega, String adicionais) {
        this.id = id;
        this.cliente = cliente;
        this.descricaoDetalhada = descricaoDetalhada;
        this.identificadorDescricao = identificadorDescricao;
        this.valor = valor;
        this.dataHoraPedido = dataHoraPedido;
        this.horarioEntrega = horarioEntrega;
        this.adicionais = adicionais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Calendar getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(Calendar dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public String getHorarioEntrega() {
        return horarioEntrega;
    }

    public void setHorarioEntrega(String horarioEntrega) {
        this.horarioEntrega = horarioEntrega;
    }

    public String getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(String adicionais) {
        this.adicionais = adicionais;
    }

    
              
}
