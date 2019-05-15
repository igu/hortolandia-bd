package model;

public class Compra {
	private int idCompra;
	private String data;
	private double valor;
	private int idComprador;
	
	public int getIdComprador() {
		return idComprador;
	}
	
	public void setIdComprador(int idComprador) {
		this.idComprador = idComprador;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
}
