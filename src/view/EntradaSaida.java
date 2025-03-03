package view;

import model.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.util.ArrayList;

public class EntradaSaida {


        public static int solicitaOpcao() {
        String[] opcoes = {"Cadastrar Produtos", "Produtos Cadastrados", "Entrada Estoque","Vender Produtos",
                "Produtos em estoque", "Cupons gerados", "Valor total dos cupons","Sair do programa"};
        JComboBox<String> menu = new JComboBox<String>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);
        return menu.getSelectedIndex();
        }
        public static void exibeMsg() {
            JOptionPane.showMessageDialog(null, "Não tem nenhum produto em cadastrado/ em estoque!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        public static int solicitaCodigo(){
            return Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o codigo do produto:"));
        }
        public static String solicitaDescricao(){
            return JOptionPane.showInputDialog(null, "Descrição do produto:");
        }
        public static double solicitaPreco(){
            return Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o valor do produto?"));
        }
        public static int solicitaEstoque(ArrayList<Cadastro> listaDeProdutos) {
            int qtdEstoque = listaDeProdutos.size();
            String[] descricoesProdutos = new String[qtdEstoque];
    
            for (int i = 0; i < qtdEstoque; i++) {
                Cadastro cadastro = listaDeProdutos.get(i);
                descricoesProdutos[i] = cadastro.getProduto() + " - " + cadastro.getDescricao();
            }
            String msg = "Escolha o produto que deseja dar entrada no estoque";
            JComboBox exibicaoProdutos = new JComboBox(descricoesProdutos);
            int confirmacao = JOptionPane.showConfirmDialog(null, exibicaoProdutos, msg, JOptionPane.OK_CANCEL_OPTION);
    
            if (confirmacao == JOptionPane.OK_OPTION) {
                return exibicaoProdutos.getSelectedIndex();
            } else {
                return -1;
            }
        }
        public static int solicitaVenda(ArrayList<Cadastro> listaDeProdutos) {
        int qtdEstoque = listaDeProdutos.size();
        String[] descricoesProdutos = new String[qtdEstoque];

        for (int i = 0; i < qtdEstoque; i++) {
            Cadastro cadastro = listaDeProdutos.get(i);
            descricoesProdutos[i] = cadastro.getProduto() + " - " + cadastro.getDescricao();
        }
        String msg = "Escolha o produto que será vendido";
        JComboBox exibicaoProdutos = new JComboBox(descricoesProdutos);
        int confirmacao = JOptionPane.showConfirmDialog(null, exibicaoProdutos, msg, JOptionPane.OK_CANCEL_OPTION);

        if (confirmacao == JOptionPane.OK_OPTION) {
            return exibicaoProdutos.getSelectedIndex();
        } else {
            return -1;
        }
    }
        public static void exibeMsgCadastro(){
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado");
        }
        public static void exibeListaCadastro(String informacoes){
            JOptionPane.showMessageDialog(null, informacoes,"Lista de produtos cadastrados", 1);
        }
        public static int solicitaQtdEstoque(int estoque){
            return Integer.parseInt(JOptionPane.showInputDialog(null,"Quantos itens gostaria de adcionar ao estoque?"));
        }
        public static int solicitaQtdVenda(){
        return Integer.parseInt(JOptionPane.showInputDialog(null,"Quantos itens gostaria de adcionar ao estoque?"));
    }
        public static void exibeListaEstoque(String infoEstoque){
            JOptionPane.showMessageDialog(null, infoEstoque,"Lista de produtos cadastrados", 1);
        }
        public static void exibeCupom(String detalhesCupom) {
        JOptionPane.showMessageDialog(null, detalhesCupom, "Cupom Fiscal", JOptionPane.INFORMATION_MESSAGE);
        }
        public static void exibeCupomGerado(String vendaCupom) {
            JOptionPane.showMessageDialog(null, vendaCupom, "Cupons Gerados", JOptionPane.INFORMATION_MESSAGE);
        }
        public static void exibeValorTotalVendas(double valorTotalVendas) {
        String valorFormatado = NumberFormat.getCurrencyInstance().format(valorTotalVendas);
        JOptionPane.showMessageDialog(null, "Valor total dos cupons gerados: " + valorFormatado, "Valor total:", JOptionPane.INFORMATION_MESSAGE);
    }
        public static void exibeMsgEncerraPrograma() {
            JOptionPane.showMessageDialog(null, "O programa sera encerrado!");
        }
}

