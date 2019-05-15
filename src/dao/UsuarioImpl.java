package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Usuario;

public class UsuarioImpl implements UsuarioDAO {

	@Override
	public List<Usuario> listarTodosUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT * FROM usuario";
				preparedStatement = conn.prepareStatement(selectTableSQL);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
		             Usuario usuario = new Usuario();
		             usuario.setIdUsuario(rs.getInt("IdUsuario"));
		             usuario.setNomeUsuario(rs.getString("NomeUsuario"));
		             usuario.setSenha(rs.getString("senha"));
		             usuario.setNome(rs.getString("Nome"));
		             usuario.setCPF(rs.getString("CPF"));
		             usuario.setRG(rs.getString("RG"));
		             usuario.setDataNascimento(rs.getString("DataNascimento"));
		             usuario.setNaturalidade(rs.getString("Naturalidade"));
		             usuario.setEmail(rs.getString("Email"));
		             usuario.setLogradouro(rs.getString("Logradouro"));
		             usuario.setNumeroResidencia(rs.getString("NumeroResidencia"));
		             usuario.setComplemento(rs.getString("Complemento"));
		             usuario.setCEP(rs.getString("CEP"));
		             usuario.setCidade(rs.getString("Cidade"));
		             usuario.setEstado(rs.getString("Estado"));
		             usuarios.add(usuario);
		         }
		         rs.close();
		         return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addUsuario(Usuario usuario) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String insertTableSQL = "INSERT INTO Usuario (NomeUsuario,Senha,Nome,CPF,RG,DataNascimento,Naturalidade,Nacionalidade,Email,Logradouro,"
					+ "NumeroResidencia,Complemento,CEP,Cidade,Estado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				preparedStatement = conn.prepareStatement(insertTableSQL);
				preparedStatement.setString(1, usuario.getNomeUsuario());
				preparedStatement.setString(2, usuario.getSenha());
				preparedStatement.setString(3, usuario.getNome());
				preparedStatement.setString(4, usuario.getCPF());
				preparedStatement.setString(5, usuario.getRG());
				preparedStatement.setString(6, usuario.getDataNascimento());
				preparedStatement.setString(7, usuario.getNaturalidade());
				preparedStatement.setString(8, usuario.getNacionalidade());
				preparedStatement.setString(9, usuario.getEmail());
				preparedStatement.setString(10, usuario.getLogradouro());
				preparedStatement.setString(11, usuario.getNumeroResidencia());
				preparedStatement.setString(12, usuario.getComplemento());
				preparedStatement.setString(13, usuario.getCEP());
				preparedStatement.setString(14, usuario.getCidade());
				preparedStatement.setString(15, usuario.getEstado());
				int resultado = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUsuario(Usuario usuario) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "DELETE FROM Usuario WHERE IdUsuario=?";
				preparedStatement = conn.prepareStatement(selectTableSQL);
				preparedStatement.setInt(1, usuario.getIdUsuario());
				preparedStatement.executeUpdate();
			    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean usernameDisponivel(String nomeUsuario) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT * FROM Usuario WHERE NomeUsuario=?";
			preparedStatement = conn.prepareStatement(selectTableSQL);
			preparedStatement.setString(1, nomeUsuario);
			ResultSet rs = preparedStatement.executeQuery();
				if(rs != null && rs.next()) {
			        return true;
				}
			rs.close();
		    return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Usuario validarUsuario(String username, String senha) {
		PreparedStatement preparedStatement;
		Statement stm;
		Connection conn;
		try {
			conn = ProvedorConexao.getConnection();
			String selectTableSQL = "SELECT * FROM Usuario WHERE NomeUsuario=? AND Senha=?";
			preparedStatement = conn.prepareStatement(selectTableSQL);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, senha);
			ResultSet rs = preparedStatement.executeQuery();
				if(rs != null && rs.next()) {
					Usuario usuario = new Usuario();
		            usuario.setIdUsuario(rs.getInt("IdUsuario"));
		            usuario.setNome(rs.getString("Nome"));
		            return usuario;
				}
			rs.close();
		    return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
