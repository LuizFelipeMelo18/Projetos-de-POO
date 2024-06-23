package main;

import modelo.Produto;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mercado {
    private static Scanner leitura = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;

    public static void main(String[] args){
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }

    private static void menu(){
        System.out.println("-------------------------------------------");
        System.out.println("----------- Bem vindo ao mercado ----------");
        System.out.println("-------------------------------------------");
        System.out.println("|  Opção 1 - Cadastrar  |");
        System.out.println("|  Opçãp 2 - Listar     |");
        System.out.println("|  Opção 3 - Comprar    |");
        System.out.println("|  Opção 4 - Carrinho   |");
        System.out.println("|  Opção 5 - Sair       |");
        System.out.println("------- Selecione a opção desejada --------");
        System.out.println("-------------------------------------------");
        int opcao = leitura.nextInt();

        switch (opcao){
            case 1:
                cadastrar();
                break;

            case 2:
                listar();
                break;

            case 3:
                comprar();
                break;

            case 4:
                mostrarCarrinho();
                break;

            case 5:
                System.out.println("Obrigado por escolher nossa loja, volte ssempre!");
                System.exit(0);
                break;

            default:
                System.out.println("Opção Invalida!");
                menu();
                break;
        }
    }

    private static void cadastrar(){
        System.out.println("Digite o nome do produto: ");
        String nomeProduto = leitura.next();

        System.out.println("Digite o valor do produto: ");
        Double precoProduto = leitura.nextDouble();

        Produto produto = new Produto(nomeProduto, precoProduto);
        produtos.add(produto);

        System.out.println(produto.getNome() + " foi cadastrado com sucesso!");
        menu();
    }

    private static void listar(){
        if (produtos.size() > 0){
            System.out.println("Lista de produtos: ");

            for (Produto p : produtos){
                System.out.println(p + "\n");
            }
        } else {
            System.out.println("Sem produtos cadastrados!");
        }

        menu();
    }

    private static void comprar(){
        if (produtos.size() > 0) {
            System.out.println("------ Produtos disponíveis ------");

            for (Produto p : produtos) {
                System.out.println(p + "\n");
            }

            System.out.print("Código do produto: ");
            int id = Integer.parseInt(leitura.next());

            Produto produtoEncontrado = null;

            for (Produto p : produtos) {
                if (p.getId() == id) {
                    produtoEncontrado = p;
                    break;
                }
            }

            if (produtoEncontrado != null) {
                int qtd = 0;

                try {
                    qtd = carrinho.get(produtoEncontrado); // verifica se o produto já está no carrinho e adiciona a quantidade
                    carrinho.put(produtoEncontrado, qtd + 1);
                } catch (NullPointerException e) {
                    carrinho.put(produtoEncontrado, 1); // caso o produto for o primeiro do carrinho
                }
                System.out.println(produtoEncontrado.getNome() + " adicionado ao carrinho!");

                System.out.println("Deseja adicionar um novo produto?");
                System.out.println("Digite 1 para adicionar um novo produto");
                System.out.println("Digite 2 para encerrar a compra!");
                int opcao = Integer.parseInt(leitura.next());

                if (opcao == 1) {
                    comprar();
                } else {
                    finalizarCompra();
                }
            } else {
                System.out.println("Produto não encontrado!");
                menu();
            }
        } else {
            System.out.println("Não existem produtos cadastrados!");
            menu();
        }
    }

    private static void mostrarCarrinho(){
        System.out.println("----- Produtos no carrinho -----");
        if (carrinho.size() > 0){
            for (Produto p : carrinho.keySet()){
                System.out.println("Produto: " + p + "\n Quantidade: " + carrinho.get(p));
            }
        } else {
            System.out.println("Carrinho vazio!");
        }

        menu();
    }

    private static void finalizarCompra(){
        Double valorTotal = 0.0;

        System.out.println("Seus produtos: ");

        for (Produto p : carrinho.keySet()){
            int qtd = carrinho.get(p);
            valorTotal += p.getPreco() * qtd;

            System.out.println("Produto: " + p);
            System.out.println("Quantidade: " + qtd);
        }

        System.out.println("O valor da sua compra é: " + Utils.doubleToString(valorTotal));
        carrinho.clear();

        System.out.println("Compra Realizada!");
        menu();
    }
}
