package model;

import java.util.ArrayList;
import java.text.NumberFormat;

public class Produtos {
    private ArrayList<Cadastro> listaDeProdutos = new ArrayList<Cadastro>();
    private double valorTotalVendas = 0;


    public void adicionaProduto(Cadastro cadastro){
        listaDeProdutos.add(cadastro);
    }
    public ArrayList<Cadastro> getListaDeProdutos(){
        return listaDeProdutos;
    }
    public void adicionarVenda(double valorTotal) {
        this.valorTotalVendas += valorTotal;
    }
    public double getValorTotalVendas() {
        return valorTotalVendas;
    }
    public String listaProdutosCadastrados() {
        String informacoes = "";
        for (Cadastro cadastro : listaDeProdutos) {
            String saldoFormatado = NumberFormat.getCurrencyInstance().format(cadastro.getPreco());
            informacoes += "Codigo do produto: " + cadastro.getProduto()+ "\nDescrição do produto: "+ cadastro.getDescricao()+
                    "\nPreço do produto: " + saldoFormatado +
                    "\n-------------------------\n";
            
        }
        return informacoes;
    }
    public String listaDeEstoque() {
        String informacoes = "";
        for (Cadastro cadastro : listaDeProdutos) {
            String saldoFormatado = NumberFormat.getCurrencyInstance().format(cadastro.getPreco());
            informacoes += "Codigo do produto: " + cadastro.getProduto() + "\nDescrição do produto: " + cadastro.getDescricao() +
                    "\nPreço do produto: " + saldoFormatado + "\nQuantidade de produtos em estoque: " + cadastro.getQtd() + "\n-------------------------\n";
        }
        return informacoes;
    }
}
