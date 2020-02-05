package br.com.alura.controller;

import java.util.ArrayList;

import br.com.alura.model.Cliente;
import br.com.alura.model.EntidadeDominio;

public class CCliente implements IControlador {

	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	@Override
	public boolean alterar(EntidadeDominio entidade) {
		//Casting de EntidadeDominio para Cliente
		Cliente cliente = (Cliente) entidade;
		//Varrendo lista para encontrar o cliente a ser alterado
		for(Cliente c: clientes) {
			//identificando o cliente a ser alterado
			if(c.getCpf() == cliente.getCpf()) {
				//realizando as alterações permitidas
				c.alterarDadosCadastrais(cliente);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean cadastrar(EntidadeDominio entidade) {
		//Casting de EntidadeDominio para Cliente
			Cliente cliente = (Cliente) entidade;
			for(Cliente c: clientes) {
				//Verificando se o cpf cadastrado já consta no banco de dados
				if(c.getCpf() == cliente.getCpf()) {
					return true;
				}
			}	
			//Adicionando o novo cliente à base
			clientes.add(cliente);
			return false;
	}

	@Override
	public ArrayList<EntidadeDominio> consultar(int cli2) {
		
		ArrayList<EntidadeDominio> consulta = new ArrayList<EntidadeDominio>();
		
		for (Cliente cliente : clientes) {
			if(cliente.getIdenticador() == cli2) {
				consulta.add(cliente);
			}
		}
		return consulta;
	}

	@Override
	public boolean excluir(EntidadeDominio entidade) {
		//Casting de EntidadeDominio para Cliente
		Cliente cliente = (Cliente) entidade;
		for(Cliente c: clientes) {
			//Verificando se o cpf cadastrado já consta no banco de dados
			if(c.getCpf() == cliente.getCpf()) {
				clientes.remove(c);
				
				return true;
			}
			
		}	
		return false;
	}
	/**
	 * Método utilizado para listar todos os clientes cadastrados.
	 * @return ArrayList Contendo objetos do tipo Cliente
	 */
	public ArrayList<Cliente> listarTodos() {
		
		clientes.sort(new CompareClientByName());
		return clientes;
	}
	/**
	 * /**
	 * Método utilizado para possibilitar consultar de Clientes pelo nome
	 * @param name O nome a ser consultado no array
	 * @return ArrayList Contendo os objetos coerentes a busca
	 */
	public ArrayList<Cliente> consultarByName(String name) {
		
		ArrayList<Cliente> consulta = new ArrayList<Cliente>();
		
		for (Cliente cliente : clientes) {
			String fullname = cliente.getNome() + " " + cliente.getSobrenome();
			if(fullname.contains(name)) {
				consulta.add(cliente);
			}
		}
		consulta.sort(new CompareClientByName());
		return consulta;
	}

}
