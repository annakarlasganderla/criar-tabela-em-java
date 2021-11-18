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

    public Produto selectProdutoById(int id) {
        String sql = "SELECT * FROM produtos WHERE idProduto = ?";

        try {

            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.setInt(1,id);

            ResultSet resultSet = stmt.executeQuery(); // executa a busca no banco

            while(resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getInt("idProduto"));
                produto.setNome(resultSet.getString("nome"));
                produto.setPrice(resultSet.getDouble("preco"));

                return produto;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public void editarProduto(Produto produto) {
            String sql = "UPDATE produtos SET nome = ?, preco = ? WHERE idProduto = ?";

            try {
                PreparedStatement stmt = conection.prepareStatement(sql);

                stmt.setString(1, produto.getNome());
                stmt.setDouble(2, produto.getPrice());
                stmt.setInt(3, produto.getId());

                stmt.execute();

            } catch (SQLException e){
                throw new RuntimeException(e);
            }
    }

    public void deletaProduto(Produto produto) {
            String sql = "DELETE FROM produtos WHERE idProduto = ?";

        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.setInt(1, produto.getId());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}


