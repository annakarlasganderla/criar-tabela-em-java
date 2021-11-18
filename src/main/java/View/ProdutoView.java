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



}
