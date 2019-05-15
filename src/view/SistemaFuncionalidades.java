package view;

import java.util.List;
import java.util.Scanner;

import dao.ProdutoDAO;
import dao.ProdutoImpl;
import dao.UsuarioDAO;
import dao.UsuarioImpl;
import model.Produto;
import model.Usuario;


public class SistemaFuncionalidades {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		UsuarioDAO usuariodao = new UsuarioImpl();
		ProdutoDAO produtodao = new ProdutoImpl();
		System.out.println("--- BEM VINDO A HORTOLADANDIA ---");
		
		String op;
		do {
			menu();
			op = in.nextLine();
			switch(op) {
				case "0":
					System.out.println("\n\nObrigado por utilizar o nosso sistema.");
					break;
				case "1":
					String nomeUsuario, senha, nome, CPF, RG, dataNascimento, naturalidade, nacionalidade, email, 
					logradouro, nResidencia, complemento, CEP, cidade, estado;
					Usuario n = new Usuario();
					do {
						System.out.println("Digite o nome do usuário");
						nomeUsuario = in.nextLine();
					}while(usuariodao.usernameDisponivel(nomeUsuario));
					n.setNomeUsuario(nomeUsuario);
					System.out.println("Digite sua senha");
					senha = in.nextLine();
					n.setSenha(senha);
					System.out.println("Digite o seu nome");
					nome = in.nextLine();
					n.setNome(nome);
					System.out.println("Digite o seu CPF");
					CPF = in.nextLine();
					n.setCPF(CPF);
					System.out.println("Digite o seu RG");
					RG = in.nextLine();
					n.setRG(RG);
					do {
						System.out.println("Digite sua data de nasc: DD/MM/AAAA");
						dataNascimento = in.nextLine();
					}while(!validarData(dataNascimento));
					n.setDataNascimento(formatarData(dataNascimento));
					System.out.println("Natularidade");
					naturalidade = in.nextLine();
					n.setNaturalidade(naturalidade);
					System.out.println("Nacionalidade");
					nacionalidade = in.nextLine();
					n.setNacionalidade(nacionalidade);
					System.out.println("Email");
					email = in.nextLine();
					n.setEmail(email);
					System.out.println("Logradouro");
					logradouro = in.nextLine();
					n.setLogradouro(logradouro);
					System.out.println("Número");
					nResidencia = in.nextLine();
					n.setNumeroResidencia(nResidencia);
					System.out.println("Deseja adicionar um completo? [1] - SIM / [2] - NÃO");
					complemento = in.nextLine();
					if(complemento.equals("1")) {
						System.out.println("Digite o complemento");
						complemento = in.nextLine();
						n.setComplemento(complemento);
					}
					System.out.println("CEP: XXXXX-XXX");
					CEP = in.nextLine();
					n.setCEP(CEP);
					System.out.println("Nome da sua cidade");
					cidade = in.nextLine();
					n.setCidade(cidade);
					System.out.println("Estado da sua cidade");
					estado = in.nextLine();
					n.setEstado(estado);
					usuariodao.addUsuario(n);
					break;
				case "2":
					break;
				case "3":
					String idUsuario;
					List<Usuario> usuario = usuariodao.listarTodosUsuarios();
					System.out.println("Digite o IdUsuario que deseja excluir");
					idUsuario = in.nextLine();
					for(int i = 0; i < usuario.size(); i++) {
						if(usuario.get(i).getIdUsuario() == Integer.parseInt(idUsuario)) {
							usuariodao.deleteUsuario(usuario.get(i));
							System.out.println("Usuário deletado com sucesso.\n");
							break;
						}else {
							if(i == (usuario.size() - 1)) {
								System.out.println("Este IdUsuario não existe.\n");
							}
						}
					}
					break;
				case "4":
					String nomeProduto, descricao, categoria, quantidade, preco, username, senhaUsuario;
					boolean autenticado = false;
					Usuario user = new Usuario();
					Produto novo = new Produto();
					System.out.println("Olá, antes de mais nada, responde duas perguntas pra gente?");
					do{
						System.out.println("Forneça seu username\n:");
						username = in.nextLine();
						System.out.println("Forneça sua senha\n:");
						senhaUsuario = in.nextLine();
						user = usuariodao.validarUsuario(username, senhaUsuario);
						if(user != null) autenticado = true;
					}while(!autenticado);
					
					System.out.println("Olá " + user.getNome() + "\n"
							+ "Cadastra-se o seu produto, basta preencher os campos abaixo\n"
							+ "Nome do produto");
					nomeProduto = in.nextLine();
					novo.setNome(nomeProduto);
					System.out.println("Descrição do produto");
					descricao = in.nextLine();
					novo.setDescricao(descricao);
					System.out.println("Quantidade");
					quantidade = in.nextLine();
					// ADICIONAR UMA EXCEÇÃO DE QUANTIDADE
					novo.setQuantidade(Integer.parseInt(quantidade));
					System.out.println("Preco");
					preco = in.nextLine();
					// ADICIONAR UMA EXCEÇÃO DE PREÇO
					novo.setPreco(Double.parseDouble(preco));
					produtodao.addProduto(novo, user);
					break;
				case "5":
					break;
				case "6":
					String IdProduto;
					List<Produto> produto = produtodao.listarTodosProdutos();
					System.out.println("Digite o IdProduto que deseja excluir");
					IdProduto = in.nextLine();
					for(int i = 0; i < produto.size(); i++) {
						if(produto.get(i).getIdProduto() == Integer.parseInt(IdProduto)) {
							produtodao.deleteProduto(produto.get(i));
							System.out.println("Produto deletado com sucesso.\n");
							break;
						}else {
							if(i == (produto.size() - 1)) {
								System.out.println("Este IdProduto não existe.\n");
							}
						}
					}
					break;
				case "7":
					break;
				case "8":
					break;
				case "9":
					break;
				case "10":
					List<Usuario> usuarios = usuariodao.listarTodosUsuarios();
					System.out.println("IdUsuario\tUsername");
					for(int i = 0; i < usuarios.size(); i++) {
						System.out.println(usuarios.get(i).toString());
					}
					break;
				case "11":
					List<Produto> produtos = produtodao.listarTodosProdutos();
					System.out.println("Qtd\tPreco\tNome");
					for(int i = 0; i < produtos.size(); i++) {
						System.out.println(produtos.get(i).toString());
					}
					break;
				case "12":
					break;
				case "13":
					break;
				case "14":
					break;
				case "15":
					break;
				default:
					System.out.println("\n\nOpção inválida, vamos tentar novamente.\n\n");
			}
			
		}while(!(op.equals("0")));
		

	}
	
	public static void menu() {
		System.out.println("**** MENU ****\n"
				+ "[1] Adicionar Usuário\n"
				+ "[2] Editar Usuário\n"
				+ "[3] Deletar Usuário\n"
				+ "[4] Adicionar Produto\n"
				+ "[5] Editar Produto\n"
				+ "[6] Deletar Produto\n"
				+ "[7] Adicionar Compra\n"
				+ "[8] Adicionar Dúvida\n"
				+ "[9] Responder Dúvida\n"
				+ "[10] Listar todos os usuários\n"
				+ "[11] Listar todas as ofertas\n"
				+ "[12] Listar compras realizadas\n"
				+ "[13] Listas Dúvidas e respostas do Produto\n"
				+ "[14] Procurar ofertas por Nome\n"
				+ "[15] Listar Produtos + Vendidos\n:");
	}

	public static boolean validarData(String data) {
		if(data.length() != 10) return false;
		if(Integer.parseInt(data.charAt(0) + "" + data.charAt(1)) < 1 || Integer.parseInt(data.charAt(0) + "" + data.charAt(1)) > 31) return false;
		if(Integer.parseInt(data.charAt(3) + "" + data.charAt(4)) < 1 || Integer.parseInt(data.charAt(3) + "" + data.charAt(4)) > 12) return false;
		return true;
	}
	
	public static String formatarData(String data) {
		String novaData = "";
		novaData += String.valueOf(data.charAt(6) + "" + data.charAt(7) + "" + data.charAt(8) + "" + data.charAt(9)); // ANO
		novaData += "-" + String.valueOf(data.charAt(3) + "" + data.charAt(4)); // MES
		novaData += "-" + String.valueOf(data.charAt(0) + "" + data.charAt(1)); // DIA
		return novaData;
	}
}
