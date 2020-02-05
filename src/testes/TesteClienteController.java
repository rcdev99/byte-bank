package testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import br.com.alura.controller.CCliente;
import br.com.alura.model.AbstractConta;
import br.com.alura.model.Cliente;
import br.com.alura.model.ContaCorrente;
import br.com.alura.model.ContaPoupanca;
import br.com.alura.model.Endereco;
import br.com.alura.model.EntidadeDominio;

public class TesteClienteController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		//Instanciando controlador
		CCliente cControl = new CCliente();
		
		//Instancias de Endereço
		Endereco end1 = new Endereco();
		end1.setBairro("Jd. Bela Vista");
		end1.setCep("08820-235");
		end1.setCidade("Mogi das Cruzes");
		end1.setComplemento("Não há");
		end1.setEstado("SP");
		end1.setLogradouro("Antonio Bóz Vidal");
		end1.setNumero(94);
		
		//Instancias de cliente para teste
		System.out.println("Inicializando instancias de clientes");
		Cliente cli1 = new Cliente("123mudar");
		cli1.setNome("Ricardo");
		cli1.setSobrenome("Rodrigues");
		cli1.setRg("41.934.653-3");
		cli1.setCpf("439.144.438-04");
		cli1.setEndereco(end1);
		cli1.setGenero('M');
		
		Cliente cli2 = new Cliente("123mudar");
		cli2.setNome("Aoberto");
		cli2.setSobrenome("Rodrigues");
		cli2.setRg("41.934.653-4");
		cli2.setCpf("439.144.438-05");
		cli2.setEndereco(end1);
		cli2.setGenero('M');
		
		Cliente cli3 = new Cliente("123mudar");
		cli3.setNome("Rondelli");
		cli3.setGenero('M');
		cli3.setSobrenome("Rodrigues");
		cli3.setRg("41.934.653-5");
		cli3.setCpf("439.144.438-06");
		cli3.setEndereco(end1);
		
		Cliente cli4 = new Cliente("123mudar");
		cli4.setNome("Jurandir");
		cli4.setGenero('M');
		cli4.setSobrenome("Rodrigues");
		cli4.setRg("41.934.653-5");
		cli4.setCpf("439.144.438-06");
		cli4.setEndereco(end1);
		
		//Instancia de contas para teste
		AbstractConta c1 = new ContaCorrente(1510, "Capunelson");
		AbstractConta c2 = new ContaPoupanca(1015, "Crediscleyton");
		cli1.abrirConta(c1);
		cli1.abrirConta(c2);
		
		//Configurando testadores
		boolean testeAlterar = false;
		boolean testeCadastrar = true;	//Em certas ocasiões é necessário para outros testes
		boolean testeConsultar = false;
		boolean testeConsultarByName = true;
		boolean testeExcluir = false;
		boolean testeOrdenador = false;
		boolean testeListarContaCli = false;
		boolean testeCAnonima = false;
		boolean testeLambda = false;
		
		
		
		
		//Testando controller - Cadastrar
		if(testeCadastrar) {
			System.out.println("--Cadastrando--\n");
			System.out.println(cControl.cadastrar(cli1));
			System.out.println(cControl.cadastrar(cli2));
			System.out.println(cControl.cadastrar(cli3));
		}
		//Testando controller - Excluir
		if(testeExcluir) {
			System.out.println("--Excluindo--\n");
			System.out.println(cControl.excluir(cli2));
		}
		
		clientes = cControl.listarTodos();
		System.out.println("\n--Listando todos--\n");
		for(Cliente c: clientes) {
			System.out.println("\n" + c);
		}
		//Testando controller - Alterar
		if(testeAlterar) {
			clientes = null;
			System.out.println("\n--Alterando--\n");
			System.out.println(cControl.alterar(cli4));
			clientes = cControl.listarTodos();
			System.out.println("Listando dnv");
			for(Cliente c: clientes) {
				System.out.println("\n" + c);
			}
		}
		//Testando ordem natural
		if(testeOrdenador) {
			System.out.println("\n--Testando ordem natural--\n");
			Collections.sort(clientes);
			for(Cliente c: clientes) {
				System.out.println("\n" + c);
			}
		}
		
		//Testando listar conta da classe cliente
		if(testeListarContaCli) {
			System.out.println("\n--Testando listar conta--\n");
			System.out.println("Qtd contas: " + cli1.getQtdContas() + "\n");
			cli1.listarContas();
		}
		
		//Testando Classe Anônima - Jeito burocrático
		if(testeCAnonima) {
			System.out.println("\n--Testando classes anônimas--\n");
			clientes.sort(new Comparator<Cliente>() {

					@Override
					public int compare(Cliente c1, Cliente c2) {
						return c1.getNome().compareTo(c2.getNome());
					}
				}
			);
			for(Cliente c: clientes) {
				System.out.println("\n" + c);
			}
		}
		
		//Testando Lambda
		if(testeLambda) {
			System.out.println("\n--Testando Lambda--\n");
			clientes.sort((c3,c4) -> Integer.compare(c3.getIdenticador(), c4.getIdenticador()));
			for(Cliente c: clientes) {
				System.out.println("\n" + c);
			}
		}
		
		//Testando Consultar
		if(testeConsultar) {
			System.out.println("\n--Testando Consultar--\n");
			
			ArrayList<Cliente> retorno = new ArrayList<Cliente>();
			
			for (EntidadeDominio cli : cControl.consultar(cli2.getIdenticador())) {
				Cliente cliente = (Cliente) cli;
				retorno.add(cliente);
				System.out.println(cliente);
			}
		}
		
		//Testando Consultar pelo nome
				if(testeConsultarByName) {
					System.out.println("\n--Testando Consultar (por nome)--\n");
					
					ArrayList<Cliente> retorno = new ArrayList<Cliente>();
					
					for (EntidadeDominio cli : cControl.consultarByName("o")){
						Cliente cliente = (Cliente) cli;
						retorno.add(cliente);
						System.out.println(cliente);
					}
				}
		
		
		
	}

}
