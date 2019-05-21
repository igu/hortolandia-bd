package dao;

import java.util.List;

import model.Compra;
import model.ProdutoComprado;

public interface CompraDAO {
	public int addCompra(List<ProdutoComprado> ProdutoComprado, int IdUsuario);
	public int addListaCompra(List<ProdutoComprado> ProdutoComprado, int IdCompra);
	public int removerQuantidadeComprada(List<ProdutoComprado> ProdutoComprado);
	public String getDateTime();
	public Compra buscarIdCompra(String data);
	public double getValorTotal(List<ProdutoComprado> ProdutoComprado);
}
