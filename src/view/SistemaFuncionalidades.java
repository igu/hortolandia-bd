package view;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.CompraDAO;
import dao.CompraImpl;
import dao.ProdutoDAO;
import dao.ProdutoImpl;
import dao.UsuarioDAO;
import dao.UsuarioImpl;
import model.Produto;
import model.ProdutoComprado;
import model.Usuario;


public class SistemaFuncionalidades {

	
	static UsuarioDAO usuariodao = new UsuarioImpl();
	static ProdutoDAO produtodao = new ProdutoImpl();
	static CompraDAO compradao = new CompraImpl();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String op;
		do {
			menu();
			System.out.print("Opcao -> ");
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
					boolean auth = false;
					String user_name, password, newPassoword, opUpdate, novoNome, novoUsername, 
					novaDataNasc, novoEmail, novoEstado, novaCidade, novoCEP,
					novoLogradouro, novoComplemento, novoNumeroResidencial, contUpdate = "";
					Usuario updateUser = new Usuario();
					System.out.println("Antes de mais nada, precisamos saber quem é você.");
					do{
						System.out.println("Forneça seu username\n:");
						user_name = in.nextLine();
						System.out.println("Forneça sua senha\n:");
						password = in.nextLine();
						updateUser = usuariodao.validarUsuario(user_name, password);
						if(updateUser != null) auth = true;
					}while(!auth);
					System.out.println("Olá, " + updateUser.getNome() + 
							"\nMarque [1] Para o que deseja alterar\n"
							+ "[0] Para o que NÃO deseja alterar\n"
							+ "(*) Qualquer outra tecla será considerada como NÃO");
					System.out.println("Deseja alterar seu nome?\n[1] - SIM / [0] - NÃO");
					opUpdate = in.nextLine();
					if(opUpdate.equals("1")) {
						System.out.println("Digite o novo nome");
						novoNome = in.nextLine();
						updateUser.setNome(novoNome);
						System.out.println("Nome alterado com sucesso, deseja continuar alterando?\n"
								+ "[1] - SIM"
								+ "[0] - NÃO");
						contUpdate = in.nextLine();
					}
					if(!contUpdate.equals("1")) {
						usuariodao.updateUsuario(updateUser);
						break;
					}
					System.out.println("Deseja alterar seu NomeDeUsuario?\n[1] - SIM\n[0] - NÃO");
					opUpdate = in.nextLine();
					if(opUpdate.equals("1")) {
						do {
							System.out.println("Digite o novo nome do usuário");
							novoUsername = in.nextLine();
						}while(usuariodao.usernameDisponivel(novoUsername));
						updateUser.setNomeUsuario(novoUsername);
						System.out.println("NomeDeUsuario alterado com sucesso, deseja continuar alterando?\n"
								+ "[1] - SIM"
								+ "[0] - NÃO");
						contUpdate = in.nextLine();
					}
					if(!contUpdate.equals("1")) {
						usuariodao.updateUsuario(updateUser);
						break;
					}
					System.out.println("Deseja alterar sua senha?\n[1] - SIM\n[0] - NÃO");
					opUpdate = in.nextLine();
					if(opUpdate.equals("1")) {
						System.out.println("Digite a nova senha");
						newPassoword = in.nextLine();
						updateUser.setSenha(newPassoword);
						System.out.println("Seja alterada com sucesso, deseja continuar alterando?\n[1] - SIM\n[0] - NÃO");
						contUpdate = in.nextLine();
					}
					if(!contUpdate.equals("1")) {
						usuariodao.updateUsuario(updateUser);
						break;
					}
					System.out.println("Deseja alterar sua data de nascimento?\n[1] - SIM / [0] - NÃO");
					opUpdate = in.nextLine();
					if(opUpdate.equals("1")) {
						do {
							System.out.println("Digite sua nova data de nascimento: DD/MM/AAAA");
							novaDataNasc = in.nextLine();
						}while(!validarData(novaDataNasc));
						updateUser.setDataNascimento(formatarData(novaDataNasc));
						System.out.println("Sua data de nascimento foi alterada, deseja continuar alterando?\n"
								+ "[1] - SIM\n"
								+ "[0] - NÃO");
						contUpdate = in.nextLine();
					}
					if(!contUpdate.equals("1")) {
						usuariodao.updateUsuario(updateUser);
						break;
					}
					System.out.println("Deseja alterar seu email?\n[1] - SIM / [0] - NÃO");
					opUpdate = in.nextLine();
					if(opUpdate.equals("1")) {
						System.out.println("Digite seu novo e-mail");
						novoEmail = in.nextLine();
						updateUser.setEmail(novoEmail);
						System.out.println("E-mail alterado com sucesso, deseja continuar alterando?\n"
								+ "[1] - SIM\n"
								+ "[0] - NÃO");
						contUpdate = in.nextLine();
					}
					if(!contUpdate.equals("1")) {
						usuariodao.updateUsuario(updateUser);
						break;
					}
					System.out.println("Deseja alterar seu estado?\n[1] - SIM\n[0] - NÃO");
					opUpdate = in.nextLine();
					if(opUpdate.equals("1")) {
						do {
							System.out.println("Digite a SIGLA do seu novo estado");
							novoEstado = in.nextLine();
						}while(novoEstado.length() != 2);
						updateUser.setEstado(novoEstado);
						System.out.println("Agora, você precisa alterar sua cidade");
						novaCidade = in.nextLine();
						updateUser.setCidade(novaCidade);
						System.out.println("Agora, você precisa alterar o seu CEP");
						novoCEP = in.nextLine();
						updateUser.setCEP(novoCEP);
						System.out.println("Agora, altere o seu logradouro");
						novoLogradouro = in.nextLine();
						updateUser.setLogradouro(novoLogradouro);
						System.out.println("Agora, altere o número da sua residência");
						novoNumeroResidencial = in.nextLine();
						updateUser.setNumeroResidencia(novoNumeroResidencial);
						if(updateUser.getComplemento() == null) {
							System.out.println("Verificamos que você não adicionou um complemento, deseja adicionar agora?\n[1] - SIM\n[2] - NAO");
							contUpdate = in.nextLine();
							if(contUpdate.equals("1")) {
								System.out.println("Digite o complemento");
								novoComplemento = in.nextLine();
								updateUser.setComplemento(novoComplemento);
							}
						}
						System.out.println("Uau, você chegou até, não existe mais nenhum dado para ser alterado!");
						contUpdate = "0";
					}
					if(!contUpdate.equals("1")) {
						usuariodao.updateUsuario(updateUser);
						break;
					}
					System.out.println("Deseja alterar sua cidade?\n[1] - SIM\n[2] - NÃO");
					opUpdate = in.nextLine();
					if(opUpdate.equals("1")) {
						System.out.println("Digite o nome da sua nova cidade");
						novaCidade = in.nextLine();
						updateUser.setCidade(novaCidade);
						System.out.println("Agora, você precisa alterar o seu CEP");
						novoCEP = in.nextLine();
						updateUser.setCEP(novoCEP);
						System.out.println("Agora, altere o seu logradouro");
						novoLogradouro = in.nextLine();
						updateUser.setLogradouro(novoLogradouro);
						System.out.println("Agora, altere o número da sua residência");
						novoNumeroResidencial = in.nextLine();
						updateUser.setNumeroResidencia(novoNumeroResidencial);
						if(updateUser.getComplemento().isEmpty()) {
							System.out.println("Verificamos que você não adicionou um complemento, deseja adicionar agora?\n[1] - SIM\n[2] - NAO");
							contUpdate = in.nextLine();
							if(contUpdate.equals("1")) {
								System.out.println("Digite o complemento");
								novoComplemento = in.nextLine();
								updateUser.setComplemento(novoComplemento);
							}
						}
						System.out.println("Uau, você chegou até, não existe mais nenhum dado para ser alterado!");
						contUpdate = "0";
					}
					if(!contUpdate.equals("1")) {
						usuariodao.updateUsuario(updateUser);
						break;
					}
					System.out.println("Deseja alterar seu Logradouro?\n[1] - SIM\n[2] - NÃO");
					opUpdate = in.nextLine();
					if(opUpdate.equals("1")) {
						System.out.println("Digite o nome do seu novo Logradouro");
						novoLogradouro = in.nextLine();
						updateUser.setLogradouro(novoLogradouro);
						System.out.println("Agora, altere o número da sua residência");
						novoNumeroResidencial = in.nextLine();
						updateUser.setNumeroResidencia(novoNumeroResidencial);
						if(updateUser.getComplemento().isEmpty()) {
							System.out.println("Verificamos que você não adicionou um complemento, deseja adicionar agora?\n[1] - SIM\n[2] - NAO");
							contUpdate = in.nextLine();
							if(contUpdate.equals("1")) {
								System.out.println("Digite o complemento");
								novoComplemento = in.nextLine();
								updateUser.setComplemento(novoComplemento);
							}
						}
						System.out.println("Uau, você chegou até, não existe mais nenhum dado para ser alterado!");
						contUpdate = "0";
					}
					usuariodao.updateUsuario(updateUser);
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
					boolean authProdutor = false;
					Usuario produtor = new Usuario();
					Produto produtoUpdate = new Produto();
					String IdProdutoProdutor, novoNomeProduto, opProduto, novaDescricao,
					novaCategoria, novaQuantidade, novoPreco, opContProduto = "";
					System.out.println("Olá, antes de mais nada, responde duas perguntas pra gente?");
					do{
						System.out.println("Forneça seu username");
						username = in.nextLine();
						System.out.println("Forneça sua senha");
						senhaUsuario = in.nextLine();
						produtor = usuariodao.validarUsuario(username, senhaUsuario);
						if(produtor != null) authProdutor = true;
					}while(!authProdutor);
					System.out.println("Olá, " + produtor.getNome());
					System.out.println("Separamos uma lista com todos os seus produtos");
					List<Produto> produtoOfertados = produtodao.listarProdutosPorVendedor(produtor.getIdUsuario());
					System.out.println("Id\tQtd\tPreco\tNome");
					for(int i = 0; i < produtoOfertados.size(); i++) {
						System.out.println(produtoOfertados.get(i).getIdProduto() + "\t"+ produtoOfertados.get(i).toString());
					}
					do {
						System.out.println("Digite a ID do produto que deseja editar");
						IdProdutoProdutor = in.nextLine();
					}while(produtodao.verProdutoPorId(Integer.parseInt(IdProdutoProdutor)) == null); // FALHA DE SEGURANÇA TRY CATCH
					produtoUpdate = produtodao.verProdutoPorId(Integer.parseInt(IdProdutoProdutor));
					System.out.println("Deseja alterar o nome do Produto?\n[1] - SIM\n[0] - NÃO");
					opProduto = in.nextLine();
					if(opProduto.equals("1")) {
						System.out.println("Digite o novo nome do produto");
						novoNomeProduto = in.nextLine();
						produtoUpdate.setNome(novoNomeProduto);
						System.out.println("Deseja continuar alterando?\n[1] - SIM\n[0] - NÃO");
						opContProduto = in.nextLine();
					}
					if(!opContProduto.equals("1")) {
						produtodao.updateProduto(produtoUpdate);
						break;
					}
					System.out.println("Deseja alterar a descrição?\n[1] - SIM\n[0] - NÃO");
					opProduto = in.nextLine();
					if(opProduto.equals("1")) {
						System.out.println("Digite a nova descrição");
						novaDescricao = in.nextLine();
						produtoUpdate.setDescricao(novaDescricao);
						System.out.println("Deseja continuar alterando?[1] - SIM\n[0] - NÃO");
						opContProduto = in.nextLine();
					}
					if(!opContProduto.equals("1")) {
						produtodao.updateProduto(produtoUpdate);
						break;
					}
					System.out.println("Deseja alterar a categoria?\n[1] - SIM\n[0] - NÃO");
					opProduto = in.nextLine();
					if(opProduto.equals("1")) {
						System.out.println("Digite a nova categoria");
						novaCategoria = in.nextLine();
						produtoUpdate.setCategoria(novaCategoria);
						System.out.println("Deseja continuar alterando?[1] - SIM\n[0] - NÃO");
						opContProduto = in.nextLine();
					}
					System.out.println("Deseja alterar a quantidade?\n[1] - SIM\n[0] - NÃO");
					opProduto = in.nextLine();
					if(opProduto.equals("1")) {
						do {
							System.out.println("Digite a nova quantidade");
							novaQuantidade = in.nextLine();
						}while(Integer.parseInt(novaQuantidade) <= 0);
						produtoUpdate.setQuantidade(Integer.parseInt(novaQuantidade)); // TRY CATCH
						System.out.println("Deseja continuar alterando?\n[1] - SIM\n[0] - NÃO");
						opContProduto = in.nextLine();
					}
					if(!opContProduto.equals("1")) {
						produtodao.updateProduto(produtoUpdate);
						break;
					}
					System.out.println("Deseja alterar o preco?\n[1] - SIM\n[2] - NÃO");
					opProduto = in.nextLine();
					if(opProduto.equals("1")) {
						do {
							System.out.println("Digite o novo preço");
							novoPreco = in.nextLine();
						}while(Double.parseDouble(novoPreco) <= 0.00);
						produtoUpdate.setPreco(Double.parseDouble(novoPreco));
					}
					System.out.println("Gravando suas informações no banco...");
					produtodao.updateProduto(produtoUpdate);
					System.out.println("Informações gravadas no banco...");
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
					List<ProdutoComprado> listaProdutos = new ArrayList<ProdutoComprado>();
					Produto escolhaProduto = new Produto();
					Usuario usuarioComprador = new Usuario();
					boolean authUserComprador = false;
					String IdProdutoCompra, qtdCompra, opContCompra;
					do {
						ProdutoComprado produtoComprado = new ProdutoComprado();
						do {
							produtosDisponiveis();
							System.out.println("Qual produto deseja comprar? Digite a ID"); //EM UM CENARIO QUE O USUARIO NUNCA DIGITARA LETRA
							IdProdutoCompra = in.nextLine();
							escolhaProduto = produtodao.verProdutoPorId(Integer.parseInt(IdProdutoCompra));
						}while(escolhaProduto == null);
						do {
							System.out.println("Digite a quantidade");
							qtdCompra = in.nextLine();
						}while(Integer.parseInt(qtdCompra) < 0 || Integer.parseInt(qtdCompra) > escolhaProduto.getQuantidade());
						produtoComprado.setProduto(escolhaProduto);
						produtoComprado.setQuantidade(Integer.parseInt(qtdCompra));
						listaProdutos.add(produtoComprado);
						System.out.println("Deseja continuar comprando?\n[1] - SIM\n[0] - NÃO");
						opContCompra = in.nextLine();
					}while(opContCompra.equals("1"));
					System.out.println("Antes de concluir sua compra, tá faltando você nos dizer quem é");
					do{
						System.out.println("Forneça seu username");
						username = in.nextLine();
						System.out.println("Forneça sua senha");
						senhaUsuario = in.nextLine();
						usuarioComprador = usuariodao.validarUsuario(username, senhaUsuario);
						if(usuarioComprador != null) authUserComprador = true;
					}while(!authUserComprador);
					System.out.println("Olá, " + usuarioComprador.getNome());
					compradao.addCompra(listaProdutos, usuarioComprador.getIdUsuario());
					System.out.println("Compra realizada com sucesso...");
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
					produtosDisponiveis();
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

		System.out.println("\n\n### HORTOLANDIA - Sistema para vendas de produtos organicos ###");
		System.out.println("                                  M-E-N-U                ");
		System.out.println("                  =======================================");
		System.out.println("                  |     1 -  Adicionar Usuário          |");
		System.out.println("                  |     2 -  Editar Usuário             |");
		System.out.println("                  |     3 -  Deletar Usuário            |");
		System.out.println("                  |     4 -  Adicionar Produto          |");
		System.out.println("                  |     5 -  Editar Produto             |");
		System.out.println("                  |     6 -  Deletar Produto            |");
		System.out.println("                  |     7 -  Adicionar Compra           |");
		System.out.println("                  |     8 -  Adicionar Dúvida           |");
		System.out.println("                  |     9 -  Responder Dúvida           |");
		System.out.println("                  |     10 - Listar Usuários            |");
		System.out.println("                  |     11 - Listar Ofertas             |");
		System.out.println("                  |     12 - Listar Compras             |");
		System.out.println("                  |     13 - Listar Dúvidas/Respostas   |");
		System.out.println("                  |     14 - Procurar Ofertas p/ Nome   |");
		System.out.println("                  |     15 - Produtos mais vendidos     |");
		System.out.println("                  |     0  - Sair                       |");
		System.out.println("                  =======================================\n");
		System.out.print("\n");

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
	
	public static void produtosDisponiveis() {
		List<Produto> produtos = produtodao.listarTodosProdutos();
		System.out.println("Qtd\tPreco\tNome");
		for(int i = 0; i < produtos.size(); i++) {
			System.out.println(produtos.get(i).toString());
		}
	}
}
