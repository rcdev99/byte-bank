package br.com.alura.model;

import br.com.alura.util.ValidadorUtil;

/**
 * Classe abstrata que representa a moldura de um funcion�rio no projeto Bytebank.
 * 
 * @author RicardoJ�nior
 * @version 0.1
 * */
public abstract class AbstractFuncionario extends AbstractPessoa {
	
	private double salario;
	private int matricula;
	private String funcao;
	private static int qtdFuncionarios;
	private static int sequencialFunc = 700000;
	protected ValidadorUtil validador = new ValidadorUtil();
	
	/**
	 * Construtor da clase funcion�rio onde:
	 * 
	 * @param nome - � uma string que refere-se ao nome do funcion�rio.
	 * @param sobrenome - � uma string que refere-se ao sobrenome do funcion�rio.
	 * @param salario - Vari�vel do tipo double que refere-se ao sal�rio do funcion�rio.  
	 * */
	public AbstractFuncionario(String nome, String sobrenome, double salario) {
		//Verifica poss�veis exce��es 
		validador.validaString(nome);
		validador.validaString(sobrenome);
		validador.validaValores(salario);
		
		//Itera atributos sequenciais
		qtdFuncionarios ++;
		sequencialFunc ++;
		
		//instancia os atributos com as informa��es necess�rias para a cria��o do funcion�rio.
		super.setNome(nome);
		this.setSobrenome(sobrenome);
		this.salario = salario;
		this.matricula = sequencialFunc;
		
	}
	/**
	 * M�todo abstrato para obter-se a bonifica��o de um funcion�rio
	 * @return double Retorna a bonifica��o do Funcionario
	 * */
	public abstract double getBonificacao();

	//Getters e Setters
	/**
	 * M�todo utilizado para obter-se o sal�rio de um determinado funcion�rio.
	 * @return salario Atributo do tipo double referente ao sal�rio do funcion�rio.
	 * */
	public double getSalario() {
		return salario;
	}
	/***
	 * M�todo utilizado para definir o sal�rio de um determinado funcion�rio.
	 * @param salario Atributo do tipo double referente ao sal�rio do funcion�rio.
	 * @param ger Atributo do tipo Gerente para valida��o da modifica��o.
	 * @param senhaGer Senha do gerente para o processo de autentica��o.
	 */
	public void setSalario(double salario, Gerente ger, String senhaGer) {	
		if(ger.autentica(senhaGer)) {
			validador.validaValores(salario);
			this.salario = salario;
		}else {
			System.out.println("Falha na autentica��o !");
		}
	}
	/**
	 * M�todo utilizado para obter-se a matr�cula de um determinado funcion�rio.
	 * @return matricula Atributo do tipo int referente a matr�cula do funcion�rio.
	 * */
	public int getMatricula() {
		return matricula;
	}
	/**
	 * M�todo utilizado para obter-se a quantidade de funcion�rio cadastrados.
	 * @return qtdFuncionarios Atributo do int que indica a quantidade de funcion�rios.
	 * */
	public static int getQtdFuncionarios() {
		return qtdFuncionarios;
	}
	/**
	 * M�todo utilizado para obter-se o valor atual do gerador de n�meros sequenciais para o cadastro de funcion�rio.
	 * @return sequencialFunc Atributo do tipo int referente ao n�mero sequencial atualmente utilizado para a gera��o de identificadores funcion�rios.
	 * */
	public static int getSequencialFunc() {
		return sequencialFunc;
	}
	/**
	 * M�todo utilizado para obter-se a fun��o de um determinado funcion�rio.
	 * @return funcao Atributo do tipo String referente a fun��o do funcion�rio.
	 * */
	public  String getFuncao() {
		return funcao;
	}
	/***
	 * M�todo utilizado para definir a fun��o de um determinado funcion�rio.
	 * @param funcao Atributo do tipo String referente a fun��o do funcion�rio.
	 * @param ger Atibuto do tipo Gerente para autentica��o do processo.
	 * @param senhaGer Senha do Gerente para o processo de autentica��o.
	 */
	public void setFuncao(String funcao, Gerente ger, String senhaGer) {
		if(ger.autentica(senhaGer)) {
			validador.validaString(funcao);
			this.funcao = funcao;
		}else {
			System.out.println("Falha na autentica��o !");
		}
		
	}
	/***
	 * M�todo ##TEMPOR�RIO## para inserir fun��o.
	 * @param funcao
	 */
	public void setFuncao(String funcao) {
		validador.validaString(funcao);
		this.funcao = funcao;
	}
	

}//class
