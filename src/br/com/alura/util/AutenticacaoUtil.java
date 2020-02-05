package br.com.alura.util;

/**
 * Classe utilizada para possibilitar o reaproveitamento de c�digo no processo de autentifica��o.
 * 
 * @author RicardoJ�nior
 * @version 0.1
 * */
public class AutenticacaoUtil{

	private String senha;
	private ValidadorUtil validador = new ValidadorUtil();
	
	/**
	 * M�todo construtor da classe AutenticacaoUtil.
	 * @param senha - For�a a cria��o de uma senha do tipo String para utiliza��o da classe.
	 * 
	 * */
	public AutenticacaoUtil(String senha) {
		if (validador.validaSenha(senha)) {
			this.senha = senha;
		}
	}
	/**
	 * M�todo p�blico da classe AutenticacaoUtil utilizado para atera��o de senha, onde:
	 * @param antiga - Atributo do tipo String referente a senha atual do usu�rio, declarada no momento da instancia��o da classe.
	 * @param nova - Atributo do tipo String referente a nova senha que est� sendo inserida.
	 * @return boolean - Retorna 'true' caso a opera��o ocorra com �xito e 'false' caso contr�rio.
	 * */
	public boolean alterarSenha(String antiga, String nova) {
		//Realiza as verifica��es necess�rias para a altera��o da senha
		if (antiga == this.senha && validador.validaSenha(nova)) {
			this.senha = nova;
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * M�todo p�blico da classe AutenticacaoUtil para realizar autentica��o da senha, onde:
	 * @param senha - refere a senha cadastrada do usu�rio. 
	 * @return boolean - Retorna 'true' caso a opera��o ocorra com �xito e 'false' caso contr�rio.
	 * */
	public boolean autentica(String senha) {
		if (senha == this.senha) {
			return true;
		} else {
			return false;
		}
	}

}
