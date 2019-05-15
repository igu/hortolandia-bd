package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO {
	public List<Usuario> listarTodosUsuarios();
	public void addUsuario(Usuario usuario);
	public void updateUsuario(Usuario usuario);
	public void deleteUsuario(Usuario usuario);
	public boolean usernameDisponivel(String nomeUsuario);
	public Usuario validarUsuario(String username, String senha);
}
