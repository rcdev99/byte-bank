package br.com.alura.model;

import br.com.alura.util.AutenticacaoUtil;

/**
 * Classe que reúne atributos e métodos referentes ao tipo de funcionário Gerente.
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
	 * Re-escrita do método toString() da classe Gerente
	 * @return String Texto contendo texto formatado para identificação do gerente.
	 * */
	public String toString() {
		return "Fui re-escrito";
	}
	/**
	 * Re-escrita do método getBonificação para atender as regras de negócio especificas para gerentes.
	 * @return double Contendo a bonificação do gerente.
	 * */
	@Override
	public double getBonificacao() {
		
		// TODO Auto-generated method stub
		return + super.getSalario();
	}
	/**
	 * Implementação do método alterarSenha para cumprimento do contrato com a Interface IAutenticavel
	 * @param antiga - Senha antiga do gerente
	 * @param nova - Nova senha do gerente
	 * @return boolean - Retorna 'true' caso a senha seja alterada com sucesso ou 'false' quando a operação é impedida por algum fator.
	 * */
	@Override
	public boolean alterarSenha(String antiga, String nova) {
		return autenticador.alterarSenha(antiga, nova);
	}
	/**
	 * Implementação do método autentica para cumprimento do contrato com a Interface IAutenticavel
	 * @param senha - String contendo a senha do gerente
	 * @return boolean - Retorna 'true' caso a senha seja válida ou 'false' em caso de inconsistência.
	 * */
	@Override
	public boolean autentica(String senha) {
		return autentica(senha);
	}
	
}
