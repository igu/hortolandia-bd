package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.ProdutoComprado;

public class CompraImpl implements CompraDAO {

	@Override
	public void addCompra(List<ProdutoComprado> ProdutoComprado, int IdUsuario) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO Compra (Data,Valor,IdComprador) VALUES (?,?,?)";
				preparedStatement = conn.prepareStatement(insertTableSQL);
				// RESTO
				int resultado = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	
}
