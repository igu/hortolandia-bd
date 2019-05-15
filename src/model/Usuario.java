package model;

public class Usuario {
	
	private int IdUsuario;
	private String NomeUsuario;
	private String Senha;
	private String Nome;
	private String CPF;
	private String RG;
	private String DataNascimento;
	private String Naturalidade;
	private String Nacionalidade;
	private String Email;
	private String Logradouro;
	private String NumeroResidencia;
	private String Complemento;
	private String CEP;
	private String Cidade;
	private String Estado;
	
	public int getIdUsuario() {
		return IdUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return NomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		NomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}

	public String getNaturalidade() {
		return Naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		Naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return Nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		Nacionalidade = nacionalidade;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}

	public String getNumeroResidencia() {
		return NumeroResidencia;
	}

	public void setNumeroResidencia(String numeroResidencia) {
		NumeroResidencia = numeroResidencia;
	}

	public String getComplemento() {
		return Complemento;
	}

	public void setComplemento(String complemento) {
		Complemento = complemento;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}
	
	public String toString() {
		return getIdUsuario() + "\t\t" + getNomeUsuario();
	}
	
}