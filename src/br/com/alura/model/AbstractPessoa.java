package br.com.alura.model;

import br.com.alura.util.ValidadorUtil;

/**
 * Classe abstrata contendo arquitetura basica para a estrutura��o dos usu�rios do sistema no projeto Bytebank.
 * */
public abstract class AbstractPessoa extends EntidadeDominio {

	private String nome;
	private String sobrenome;
	private String rg;
	private String cpf;
	private char genero;
	private Endereco endereco;
	private ValidadorUtil validador;
	
	/**
	 * M�todo construtor da classe Pessoa.
	 * */
	public AbstractPessoa() {
		// TODO Auto-generated constructor stub
		validador = new ValidadorUtil();
	}
	
	/**
	 * M�todo para obten��o do nome da pessoa
	 * @return nome String contendo o nome da pessoa.
	 * */
	public String getNome() {
		return nome;
	}
	/**
	 * M�todo para defini��o do nome da pessoa
	 * @param nome String contendo o nome da pessoa.
	 * */
	public void alterarNome(String nome) {
		if(validador.validaString(nome)) {
			this.nome = nome;
		}
	}
	/**
	 * M�todo para defini��o do nome da pessoa
	 * @param nome String contendo o nome da pessoa.
	 * */
	public void setNome(String nome) {
		if(validador.validaString(nome)) {
			this.nome = nome;
		}
		
	}
	/**
	 * M�todo para obten��o do sobrenome da pessoa
	 * @return sobrenome String contendo o sobrenome da pessoa.
	 * */
	public String getSobrenome() {
		return sobrenome;
	}
	/**
	 * M�todo para defini��o do sobrenome da pessoa
	 * @param sobrenome String contendo o sobrenome da pessoa.
	 * */
	public void setSobrenome(String sobrenome) {
		if(validador.validaString(sobrenome)) {
			this.sobrenome = sobrenome;
		}
	}
	/**
	 * M�todo para obten��o do RG da pessoa
	 * @return RG String contendo o RG da pessoa.
	 * */
	public String getRg() {
		return rg;
	}
	/**
	 * M�todo para defini��o do RG da pessoa
	 * @param rg String contendo o RG da pessoa.
	 * */
	public void setRg(String rg) {
		if(validador.validaString(rg)) {
			this.rg = rg;
		}
	}
	/**
	 * M�todo para obten��o do CPF da pessoa
	 * @return cpf String contendo o CPF da pessoa.
	 * */
	public String getCpf() {
		return cpf;
	}
	/**
	 * M�todo para defini��o do CPF da pessoa
	 * @param cpf String contendo o CPF da pessoa.
	 * */
	public void setCpf(String cpf) {
		if(validador.validaString(cpf)) {
			this.cpf = cpf;
		}
	}
	/**
	 * M�todo para obten��o do g�nero da pessoa
	 * @return genero String contendo o g�nero da pessoa.
	 * */
	public char getGenero() {
		return genero;
	}
	/**
	 * M�todo para defini��o do g�nero da pessoa
	 * @param genero String contendo o g�nero da pessoa.
	 * */
	public void setGenero(char genero) {
		if (validador.validaGenero(genero)){
			this.genero = genero;
		}else {
			System.out.println("'"+ genero +"' n�o � um genero v�lido!");
		}
	}
	/**
	 * M�todo para obten��o do endere�o da pessoa
	 * @return endereco String contendo o endereco da pessoa.
	 * */
	public Endereco getEndereco() {
		return endereco;
	}
	/**
	 * M�todo para defini��o do endere�o da pessoa
	 * @param endereco String contendo o endereco da pessoa.
	 * */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
