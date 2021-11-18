package View;

import Controller.ProdutoController;
import Model.Produto;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class ProdutoView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    ProdutoController produtoController = new ProdutoController();

    public void cadastraProduto() throws SQLException, IOException {

        Produto produto = new Produto();

        System.out.println("Digite o nome do produto: ");
        produto.setNome(leitor.next());

        System.out.println("Digite o preço do produto: ");
        produto.setPrice(leitor.nextDouble());

        produtoController.criaProduto(produto);
        produtoController.cadastraProduto(produto);
    }

    public void mostrarProdutos() throws SQLException {
        System.out.println(produtoController.listarProdutos());
    }

    public Produto selecionaProdutoById() throws SQLException {
        this.mostrarProdutos();

        System.out.println("Selecione o produto que deseja editar: ");
        int produtoSelecionado = leitor.nextInt();

        Produto produto  = produtoController.selecionaPeloId(produtoSelecionado);

        System.out.println("O produto selecionado foi " + produto);

        return produto;
    }

    public void editarProduto(Produto produto) throws SQLException {
        int op = 0;

        do {
            System.out.println("Escolha o que você quer editar: ");
            System.out.println("| 1 - Nome |");
            System.out.println("| 2 - Preço |");

            int selecionaAtributo = leitor.nextInt();

            switch (selecionaAtributo) {
                case 1:
                    System.out.println("Digite o novo nome: ");
                    produto.setNome(leitor.next());
                    break;

                case 2:
                    System.out.println("Digite o novo preço: ");
                    produto.setPrice(leitor.nextDouble());
                    break;

                default:
                    System.out.println("Opção invalida");
            }

            System.out.println("Deseja continuar? 1 - Sim | 0 - Não");
            op = leitor.nextInt();

        } while (op != 0);

        System.out.println("Produto editado com sucesso!");
        produtoController.editarProduto(produto);

    }



}
