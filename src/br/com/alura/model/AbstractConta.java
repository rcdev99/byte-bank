package br.com.alura.model;

import br.com.alura.exception.SaldoInsuficienteException;
import br.com.alura.util.ValidadorUtil;

/**
 * Classe abstrata que representa a moldura de uma conta no projeto Bytebank.
 * 
 * @author RicardoJúnior
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
	 * Método construtor da classe conta, onde:
	 * 
	 * @param agencia atributo do tipo int que representa o número da agência.
	 * @param titular String que representa o titular da conta.
	 * */
	public AbstractConta(int agencia, String titular) {
		//Verifica possíveis exceções
		validador.validaNumero(agencia);
		validador.validaString(titular);
		//itera o total e o sequencial de contas
		totalContas++;
		sequencialContas++;
		//instancia os atributos com as informações necessárias para a criação da conta.
		this.saldo = 0;
		this.agencia = agencia;
		this.numero = sequencialContas;
		this.titular = titular;
		
		System.out.println("Conta criada com sucesso !");
	}
	/**
	 * Método responsável por depósitos na conta, onde:
	 * @param valor Refere-se ao valor que está sendo depositado.
	 * */
	public void depositar(double valor) {
			if(validador.validaValores(valor)) {
				saldo += valor;
			}
		}
	/**
	 * Método responsável pela realização de saques, onde:
	 * @param valor Refere-se ao valor que será sacado.
	 * @throws
	 * */
	public void sacar(double valor) throws SaldoInsuficienteException {
		if(verificaSaldo(valor)) {
			saldo -= valor;
		}

	}
	/**
	 * Método responsável pela realização de transferências entre contas, onde:
	 * @param beneficiado Refere-se ao objeto to tipo Conta de quem está recebendo o valor transferido.
	 * @param valor Atributo do tipo double que indica o valor a ser transferido
	 * 
	 * @return Retorna 'true' caso a operação ocorra normalmente ou 'false' caso ocorra alguma irregularidade ou exceção durante o processo.
	 * @throws SaldoInsuficienteException 
	 * */	
	public boolean transferir(AbstractConta beneficiado, double valor) throws SaldoInsuficienteException{
		
		if(verificaSaldo(valor)) {
			beneficiado.depositar(valor);
			return true;
		}
		//Caso o valor não seja suficiene para a transferência
		return false;
	}
	/**
	 * Método responsável pela exibição das credenciais vinculadas a uma determinada conta.
	 * */
	public void exibirCredenciais() {
		
		System.out.println("\n Credenciais do cliente \n" + "\nNome: " + titular
				+ "\nAgência: " + agencia + 
				"\nConta: " + numero + 
				"\nSaldo disponível: R$ " + saldo);			
	}
	/**
	 * Método utilizado para verificação de saldo, onde:
	 * @param valor Refere-se ao valor solicitado para a transação.
	 * @return Retorna 'false' quando o valor solicitado é inválido ou menor que o disponível, caso contrário retorna 'true'
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
	 * Método utilizado para obter-se o saldo da respectiva conta.
	 * @return saldo Atributo do tipo double referente ao saldo da conta.
	 * */
	public double getSaldo() {
		return saldo;
	}
	/**
	 * Método utilizado para obter-se a agência da respectiva conta.
	 * @return agencia Atributo do tipo int referente a agência que está vinculada a conta.
	 * */
	public int getAgencia() {
		return agencia;
	}
	/***
	 * Método utilizado para definir um número de agência a uma conta específica.
	 * @param agencia Atributo do tipo int que define o número da agência.
	 * @param ger Atributo do tipo gerente para validação do gerente responsável
	 * @param senhaGer Senha do gerente para autenticação da alteração.
	 */
	public void setAgencia(int agencia, Gerente ger, String senhaGer) {
		if(ger.autentica(senhaGer)) {
			validador.validaNumero(agencia);
			this.agencia = agencia;
		}else {
			System.out.println("Falha na autenticação !");
		}
	}
	/**
	 * Método utilizado para se obter o número da respectiva conta.
	 * @return numero Atributo do tipo long referente ao número da conta.
	 * */
	public long getNumero() {
		return numero;
	}
	/**
	 * Método utilizado para se obter o titular da respectiva conta
	 * @return titular String contendo nome do titular da conta.
	 * */
	public String getTitular() {
		return titular;
	}
	/***
	 * Método utilizado para modificar o nome do titular de uma conta, onde:
	 * @param  titular Refere-se ao nome que será definido como o do titular da conta.
	 * @param ger  Atributo do tipo gerente para validação do gerente responsável
	 * @param senhaGer Senha do gerente para autenticação da alteração.
	 */
	public void modificarNomeTitular(String titular, Gerente ger, String senhaGer) {
		if(ger.autentica(senhaGer)){
			validador.validaString(titular);
			this.titular = titular;
		}else {
			System.out.println("Falha na autenticação !");
		}
	}
	/**
	 * Método estático que retorna o total de contas criadas
	 * @return totalContas atributo do tipo int contendo o total de contas criadas.
	 * */
	public static int getTotalContas() {
		return totalContas;
	}
	/**
	 * Método estático que retorna o valor atual do gerador de números sequenciais para as contas
	 * @return sequencialContas Atributo do tipo long que retorna o valor atual do gerador de números sequenciais para a conta.
	 * */
	public static long getSequencialContas() {
		return sequencialContas;
	}
	
}
