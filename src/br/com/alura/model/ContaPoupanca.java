package br.com.alura.model;

import br.com.alura.exception.SaldoInsuficienteException;

/**
 * Classe utilizada para representar uma Conta Poupança no projeto Bytebank.
 * 
 * @author RicardoJúnior
 * @version 0.1
 * */
public class ContaPoupanca extends AbstractConta {
	/**
	 * Método construtor da classe ContaPoupanca, onde:
	 * @param agencia - Atributo do tipo int que representa a agencia onde a conta foi aberta.
	 * @param titular - Atributo do tipo String referente ao titular à quem a conta foi atribuída.
	 * */
	public ContaPoupanca(int agencia, String titular) {
		super(agencia, titular);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		
		return "Tipo de conta: Conta Poupança" + "\nConta: " + super.getNumero() + " Agência: " + super.getAgencia();
	}
	//Sobreescrevendo métodos da classe mãe
	/**
	 * Método que sobrescreve a forma de saque para adequá-lo às regras de negócios propostas para Contas Poupança, onde:
	 * @param valor - Refere-se a atributo do tipo double que representa o valor de saque.
	 * Obs.: São incorridas certas taxas no processo de saque.
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
