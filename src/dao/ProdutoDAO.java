package dao;

import java.util.List;

import model.Produto;
import model.Usuario;

public interface ProdutoDAO {
	/* ===
	   = 11: ListarTodasOfertas
	   ===
	 */
	public List<Produto> listarTodosProdutos();
	public List<Produto> listarProdutosPorVendedor(int IdVendedor);
	/* ===
	   = 14: ProcurarProdutosPorNome
	   ===
	 */
	public List<Produto> procurarProdutosPorNome(String nome);
	public Produto verProdutoPorId(int IdProduto);
	/* ===
	   = 4: AdicionarProduto
	   ===
	 */
	public void addProduto(Produto produto, Usuario usuario);
	/* ===
	   = 5: EditarProduto
	   ===
	 */
	public void updateProduto(Produto produto);
	/* ===
	   = 6: DeletarProduto
	   ===
	 */
	public void deleteProduto(Produto produto);
	/* ===
	   = 15: ProdutoMaisVendido
	   ===
	 */
	public Produto produtoMaisVendido();
}
