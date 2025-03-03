package model;


public class Cadastro {
    private int codigoProduto;
    private String descricaoProduto;
    private double precoProduto;
    private int qtdEstoque;



    public int getProduto(){
        return this.codigoProduto;
    }
    public void setProduto(int codigoProduto){
        this.codigoProduto = codigoProduto;
    }
    public String getDescricao(){
        return this.descricaoProduto;
    }
    public void setDescricao(String descricaoProduto){
        this.descricaoProduto = descricaoProduto;
    }
    public double getPreco(){
        return this.precoProduto;
    }
    public void setPreco(double precoProduto){
        this.precoProduto = precoProduto;
    }
    public int getQtd(){
        return this.qtdEstoque;
    }
    public void setQtd(int qtdEstoque){
        this.qtdEstoque = qtdEstoque;
    }

}
