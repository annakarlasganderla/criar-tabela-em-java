package Controller;

import Dao.ProdutoDao;
import Model.Produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    ProdutoDao prodDao = new ProdutoDao();

    public void criaProduto(Produto produto) throws IOException, SQLException {
        prodDao.criaTabelaProdutos(produto);
    }

    public void cadastraProduto(Produto produto) throws IOException, SQLException {
        prodDao.cadastraProduto(produto);
    }

    public List<Produto> listarProdutos() throws SQLException {
       return prodDao.listarProdutos();
    }

    public Produto selecionaPeloId(int id){
        return prodDao.selectProdutoById(id);
    }

    public void editarProduto(Produto produto){
        prodDao.editarProduto(produto);
    }

    public void deletaProduto(Produto produto) {
        prodDao.deletaProduto(produto);
    }

}
