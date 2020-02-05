package br.com.alura.model;

public interface IAutenticavel {

	public boolean alterarSenha(String antiga, String nova);
	public boolean autentica(String senha);
	
}
