package dao;

import java.util.List;

import model.ProdutoComprado;

public interface CompraDAO {
	public void addCompra(List<ProdutoComprado> ProdutoComprado, int IdUsuario);
}
