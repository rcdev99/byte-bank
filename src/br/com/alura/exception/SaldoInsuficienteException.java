package br.com.alura.exception;
/**
 * Classe utilizado para lan�ar exce��es quando uma opera��o n�o puder ser realizada devido ao saldo ser insuficiente.
 */
public class SaldoInsuficienteException extends Exception {//Herdando de Exception tenho uma exce��o do tipo checked que deve obrigatoriamente ser tratada nos m�todos ou classes que a utilizarem

	
	private static final long serialVersionUID = 1L;
	
	//Atrav�s do construtor passo uma mensagem � classe m�e da classe atual
	/**
	 * M�todo construtor da classe SaldoInsuficienteException para enviar mensagem � superclasse quando constru�do
	 * @param msg String contendo a mensagem que ser� enviada � super classe.
	 * */
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
	public SaldoInsuficienteException() {
		super("Saldo insuficiente !");
	}

}
