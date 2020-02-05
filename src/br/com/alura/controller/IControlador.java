package br.com.alura.controller;

import java.util.ArrayList;

import br.com.alura.model.EntidadeDominio;
/***
 * Interface criada para exigir a implementação de métodos de controle.
 * @author Brazcubas
 */
public interface IControlador {
	
	public boolean alterar(EntidadeDominio entidade);
	public boolean cadastrar(EntidadeDominio entidade);
	public ArrayList<EntidadeDominio> consultar(int identificador);
	public boolean excluir(EntidadeDominio entidade);
	
	
}
