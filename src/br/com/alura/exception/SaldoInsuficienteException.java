package br.com.alura.exception;
/**
 * Classe utilizado para lançar exceções quando uma operação não puder ser realizada devido ao saldo ser insuficiente.
 */
public class SaldoInsuficienteException extends Exception {//Herdando de Exception tenho uma exceção do tipo checked que deve obrigatoriamente ser tratada nos métodos ou classes que a utilizarem

	
	private static final long serialVersionUID = 1L;
	
	//Através do construtor passo uma mensagem à classe mãe da classe atual
	/**
	 * Método construtor da classe SaldoInsuficienteException para enviar mensagem á superclasse quando construído
	 * @param msg String contendo a mensagem que será enviada à super classe.
	 * */
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
	public SaldoInsuficienteException() {
		super("Saldo insuficiente !");
	}

}
