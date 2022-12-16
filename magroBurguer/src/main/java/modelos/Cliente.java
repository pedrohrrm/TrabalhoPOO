
package modelos;

import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class Cliente extends Pessoa {

    private String dadosUltimosPedidos;

    

    public Cliente(int id, String nome, String endereco, String celular, String dadosUltimosPedidos) {
        super(id, nome, endereco, celular);
        this.dadosUltimosPedidos = dadosUltimosPedidos;
    }

    public Cliente(int id, String nome, String dadosUltimosPedidos) {
        super(id, nome);
        this.dadosUltimosPedidos = dadosUltimosPedidos;
    }

    public String getDadosUltimosPedidos() {
        return dadosUltimosPedidos;
    }

    public void setDadosUltimosPedidos(String dadosUltimosPedidos) {
        this.dadosUltimosPedidos = dadosUltimosPedidos;
    }

    @Override
    public String toString() {
        return "Nome Cliente: " + this.nome + "Endereço Cliente: " + this.endereco + "Dados Ultimios Pedidos Cliente: "+ this.dadosUltimosPedidos; 
    }
    
   

}
