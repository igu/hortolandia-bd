package model;

public class ProdutoComprado {
	
	private int quantidade;
	private double preco;
	private double total;
	private int IdProduto;
	private int IdCompra;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double getTotal() {
		return getPreco()*getQuantidade();
	}

	public int getIdProduto() {
		return IdProduto;
	}

	public void setIdProduto(int idProduto) {
		IdProduto = idProduto;
	}

	public int getIdCompra() {
		return IdCompra;
	}

	public void setIdCompra(int idCompra) {
		IdCompra = idCompra;
	}
}
