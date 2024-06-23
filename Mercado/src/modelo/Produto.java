package modelo;

import utils.Utils;

public class Produto {
    private static int count = 1;
    private int Id;
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco){
        this.Id = count;
        this.nome = nome;
        this.preco = preco;
        Produto.count += 1;
    }

    public int getId(){
        return Id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Double getPreco(){
        return preco;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }

    public String toString(){
        return "Id: " + this.Id +
                "\nProduto: " + this.getNome() +
                "\nPreço: " + Utils.doubleToString(this.getPreco());
    }
}
