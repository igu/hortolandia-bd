package model;


public class Duvida {
	private int idDuvida;
	private String duvida;
	private String resposta;
	private Produto produto;
	private Usuario usuarioPergunta;
	private Usuario usuarioResposta;
	
	public int getIdDuvida() {
		return idDuvida;
	}
	public void setIdDuvida(int idDuvida) {
		this.idDuvida = idDuvida;
	}
	
	public String getDuvida() {
		return duvida;
	}
	public void setDuvida(String duvida) {
		this.duvida = duvida;
	}
	
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Usuario getUsuarioPergunta() {
		return usuarioPergunta;
	}
	public void setUsuarioPergunta(Usuario usuarioPergunta) {
		this.usuarioPergunta = usuarioPergunta;
	}
	
	public Usuario getUsuarioResposta() {
		return usuarioResposta;
	}
	public void setUsuarioResposta(Usuario usuarioResposta) {
		this.usuarioResposta = usuarioResposta;
	}
	
}
