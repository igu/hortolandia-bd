package model;

public class ProdutoComprado {
	
	private Produto produto;
	private int quantidade;

	public int getQuantidade() {
		return quantidade;
	}

	public double getPreco() {
		return getProduto().getPreco();
	}
	
	public double getTotal() {
		return getPreco()*getQuantidade();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
