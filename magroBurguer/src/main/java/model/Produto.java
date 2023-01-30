
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author pedro
 */
public class Produto {
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

    static public Produto[] RetornaListaProdutos() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        BufferedReader json;
        try {
            json = new BufferedReader(new FileReader("produto.json"));
        } catch (FileNotFoundException ex) {
            return null;
        }
            
        Produto[] lista = gson.fromJson(json, Produto[].class);

        return lista;
    }
    
    static public Produto RetornaProduto(int idProduto) {
        Produto[] lista = RetornaListaProdutos();
        
        for (Produto lista1 : lista) {
            if (lista1.getId() == idProduto) {
                return lista1;
            }
        }
        return null;
    } 
}