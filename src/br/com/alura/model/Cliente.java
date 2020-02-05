package br.com.alura.model;

import java.util.ArrayList;

import br.com.alura.util.AutenticacaoUtil;

/**
 * Classe utilizada para representar o cliente no projeto Bytebank
 * 
 * @author RicardoJúnior
 * @version 0.1
 * */
public class Cliente extends AbstractPessoa implements IAutenticavel, Comparable<Cliente> {
	
	
	private AutenticacaoUtil autenticador;
	private ArrayList<AbstractConta> contas = new ArrayList<AbstractConta>();
	private int identificador;
	private static int identificadorSeq  = 600000; 
	
	
	public String toString() {
		return "Cliente: " + super.getNome() + " " + super.getSobrenome() + "\nID: " + identificador + " CPF: " + super.getCpf();
	}
	
	/**
	 * Método construtor da classe cliente que força o cadastramento de uma senha.
	 * @param senha - String contendo a senha que será utilizada pelo cliente para acesso ao sistema.
	 * */
	public Cliente(String senha) {
		autenticador = new AutenticacaoUtil(senha);
		identificadorSeq++;
		identificador = identificadorSeq;
	}
	
	//Implemetações
	/**
	 * Método utilizado para alterar a senha de um cliente, onde:
	 * @param antiga - String que representa a senha atual do cliente.
	 * @param nova - String que representa a senha que está sendo criada. 
	 * @return boolean - Retorna 'true' caso não encontre obstruções na modificação da senha ou 'false' caso ocorra alguma problema na execução.
	 * */
	@Override
	public boolean alterarSenha(String antiga, String nova) {
		return autenticador.alterarSenha(antiga, nova);
	}
	/**
	 * Método utilizado para autenticação da senha do cliente, onde:
	 * @param senha - String que representa a senha pessoal e instransferível utilizada pelo cliente.
	 * @return boolean - Retorna 'true' caso a senha seja autentica ou 'false' em caso de inconsistência. 
	 * */
	@Override
	public boolean autentica(String senha) {
		return autenticador.autentica(senha);
	}
	/**
	 * Método utilizado para vincular uma conta ao cliente.
	 * @param conta
	 */
	public String abrirConta(AbstractConta conta) {
		for (AbstractConta minhasContas : contas) {
			if(minhasContas.getNumero() == conta.getNumero()) {
				return "Conta já cadastrada!";
			}
		}
		contas.add(conta);
		return("Conta Cadastrada com sucesso!");
	}
	
	/**
	 * Método para facilitar o processo de alteração de dados cadastrais.
	 * @param cliente
	 */
	public void alterarDadosCadastrais(Cliente cliente) {
		
		super.setNome(cliente.getNome());
		super.setSobrenome(cliente.getSobrenome());
		super.setCpf(cliente.getCpf());
		super.setRg(cliente.getRg());
		super.setGenero(cliente.getGenero());
		super.setEndereco(cliente.getEndereco());
	}
	/**
	 * Método utilizado para se obter ovalor atual do sequencial que gera o identificador de clientes
	 * @return
	 */
	public static int getIdentificadorSeq() {
		return identificadorSeq;
	}
	public int getIdenticador() {
		return this.identificador;
	}
	//Implementação da interface Comparable
	@Override
	public int compareTo(Cliente outroCli) {
		return Integer.compare(this.identificador, outroCli.identificador);
	}
	/***
	 * Método para obter as contas do cliente
	 * @return
	 */
	public ArrayList<AbstractConta> getContas() {
		
		return this.contas ;
	}
	/**
	 * Método utilizado para lstar as constas vinculadas ao cliente.
	 */
	public void listarContas(){
		
		for (AbstractConta conta : contas) {
		
			System.out.println(conta.toString());
		}
		
	}
	/**
	 * Método utilizado para obter a quantidade de contas que o cliente possui vinculadas á ele.
	 * @return int Contendo a qtd de contas cadastradas na array do cliente
	 */
	public int getQtdContas() {
		
		return contas.size();
		
	}
	
	
	
}
