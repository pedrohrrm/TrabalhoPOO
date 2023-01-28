
package model;

/**
 *
 * @author pedro
 */
public class Produto{
    private int id;
    private String descricao;
    private float valor;

    public Produto(String descricao, float valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    
}