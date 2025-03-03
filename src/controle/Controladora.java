package controle;

import java.util.ArrayList;


import model.*;
import view.*;

import javax.swing.*;

public class Controladora {
    Produtos produtos = new Produtos();
    Cadastro cadastro;
    Cupom cupom;
    ArrayList<Cupom> listaCupons = new ArrayList<>();

    public void exibeMenu(){
        int opcao;

        do { 
            opcao = EntradaSaida.solicitaOpcao();
            while(produtos == null && opcao !=0){
                EntradaSaida.exibeMsg();
                opcao = EntradaSaida.solicitaOpcao();
            }

            switch(opcao){
                case 0:
                    int codigoProduto = EntradaSaida.solicitaCodigo();
                    String descricaoProduto = EntradaSaida.solicitaDescricao();
                    double precoProduto = EntradaSaida.solicitaPreco();
                    this.cadastro = new Cadastro();
                    cadastro.setProduto(codigoProduto);
                    cadastro.setDescricao(descricaoProduto);
                    cadastro.setPreco(precoProduto);
                    produtos.adicionaProduto(cadastro);
                break;

                case 1:
                String informacoes = this.produtos.listaProdutosCadastrados();
                if(informacoes.isEmpty()){
                    EntradaSaida.exibeMsgCadastro();
                }else{
                    EntradaSaida.exibeListaCadastro(informacoes);
                }
                break;

                case 2:
                ArrayList<Cadastro> listaDeProdutos = produtos.getListaDeProdutos();
                int indiceProduto = EntradaSaida.solicitaEstoque(listaDeProdutos);

                if (indiceProduto >= 0 && indiceProduto < listaDeProdutos.size()) {
                    Cadastro produtoSelecionado = listaDeProdutos.get(indiceProduto);
                    int qtdEstoqueAdicionada = EntradaSaida.solicitaQtdEstoque(produtoSelecionado.getQtd());
                    produtoSelecionado.setQtd(produtoSelecionado.getQtd() + qtdEstoqueAdicionada);
                } else {
                    EntradaSaida.exibeMsgCadastro();
                }
                break;

                case 3:
                    listaDeProdutos = produtos.getListaDeProdutos();
                    indiceProduto = EntradaSaida.solicitaVenda(listaDeProdutos);

                    if (indiceProduto >= 0 && indiceProduto < listaDeProdutos.size()) {
                        Cadastro produtoSelecionado = listaDeProdutos.get(indiceProduto);
                        if (produtoSelecionado.getQtd() > 0) {
                            int quantidadeVendida = EntradaSaida.solicitaQtdVenda();

                            if (quantidadeVendida <= produtoSelecionado.getQtd()) {
                                produtoSelecionado.setQtd(produtoSelecionado.getQtd() - quantidadeVendida);
                                double valorTotal = quantidadeVendida * produtoSelecionado.getPreco();
                                produtos.adicionarVenda(valorTotal);
                                this.cupom = new Cupom(produtoSelecionado.getDescricao(), quantidadeVendida, valorTotal);
                                listaCupons.add(cupom);
                                EntradaSaida.exibeCupom(cupom.getCupomDetalhado());
                            } else {
                                JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Estoque zerado para este produto!");
                        }
                    } else {
                        EntradaSaida.exibeMsgCadastro();
                    }
                break;

                case 4:
                String infoEstoque = this.produtos.listaDeEstoque();
                if(infoEstoque.isEmpty()){
                    EntradaSaida.exibeMsgCadastro();
                }else{
                    EntradaSaida.exibeListaEstoque(infoEstoque);
                }
                break;

                case 5:
                        String cupomGerado = cupom.gerarExtratoCupons(listaCupons);
                        EntradaSaida.exibeCupomGerado(cupomGerado);
                break;

                case 6:
                    double valorTotalVendas = produtos.getValorTotalVendas();
                    EntradaSaida.exibeValorTotalVendas(valorTotalVendas);
                break;

            }
        } while (opcao != 7);
        EntradaSaida.exibeMsgEncerraPrograma();
    }
}
