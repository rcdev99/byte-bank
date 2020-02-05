package testes;
import br.com.alura.model.*;
/**
 * Classe para execu��o de testes das funcionalidades do sistema.
 * */
public class TesteFuncionario {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractFuncionario func = new Gerente("Jodeirson", "Melsedeque", 2200.00, "123gerente");
		Gerente ger = new Gerente("Gerson", "O Gerente", 2200.00, "123gerente");
		TesteFuncionario teste = new TesteFuncionario();
		
		System.out.println("\nNome: "+ func.getNome() + "\nSal�rio: " + func.getSalario() 
		+ "\nBonifica��o: " + func.getBonificacao());
		
		System.out.println("\nNome: "+ ger.getNome() + "\nSal�rio: " + ger.getSalario() 
		+ "\nBonifica��o: " + ger.getBonificacao());
		
		
		AbstractFuncionario f = new Gerente("Gerson", "O outro Gerente", 2200.00, "123gerente");
		System.out.println("\nNome: "+ f.getNome() + "\nSal�rio: " + f.getSalario() 
		+ "\nBonifica��o: " + f.getBonificacao());
		
		teste.ehFuncionario(func);
		teste.ehFuncionario(ger);
		teste.ehFuncionario(f);
		
		String teste1 = "teste: ";
		
		System.out.println("Novo teste: \n" + teste1 + f);
	}
	
	public void ehFuncionario(AbstractFuncionario fun) {
		System.out.println("\n" + fun.getNome() + " � funcion�rio \nFun��o: " + fun.getFuncao());
	}

}
