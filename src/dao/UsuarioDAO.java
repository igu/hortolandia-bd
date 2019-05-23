package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO {
	/* ===
	   = 10: ListarTodosUsuarios
	   === 
	 */
	public List<Usuario> listarTodosUsuarios();
	/* ===
	   = 1: AdicionarUsuário
	   ===
	 */
	public void addUsuario(Usuario usuario);
	/* ===
	   = 2: EditarUsuário
	   ===
	 */
	public void updateUsuario(Usuario usuario);
	/* ===
	   = 3: DeletarUsuário
	   ===
	 */
	public void deleteUsuario(Usuario usuario);
	public boolean usernameDisponivel(String nomeUsuario);
	public Usuario validarUsuario(String username, String senha);
}
