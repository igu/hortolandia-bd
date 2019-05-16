package dao;

import java.util.List;

import model.Produto;
import model.Usuario;

public interface ProdutoDAO {
	public List<Produto> listarTodosProdutos();
	public List<Produto> listarProdutosPorVendedor(int IdVendedor);
	public Produto verProdutoPorId(int IdProduto);
	public void addProduto(Produto produto, Usuario usuario);
	public void updateProduto(Produto produto);
	public void deleteProduto(Produto produto);
}
