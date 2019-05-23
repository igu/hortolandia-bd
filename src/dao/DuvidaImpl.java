package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Duvida;
import model.Produto;
import model.Usuario;

public class DuvidaImpl implements DuvidaDAO {

	@Override
	public void addDuvida(Duvida duvida) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO Duvida (Duvida, IdProduto, IdUsuarioPergunta) VALUES (?,?,?)";
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setString(1, duvida.getDuvida());
				preparedStatement.setInt(2, duvida.getProduto().getIdProduto());
				preparedStatement.setInt(3, duvida.getUsuarioPergunta().getIdUsuario());
				int resultado = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void aswDuvida(String asw, int IdDuvida, Usuario usuarioResponde) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "UPDATE Duvida SET Resposta=?, IdUsuarioResposta=? WHERE IdDuvida=?";
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setString(1, asw);
				preparedStatement.setInt(2, usuarioResponde.getIdUsuario());
				preparedStatement.setInt(3, IdDuvida);
				int resultado = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Duvida> listarDuvidaPorProduto(Produto produto) {
		List<Duvida> duvidas = new ArrayList<Duvida>();
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT" + 
					" duv.IdDuvida," + 
					" duv.Duvida," + 
					" duv.Resposta," + 
					" IFNULL(duv.Resposta, \"SEM RESPOSTA ATE O MOMENTO\") AS Resposta" + 
					" FROM duvida duv\n" + 
					"		INNER JOIN produto pro ON duv.IdProduto = pro.IdProduto\n" + 
					"		INNER JOIN usuario usu1 ON duv.IdUsuarioPergunta = usu1.IdUsuario\n" + 
					"			WHERE pro.IdProduto = ?;";
				preparedStatement = conn.prepareStatement(selectTableSQL);
				preparedStatement.setInt(1, produto.getIdProduto());
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
		             Duvida nova = new Duvida();
		             nova.setIdDuvida(rs.getInt("IdDuvida"));
		             nova.setDuvida(rs.getString("Duvida"));
		             nova.setResposta(rs.getString("Resposta"));
		             duvidas.add(nova);
		         }
		         rs.close();
		         return duvidas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
