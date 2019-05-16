package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import model.Usuario;

public class ProdutoImpl implements ProdutoDAO {

	@Override
	public List<Produto> listarTodosProdutos() {
		List<Produto> produtos = new ArrayList<Produto>();
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT * FROM Produto";
				preparedStatement = conn.prepareStatement(selectTableSQL);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
		             Produto produto = new Produto();
		             produto.setIdProduto(rs.getInt("IdProduto"));
		             produto.setNome(rs.getString("Nome"));
		             produto.setDescricao(rs.getString("Descricao"));
		             produto.setCategoria(rs.getString("Categoria"));
		             produto.setQuantidade(rs.getInt("Quantidade"));
		             produto.setPreco(rs.getDouble("Preco"));		             
		             produtos.add(produto);
		         }
		         rs.close();
		         return produtos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void updateProduto(Produto produto) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "UPDATE Produto SET Nome=?, Descricao=?, Categoria=?, Quantidade=?, Preco=? WHERE IdProduto=?";
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setString(1, produto.getNome());
				preparedStatement.setString(2, produto.getDescricao());
				preparedStatement.setString(3, produto.getCategoria());
				preparedStatement.setInt(4, produto.getQuantidade());
				preparedStatement.setDouble(5, produto.getPreco());
				preparedStatement.setInt(6, produto.getIdProduto());
				int resultado = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduto(Produto produto) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "DELETE FROM Produto WHERE IdProduto=?";
				preparedStatement = conn.prepareStatement(selectTableSQL);
				preparedStatement.setInt(1, produto.getIdProduto());
				preparedStatement.executeUpdate();
			    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void addProduto(Produto produto, Usuario usuario) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO Produto (Nome, Descricao, Categoria, Quantidade, Preco, IdVendedor) VALUES (?,?,?,?,?,?)";
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setString(1, produto.getNome());
				preparedStatement.setString(2, produto.getDescricao());
				preparedStatement.setString(3, produto.getCategoria());
				preparedStatement.setInt(4, produto.getQuantidade());
				preparedStatement.setDouble(5, produto.getPreco());
				preparedStatement.setInt(6, usuario.getIdUsuario());
				int resultado = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public List<Produto> listarProdutosPorVendedor(int IdVendedor) {
		List<Produto> produtos = new ArrayList<Produto>();
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT * FROM Produto WHERE IdVendedor=?";
				preparedStatement = conn.prepareStatement(selectTableSQL);
				preparedStatement.setInt(1, IdVendedor);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
		             Produto produto = new Produto();
		             produto.setIdProduto(rs.getInt("IdProduto"));
		             produto.setNome(rs.getString("Nome"));
		             produto.setDescricao(rs.getString("Descricao"));
		             produto.setCategoria(rs.getString("Categoria"));
		             produto.setQuantidade(rs.getInt("Quantidade"));
		             produto.setPreco(rs.getDouble("Preco"));		             
		             produtos.add(produto);
		         }
		         rs.close();
		         return produtos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Produto verProdutoPorId(int IdProduto) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT * FROM Produto WHERE IdProduto=?";
				preparedStatement = conn.prepareStatement(selectTableSQL);
				preparedStatement.setInt(1, IdProduto);
				ResultSet rs = preparedStatement.executeQuery();
				if(rs != null && rs.next()) {
					Produto novo = new Produto();
					novo.setIdProduto(rs.getInt("IdProduto"));
					novo.setNome(rs.getString("Nome"));
					novo.setDescricao(rs.getString("Descricao"));
					novo.setCategoria(rs.getString("Categoria"));
					novo.setQuantidade(rs.getInt("Quantidade"));
					novo.setPreco(rs.getDouble("Preco"));		      
					rs.close();
			        return novo;
		        }
				rs.close();
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
