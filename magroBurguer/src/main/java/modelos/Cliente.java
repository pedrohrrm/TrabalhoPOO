/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author pedro
 */
public class Cliente extends Pessoa {

    private String dadosUltimosPedidos;

    public Cliente(String dadosUltimosPedidos, int id, String nome, String endereco, String celular) {
        super(id, nome, endereco, celular);
        this.dadosUltimosPedidos = dadosUltimosPedidos;
    }

    public Cliente(String dadosUltimosPedidos, int id, String nome) {
        super(id, nome);
        this.dadosUltimosPedidos = dadosUltimosPedidos;
    }

    public String getDadosUltimosPedidos() {
        return dadosUltimosPedidos;
    }

    public void setDadosUltimosPedidos(String dadosUltimosPedidos) {
        this.dadosUltimosPedidos = dadosUltimosPedidos;
    }

}
