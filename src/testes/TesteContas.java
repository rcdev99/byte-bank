package testes;
import br.com.alura.exception.SaldoInsuficienteException;
import br.com.alura.model.*;
/**
 * Classe principal do Bytebank para configura��o do Entrypoint da aplica��o.
 * */
public class TesteContas {

	public static void main(String[] args) throws SaldoInsuficienteException {
		// TODO Auto-generated method stub

		//instanciando conta
		AbstractConta conta = new ContaCorrente(1257,"Valdeilson Pereira dos Santos");
		AbstractConta conta2 = new ContaPoupanca(1257,"Juracir Barbosa de Oliveira");
		
		//atribuindo valores aos atributos
		conta.depositar(19800);
		
		//atribuindo valores aos atributos
		conta2.depositar(20000);
		
		//exibindo as informa�es da conta criada
		conta.exibirCredenciais();
		
		//Realizando retirada
		conta.sacar(15960);
		
		//conferindo saldo ap�s retirada
		System.out.println("Saldo ap�s retirada: R$ " + conta.getSaldo());
		
		//Simular recebimento de sal�rio
		//instanciando sal�rio
		double salario = 2564.35;
		
		//atribuindo � conta desejada
		conta.depositar(salario);
		
		System.out.println("Saldo ap�s quinto dia �til: R$ " + salario);
		
		//realizando transfer�ncia
		conta2.exibirCredenciais();		
		conta2.transferir(conta, 99.99);
		//exibindo saldos ap�s transfer�ncia
		System.out.println("Conta 1: " + conta.getSaldo());
		System.out.println("Conta 2: " + conta2.getSaldo());
		
		System.out.println("\nQtd de contas criadas: " + AbstractConta.getTotalContas());
		
	}

}
