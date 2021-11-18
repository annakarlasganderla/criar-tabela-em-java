package Dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Factory.ConectionFactory;
import Model.Produto;

public class ProdutoDao {

        private Connection conection;

        public ProdutoDao() {
            this.conection = new ConectionFactory().getConection();
        }

        public void criaTabelaProdutos(Produto produto) throws IOException, SQLException {
            String sql = "CREATE TABLE IF NOT EXISTS produtos (" +
                    "idProduto INT PRIMARY KEY AUTO_INCREMENT," +
                    "nome VARCHAR(50) NOT NULL," +
                    "preco DECIMAL(10,2) );";

            PreparedStatement stmt = conection.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        }

        public void cadastraProduto(Produto produto) throws SQLException {
            String sql = "INSERT INTO produtos" +
                    " (nome, preco) " +
                    "VALUES (?,?)";

            PreparedStatement stmt = conection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrice());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                produto.setId(resultSet.getInt(1));
            }
        }

    public List<Produto> listarProdutos() throws SQLException {
        String sql = "SELECT * FROM produtos";

        PreparedStatement stmt = conection.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        List<Produto> listaDeProdutos = new ArrayList<>();

        while(resultSet.next()) {
            Produto produto = new Produto();

            produto.setId(resultSet.getInt("idProduto"));
            produto.setNome(resultSet.getString("nome"));
            produto.setPrice(resultSet.getDouble("preco"));

            listaDeProdutos.add(produto);
        }
        return listaDeProdutos;
    }


}

