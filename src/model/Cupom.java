package model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Cupom {
    private String dataVenda;
    private String descricaoProduto;
    private int quantidadeVendida;
    private double valorTotal;


    public Cupom(String descricaoProduto, int quantidadeVendida, double valorTotal) {
        this.dataVenda = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.descricaoProduto = descricaoProduto;
        this.quantidadeVendida = quantidadeVendida;
        this.valorTotal = valorTotal;
    }
    public String getCupomDetalhado() {
        return String.format("Data: %s \n Produto: %s \n Quantidade: %d \n Total: R$ %.2f"+"\n-------------------------------------\n",
                dataVenda, descricaoProduto, quantidadeVendida, valorTotal);
    }
    public String gerarExtratoCupons(ArrayList<Cupom> listaCupons) {
        StringBuilder cupomGerado = new StringBuilder();
            for (Cupom cupom : listaCupons) {
                cupomGerado.append(cupom.getCupomDetalhado()).append("\n");
            }
        return cupomGerado.toString();
    }
}