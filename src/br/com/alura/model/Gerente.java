package br.com.alura.model;

import br.com.alura.util.AutenticacaoUtil;

/**
 * Classe que re�ne atributos e m�todos referentes ao tipo de funcion�rio Gerente.
 * */
public class Gerente extends AbstractFuncionario implements IAutenticavel{

	AutenticacaoUtil autenticador;
	
	/**
	 * Construtor da classe Gerente, onde:
	 * @param nome String contendo o nome do gerente.
	 * @param sobrenome String contendo o sobrenome do gerente.
	 * @param salario double contendo o valor do salario.
	 * @param senha String contendo a senha do gerente.
	 * */
	public Gerente(String nome, String sobrenome, double salario, String senha) {
		super(nome, sobrenome, salario);
		super.setFuncao("Gerente");
		autenticador = new AutenticacaoUtil(senha);
		
	}
	/**
	 * Re-escrita do m�todo toString() da classe Gerente
	 * @return String Texto contendo texto formatado para identifica��o do gerente.
	 * */
	public String toString() {
		return "Fui re-escrito";
	}
	/**
	 * Re-escrita do m�todo getBonifica��o para atender as regras de neg�cio especificas para gerentes.
	 * @return double Contendo a bonifica��o do gerente.
	 * */
	@Override
	public double getBonificacao() {
		
		// TODO Auto-generated method stub
		return + super.getSalario();
	}
	/**
	 * Implementa��o do m�todo alterarSenha para cumprimento do contrato com a Interface IAutenticavel
	 * @param antiga - Senha antiga do gerente
	 * @param nova - Nova senha do gerente
	 * @return boolean - Retorna 'true' caso a senha seja alterada com sucesso ou 'false' quando a opera��o � impedida por algum fator.
	 * */
	@Override
	public boolean alterarSenha(String antiga, String nova) {
		return autenticador.alterarSenha(antiga, nova);
	}
	/**
	 * Implementa��o do m�todo autentica para cumprimento do contrato com a Interface IAutenticavel
	 * @param senha - String contendo a senha do gerente
	 * @return boolean - Retorna 'true' caso a senha seja v�lida ou 'false' em caso de inconsist�ncia.
	 * */
	@Override
	public boolean autentica(String senha) {
		return autentica(senha);
	}
	
}
