package br.com.alura.model;

import br.com.alura.exception.SaldoInsuficienteException;

/**
 * Classe abstrata utilizada para possibilitar o reaproveitamento de c�digo no processo de autentifica��o.
 * 
 * @author RicardoJ�nior
 * @version 0.1
 * */
public class ContaCorrente extends AbstractConta {
	/**
	 * M�todo construtor da classe ContaCorrente, onde:
	 * @param agencia - Trata-se de atributo do tipo int que indica a identifica��o de uma ag�ncia
	 * @param titular - Trata-se de atributo do tipo String que indica o nome do titular da conta.
	 * */
	public ContaCorrente(int agencia, String titular) {
		super(agencia, titular);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		
		return "Tipo de conta: Conta Corrente" + "\nConta: " + super.getNumero() + " Ag�ncia: " + super.getAgencia();
	}
	//Sobreescrevendo m�todos da classe m�e
	/**
	 * M�todo utilizado para realizar saques, onde:
	 * @param valor - Refere-se ao valor que ser� sacado da conta.
	 * @throws
	 * */
	public void sacar(double valor) throws SaldoInsuficienteException{
			//calculando as taxas de saque.
			double taxa = valor*0.031;
			valor += taxa;
			super.sacar(valor);
	}

	@Override
	public int compareTo(AbstractConta outraConta) {
		return Long.compare(super.getNumero(), outraConta.getNumero());
	}

}
