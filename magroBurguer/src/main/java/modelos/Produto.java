
package modelos;

/**
 *
 * @author pedro
 */
public class Produto{
    private int id;
    private String descricaoDoProduto;
    private float valorProduto;
    private String adicionais;

    public Produto(int id, String descricaoDoProduto, float valorProduto) {
        this.id = id;
        this.descricaoDoProduto = descricaoDoProduto;
        this.valorProduto = valorProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricaoDoProduto() {
        return descricaoDoProduto;
    }

    public void setDescricaoDoProduto(String descricaoDoProduto) {
        this.descricaoDoProduto = descricaoDoProduto;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(String adicionais) {
        this.adicionais = adicionais;
    }
    
}
    
