package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import model.Compra;
import model.Produto;
import model.ProdutoComprado;

public class CompraImpl implements CompraDAO {

	@Override
	public int addCompra(List<ProdutoComprado> ProdutoComprado, int IdComprador) {
		PreparedStatement preparedStatement;
		int resultado = 0;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO Compra (Data,Valor,IdComprador) VALUES (?,?,?)";
				preparedStatement = conn.prepareStatement(insertTableSQL);
				String data = getDateTime();
				preparedStatement.setString(1, data);
				preparedStatement.setDouble(2, getValorTotal(ProdutoComprado));
				preparedStatement.setInt(3, IdComprador);
				resultado = preparedStatement.executeUpdate( );
				if(resultado == 1) {
					resultado = addListaCompra(ProdutoComprado, buscarIdCompra(data).getIdCompra());
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
		
	}

	@Override
	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date); 
	}

	@Override
	public double getValorTotal(List<ProdutoComprado> ProdutoComprado) {
		double valor = 0;
		for(int i = 0; i < ProdutoComprado.size(); i++) {
			valor += ProdutoComprado.get(i).getTotal();
		}
		return valor;
	}

	@Override
	public int addListaCompra(List<ProdutoComprado> ProdutoComprado, int IdCompra) {
		PreparedStatement preparedStatement;
		int resultado = 0;
		Statement stm;
		Connection conn;
		for(int i = 0; i < ProdutoComprado.size(); i++) {
			try {
				conn = ProvedorConexao.getConnection();
				String insertTableSQL = "INSERT INTO ProdutoComprado (Quantidade,Preco,Total,IdProduto,IdCompra) VALUES (?,?,?,?,?)";
					preparedStatement = conn.prepareStatement(insertTableSQL);
					preparedStatement.setInt(1, ProdutoComprado.get(i).getQuantidade());
					preparedStatement.setDouble(2, ProdutoComprado.get(i).getPreco());
					preparedStatement.setDouble(3, ProdutoComprado.get(i).getTotal());
					preparedStatement.setInt(4, ProdutoComprado.get(i).getProduto().getIdProduto());
					preparedStatement.setInt(5, IdCompra);
					resultado = preparedStatement.executeUpdate();
					if(resultado == 1) {
						resultado = removerQuantidadeComprada(ProdutoComprado);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public Compra buscarIdCompra(String data) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT * FROM Compra WHERE Data=?";
				preparedStatement = conn.prepareStatement(selectTableSQL);
				preparedStatement.setString(1, data);
				ResultSet rs = preparedStatement.executeQuery();
				if(rs != null && rs.next()) {
					Compra resgata = new Compra();
					resgata.setIdCompra(rs.getInt("IdCompra"));
					resgata.setData(rs.getString("Data"));
					resgata.setValor(rs.getDouble("Valor"));
					resgata.setIdComprador(rs.getInt("IdComprador"));
					rs.close();
			        return resgata;
		        }
				rs.close();
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int removerQuantidadeComprada(List<ProdutoComprado> ProdutoComprado) {
		int resultado = 0;
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		for(int i = 0; i < ProdutoComprado.size(); i++) {
			try {
				conn = ProvedorConexao.getConnection();
				String insertTableSQL = "UPDATE Produto SET Quantidade=? WHERE IdProduto=?";
					preparedStatement = conn.prepareStatement(insertTableSQL);
					preparedStatement.setInt(1, 
							ProdutoComprado.get(i).getProduto().getQuantidade()
							- // menos
							ProdutoComprado.get(i).getQuantidade());
					preparedStatement.setInt(2, ProdutoComprado.get(i).getProduto().getIdProduto()
							);
					resultado = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public List<Compra> listarComprasRealizadas() {
		List<Compra> compras = new ArrayList<Compra>();
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT * FROM Compra";
				preparedStatement = conn.prepareStatement(selectTableSQL);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
		             Compra compra = new Compra();
		             compra.setIdCompra(rs.getInt("IdCompra"));
		             compra.setData(rs.getString("Data"));
		             compra.setValor(rs.getDouble("Valor"));
		             compra.setIdComprador(rs.getInt("IdComprador"));
		             compras.add(compra);
		         }
		         rs.close();
		         return compras;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
