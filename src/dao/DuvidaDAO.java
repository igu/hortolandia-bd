package dao;


import java.util.List;

import model.Duvida;
import model.Produto;
import model.Usuario;

public interface DuvidaDAO {
	/* ===
	   = 8: AdicionarDuvida
	   ===
	 */
	public void addDuvida(Duvida duvida);
	/* ===
	   = 9: ResponderDuvida
	   ===
	 */
	public void aswDuvida(String asw, int IdDuvida, Usuario usuarioResponde);
	/* ===
	   = 13: ListarDuvidasERespostasPorProduto
	   ===
	 */
	public List<Duvida> listarDuvidaPorProduto(Produto produto);
}
