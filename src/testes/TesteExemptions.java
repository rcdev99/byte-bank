package testes;
import br.com.alura.exception.SaldoInsuficienteException;
import br.com.alura.model.*;
/**
 * Classe para execução de testes das funcionalidades do sistema.
 * */
public class TesteExemptions {
	public static void main(String args[]) throws SaldoInsuficienteException {
		
		//Setar 'true' para habilitar determinados testes
		boolean testarContaCorrente = true;
		boolean testarContaPoupanca = false;
		
		//Teste conta corrente
		if(testarContaCorrente) {
			ContaCorrente c = new ContaCorrente(123, "Eu");
			c.depositar(100);
			c.sacar(-9);
			System.out.println(c.getSaldo());
		}
		//Teste conta poupança
		if(testarContaPoupanca) {
			ContaPoupanca c = new ContaPoupanca(123, "Eu");
			c.depositar(100);
			c.sacar(99);
		}
	}
	
}
