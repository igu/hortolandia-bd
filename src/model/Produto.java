package model;

public class Produto {
	private int IdProduto;
	private String Nome;
	private String Descricao;
	private String Categoria;
	private int Quantidade;
	private double Preco;
	
	
	public int getIdProduto() {
		return IdProduto;
	}
	
	public void setIdProduto(int idProduto) {
		IdProduto = idProduto;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	
	public String getDescricao() {
		return Descricao;
	}
	
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	public String getCategoria() {
		return Categoria;
	}
	
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	
	public int getQuantidade() {
		return Quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	
	public double getPreco() {
		return Preco;
	}
	
	public void setPreco(double preco) {
		Preco = preco;
	}
	
	public String toString() {
		return getIdProduto() + "\t" + getQuantidade() + "\t" + getPreco() + "\t" + getNome();
	}
	
}
