package br.com.alura.util;

/**
 * Classe utilizada para possibilitar o reaproveitamento de código no processo de autentificação.
 * 
 * @author RicardoJúnior
 * @version 0.1
 * */
public class AutenticacaoUtil{

	private String senha;
	private ValidadorUtil validador = new ValidadorUtil();
	
	/**
	 * Método construtor da classe AutenticacaoUtil.
	 * @param senha - Força a criação de uma senha do tipo String para utilização da classe.
	 * 
	 * */
	public AutenticacaoUtil(String senha) {
		if (validador.validaSenha(senha)) {
			this.senha = senha;
		}
	}
	/**
	 * Método público da classe AutenticacaoUtil utilizado para ateração de senha, onde:
	 * @param antiga - Atributo do tipo String referente a senha atual do usuário, declarada no momento da instanciação da classe.
	 * @param nova - Atributo do tipo String referente a nova senha que está sendo inserida.
	 * @return boolean - Retorna 'true' caso a operação ocorra com êxito e 'false' caso contrário.
	 * */
	public boolean alterarSenha(String antiga, String nova) {
		//Realiza as verificações necessárias para a alteração da senha
		if (antiga == this.senha && validador.validaSenha(nova)) {
			this.senha = nova;
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Método público da classe AutenticacaoUtil para realizar autenticação da senha, onde:
	 * @param senha - refere a senha cadastrada do usuário. 
	 * @return boolean - Retorna 'true' caso a operação ocorra com êxito e 'false' caso contrário.
	 * */
	public boolean autentica(String senha) {
		if (senha == this.senha) {
			return true;
		} else {
			return false;
		}
	}

}
