package br.com.alura.model;

import br.com.alura.exception.SaldoInsuficienteException;

/**
 * Classe utilizada para representar uma Conta Poupan�a no projeto Bytebank.
 * 
 * @author RicardoJ�nior
 * @version 0.1
 * */
public class ContaPoupanca extends AbstractConta {
	/**
	 * M�todo construtor da classe ContaPoupanca, onde:
	 * @param agencia - Atributo do tipo int que representa a agencia onde a conta foi aberta.
	 * @param titular - Atributo do tipo String referente ao titular � quem a conta foi atribu�da.
	 * */
	public ContaPoupanca(int agencia, String titular) {
		super(agencia, titular);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		
		return "Tipo de conta: Conta Poupan�a" + "\nConta: " + super.getNumero() + " Ag�ncia: " + super.getAgencia();
	}
	//Sobreescrevendo m�todos da classe m�e
	/**
	 * M�todo que sobrescreve a forma de saque para adequ�-lo �s regras de neg�cios propostas para Contas Poupan�a, onde:
	 * @param valor - Refere-se a atributo do tipo double que representa o valor de saque.
	 * Obs.: S�o incorridas certas taxas no processo de saque.
	 * */
	@Override
	public void sacar(double valor) throws SaldoInsuficienteException{
		double taxa = valor*0.027;
		valor += taxa;
		super.sacar(valor);
	}

	@Override
	public int compareTo(AbstractConta outraConta) {
		// TODO Auto-generated method stub
		return Long.compare(super.getNumero(), outraConta.getNumero());
	}

}
