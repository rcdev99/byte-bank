package br.com.alura.model;

import br.com.alura.exception.SaldoInsuficienteException;
import br.com.alura.util.ValidadorUtil;

/**
 * Classe abstrata que representa a moldura de uma conta no projeto Bytebank.
 * 
 * @author RicardoJ�nior
 * @version 0.1
 * */
public abstract class AbstractConta extends EntidadeDominio implements Comparable<AbstractConta> {

	private double saldo;
	private int agencia;
	private long numero;
	private String titular;
	private static int totalContas;
	private static long sequencialContas = 100000000l;
	private ValidadorUtil validador = new ValidadorUtil();
	
	/**
	 * M�todo construtor da classe conta, onde:
	 * 
	 * @param agencia atributo do tipo int que representa o n�mero da ag�ncia.
	 * @param titular String que representa o titular da conta.
	 * */
	public AbstractConta(int agencia, String titular) {
		//Verifica poss�veis exce��es
		validador.validaNumero(agencia);
		validador.validaString(titular);
		//itera o total e o sequencial de contas
		totalContas++;
		sequencialContas++;
		//instancia os atributos com as informa��es necess�rias para a cria��o da conta.
		this.saldo = 0;
		this.agencia = agencia;
		this.numero = sequencialContas;
		this.titular = titular;
		
		System.out.println("Conta criada com sucesso !");
	}
	/**
	 * M�todo respons�vel por dep�sitos na conta, onde:
	 * @param valor Refere-se ao valor que est� sendo depositado.
	 * */
	public void depositar(double valor) {
			if(validador.validaValores(valor)) {
				saldo += valor;
			}
		}
	/**
	 * M�todo respons�vel pela realiza��o de saques, onde:
	 * @param valor Refere-se ao valor que ser� sacado.
	 * @throws
	 * */
	public void sacar(double valor) throws SaldoInsuficienteException {
		if(verificaSaldo(valor)) {
			saldo -= valor;
		}

	}
	/**
	 * M�todo respons�vel pela realiza��o de transfer�ncias entre contas, onde:
	 * @param beneficiado Refere-se ao objeto to tipo Conta de quem est� recebendo o valor transferido.
	 * @param valor Atributo do tipo double que indica o valor a ser transferido
	 * 
	 * @return Retorna 'true' caso a opera��o ocorra normalmente ou 'false' caso ocorra alguma irregularidade ou exce��o durante o processo.
	 * @throws SaldoInsuficienteException 
	 * */	
	public boolean transferir(AbstractConta beneficiado, double valor) throws SaldoInsuficienteException{
		
		if(verificaSaldo(valor)) {
			beneficiado.depositar(valor);
			return true;
		}
		//Caso o valor n�o seja suficiene para a transfer�ncia
		return false;
	}
	/**
	 * M�todo respons�vel pela exibi��o das credenciais vinculadas a uma determinada conta.
	 * */
	public void exibirCredenciais() {
		
		System.out.println("\n Credenciais do cliente \n" + "\nNome: " + titular
				+ "\nAg�ncia: " + agencia + 
				"\nConta: " + numero + 
				"\nSaldo dispon�vel: R$ " + saldo);			
	}
	/**
	 * M�todo utilizado para verifica��o de saldo, onde:
	 * @param valor Refere-se ao valor solicitado para a transa��o.
	 * @return Retorna 'false' quando o valor solicitado � inv�lido ou menor que o dispon�vel, caso contr�rio retorna 'true'
	 * @throws SaldoInsuficienteException 
	 * */
	public boolean verificaSaldo(double valor) throws SaldoInsuficienteException {
		
		if(validador.validaSaldo(this.saldo, valor) || validador.validaValores(valor)) {
			return true;
		}
		return false;
	}
	
	
	//Getters e Setters
	/**
	 * M�todo utilizado para obter-se o saldo da respectiva conta.
	 * @return saldo Atributo do tipo double referente ao saldo da conta.
	 * */
	public double getSaldo() {
		return saldo;
	}
	/**
	 * M�todo utilizado para obter-se a ag�ncia da respectiva conta.
	 * @return agencia Atributo do tipo int referente a ag�ncia que est� vinculada a conta.
	 * */
	public int getAgencia() {
		return agencia;
	}
	/***
	 * M�todo utilizado para definir um n�mero de ag�ncia a uma conta espec�fica.
	 * @param agencia Atributo do tipo int que define o n�mero da ag�ncia.
	 * @param ger Atributo do tipo gerente para valida��o do gerente respons�vel
	 * @param senhaGer Senha do gerente para autentica��o da altera��o.
	 */
	public void setAgencia(int agencia, Gerente ger, String senhaGer) {
		if(ger.autentica(senhaGer)) {
			validador.validaNumero(agencia);
			this.agencia = agencia;
		}else {
			System.out.println("Falha na autentica��o !");
		}
	}
	/**
	 * M�todo utilizado para se obter o n�mero da respectiva conta.
	 * @return numero Atributo do tipo long referente ao n�mero da conta.
	 * */
	public long getNumero() {
		return numero;
	}
	/**
	 * M�todo utilizado para se obter o titular da respectiva conta
	 * @return titular String contendo nome do titular da conta.
	 * */
	public String getTitular() {
		return titular;
	}
	/***
	 * M�todo utilizado para modificar o nome do titular de uma conta, onde:
	 * @param  titular Refere-se ao nome que ser� definido como o do titular da conta.
	 * @param ger  Atributo do tipo gerente para valida��o do gerente respons�vel
	 * @param senhaGer Senha do gerente para autentica��o da altera��o.
	 */
	public void modificarNomeTitular(String titular, Gerente ger, String senhaGer) {
		if(ger.autentica(senhaGer)){
			validador.validaString(titular);
			this.titular = titular;
		}else {
			System.out.println("Falha na autentica��o !");
		}
	}
	/**
	 * M�todo est�tico que retorna o total de contas criadas
	 * @return totalContas atributo do tipo int contendo o total de contas criadas.
	 * */
	public static int getTotalContas() {
		return totalContas;
	}
	/**
	 * M�todo est�tico que retorna o valor atual do gerador de n�meros sequenciais para as contas
	 * @return sequencialContas Atributo do tipo long que retorna o valor atual do gerador de n�meros sequenciais para a conta.
	 * */
	public static long getSequencialContas() {
		return sequencialContas;
	}
	
}
