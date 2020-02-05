package br.com.alura.model;

import br.com.alura.util.ValidadorUtil;

/**
 * Classe abstrata contendo arquitetura basica para a estruturação dos usuários do sistema no projeto Bytebank.
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
	 * Método construtor da classe Pessoa.
	 * */
	public AbstractPessoa() {
		// TODO Auto-generated constructor stub
		validador = new ValidadorUtil();
	}
	
	/**
	 * Método para obtenção do nome da pessoa
	 * @return nome String contendo o nome da pessoa.
	 * */
	public String getNome() {
		return nome;
	}
	/**
	 * Método para definição do nome da pessoa
	 * @param nome String contendo o nome da pessoa.
	 * */
	public void alterarNome(String nome) {
		if(validador.validaString(nome)) {
			this.nome = nome;
		}
	}
	/**
	 * Método para definição do nome da pessoa
	 * @param nome String contendo o nome da pessoa.
	 * */
	public void setNome(String nome) {
		if(validador.validaString(nome)) {
			this.nome = nome;
		}
		
	}
	/**
	 * Método para obtenção do sobrenome da pessoa
	 * @return sobrenome String contendo o sobrenome da pessoa.
	 * */
	public String getSobrenome() {
		return sobrenome;
	}
	/**
	 * Método para definição do sobrenome da pessoa
	 * @param sobrenome String contendo o sobrenome da pessoa.
	 * */
	public void setSobrenome(String sobrenome) {
		if(validador.validaString(sobrenome)) {
			this.sobrenome = sobrenome;
		}
	}
	/**
	 * Método para obtenção do RG da pessoa
	 * @return RG String contendo o RG da pessoa.
	 * */
	public String getRg() {
		return rg;
	}
	/**
	 * Método para definição do RG da pessoa
	 * @param rg String contendo o RG da pessoa.
	 * */
	public void setRg(String rg) {
		if(validador.validaString(rg)) {
			this.rg = rg;
		}
	}
	/**
	 * Método para obtenção do CPF da pessoa
	 * @return cpf String contendo o CPF da pessoa.
	 * */
	public String getCpf() {
		return cpf;
	}
	/**
	 * Método para definição do CPF da pessoa
	 * @param cpf String contendo o CPF da pessoa.
	 * */
	public void setCpf(String cpf) {
		if(validador.validaString(cpf)) {
			this.cpf = cpf;
		}
	}
	/**
	 * Método para obtenção do gênero da pessoa
	 * @return genero String contendo o gênero da pessoa.
	 * */
	public char getGenero() {
		return genero;
	}
	/**
	 * Método para definição do gênero da pessoa
	 * @param genero String contendo o gênero da pessoa.
	 * */
	public void setGenero(char genero) {
		if (validador.validaGenero(genero)){
			this.genero = genero;
		}else {
			System.out.println("'"+ genero +"' não é um genero válido!");
		}
	}
	/**
	 * Método para obtenção do endereço da pessoa
	 * @return endereco String contendo o endereco da pessoa.
	 * */
	public Endereco getEndereco() {
		return endereco;
	}
	/**
	 * Método para definição do endereço da pessoa
	 * @param endereco String contendo o endereco da pessoa.
	 * */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
