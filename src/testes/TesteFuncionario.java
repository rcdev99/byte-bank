package testes;
import br.com.alura.model.*;
/**
 * Classe para execução de testes das funcionalidades do sistema.
 * */
public class TesteFuncionario {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractFuncionario func = new Gerente("Jodeirson", "Melsedeque", 2200.00, "123gerente");
		Gerente ger = new Gerente("Gerson", "O Gerente", 2200.00, "123gerente");
		TesteFuncionario teste = new TesteFuncionario();
		
		System.out.println("\nNome: "+ func.getNome() + "\nSalário: " + func.getSalario() 
		+ "\nBonificação: " + func.getBonificacao());
		
		System.out.println("\nNome: "+ ger.getNome() + "\nSalário: " + ger.getSalario() 
		+ "\nBonificação: " + ger.getBonificacao());
		
		
		AbstractFuncionario f = new Gerente("Gerson", "O outro Gerente", 2200.00, "123gerente");
		System.out.println("\nNome: "+ f.getNome() + "\nSalário: " + f.getSalario() 
		+ "\nBonificação: " + f.getBonificacao());
		
		teste.ehFuncionario(func);
		teste.ehFuncionario(ger);
		teste.ehFuncionario(f);
		
		String teste1 = "teste: ";
		
		System.out.println("Novo teste: \n" + teste1 + f);
	}
	
	public void ehFuncionario(AbstractFuncionario fun) {
		System.out.println("\n" + fun.getNome() + " É funcionário \nFunção: " + fun.getFuncao());
	}

}
