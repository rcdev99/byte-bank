package testes;
import br.com.alura.exception.SaldoInsuficienteException;
import br.com.alura.model.*;
/**
 * Classe principal do Bytebank para configuração do Entrypoint da aplicação.
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
		
		//exibindo as informaões da conta criada
		conta.exibirCredenciais();
		
		//Realizando retirada
		conta.sacar(15960);
		
		//conferindo saldo após retirada
		System.out.println("Saldo após retirada: R$ " + conta.getSaldo());
		
		//Simular recebimento de salário
		//instanciando salário
		double salario = 2564.35;
		
		//atribuindo à conta desejada
		conta.depositar(salario);
		
		System.out.println("Saldo após quinto dia útil: R$ " + salario);
		
		//realizando transferência
		conta2.exibirCredenciais();		
		conta2.transferir(conta, 99.99);
		//exibindo saldos após transferência
		System.out.println("Conta 1: " + conta.getSaldo());
		System.out.println("Conta 2: " + conta2.getSaldo());
		
		System.out.println("\nQtd de contas criadas: " + AbstractConta.getTotalContas());
		
	}

}
