package br.com.alura.model;

import br.com.alura.util.ValidadorUtil;

/**
 * Classe abstrata que representa a moldura de um funcionário no projeto Bytebank.
 * 
 * @author RicardoJúnior
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
	 * Construtor da clase funcionário onde:
	 * 
	 * @param nome - É uma string que refere-se ao nome do funcionário.
	 * @param sobrenome - É uma string que refere-se ao sobrenome do funcionário.
	 * @param salario - Variável do tipo double que refere-se ao salário do funcionário.  
	 * */
	public AbstractFuncionario(String nome, String sobrenome, double salario) {
		//Verifica possíveis exceções 
		validador.validaString(nome);
		validador.validaString(sobrenome);
		validador.validaValores(salario);
		
		//Itera atributos sequenciais
		qtdFuncionarios ++;
		sequencialFunc ++;
		
		//instancia os atributos com as informações necessárias para a criação do funcionário.
		super.setNome(nome);
		this.setSobrenome(sobrenome);
		this.salario = salario;
		this.matricula = sequencialFunc;
		
	}
	/**
	 * Método abstrato para obter-se a bonificação de um funcionário
	 * @return double Retorna a bonificação do Funcionario
	 * */
	public abstract double getBonificacao();

	//Getters e Setters
	/**
	 * Método utilizado para obter-se o salário de um determinado funcionário.
	 * @return salario Atributo do tipo double referente ao salário do funcionário.
	 * */
	public double getSalario() {
		return salario;
	}
	/***
	 * Método utilizado para definir o salário de um determinado funcionário.
	 * @param salario Atributo do tipo double referente ao salário do funcionário.
	 * @param ger Atributo do tipo Gerente para validação da modificação.
	 * @param senhaGer Senha do gerente para o processo de autenticação.
	 */
	public void setSalario(double salario, Gerente ger, String senhaGer) {	
		if(ger.autentica(senhaGer)) {
			validador.validaValores(salario);
			this.salario = salario;
		}else {
			System.out.println("Falha na autenticação !");
		}
	}
	/**
	 * Método utilizado para obter-se a matrícula de um determinado funcionário.
	 * @return matricula Atributo do tipo int referente a matrícula do funcionário.
	 * */
	public int getMatricula() {
		return matricula;
	}
	/**
	 * Método utilizado para obter-se a quantidade de funcionário cadastrados.
	 * @return qtdFuncionarios Atributo do int que indica a quantidade de funcionários.
	 * */
	public static int getQtdFuncionarios() {
		return qtdFuncionarios;
	}
	/**
	 * Método utilizado para obter-se o valor atual do gerador de números sequenciais para o cadastro de funcionário.
	 * @return sequencialFunc Atributo do tipo int referente ao número sequencial atualmente utilizado para a geração de identificadores funcionários.
	 * */
	public static int getSequencialFunc() {
		return sequencialFunc;
	}
	/**
	 * Método utilizado para obter-se a função de um determinado funcionário.
	 * @return funcao Atributo do tipo String referente a função do funcionário.
	 * */
	public  String getFuncao() {
		return funcao;
	}
	/***
	 * Método utilizado para definir a função de um determinado funcionário.
	 * @param funcao Atributo do tipo String referente a função do funcionário.
	 * @param ger Atibuto do tipo Gerente para autenticação do processo.
	 * @param senhaGer Senha do Gerente para o processo de autenticação.
	 */
	public void setFuncao(String funcao, Gerente ger, String senhaGer) {
		if(ger.autentica(senhaGer)) {
			validador.validaString(funcao);
			this.funcao = funcao;
		}else {
			System.out.println("Falha na autenticação !");
		}
		
	}
	/***
	 * Método ##TEMPORÁRIO## para inserir função.
	 * @param funcao
	 */
	public void setFuncao(String funcao) {
		validador.validaString(funcao);
		this.funcao = funcao;
	}
	

}//class
