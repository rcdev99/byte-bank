package br.com.alura.controller;

import java.util.Comparator;
import br.com.alura.model.Cliente;
/***
 * Classe criada para possibilitar a ordena��o atrav�s da compara��o de clientes pelo nome
 * @author Brazcubas
 *
 */
public class CompareClientByName implements Comparator<Cliente> {

	@Override
	public int compare(Cliente c1, Cliente c2) {
		//Compara o nome de dois clientes, retornado 0 se forem iguais, 1 quando o primeiro � maior e -1 caso contr�rio.
		return c1.getNome().compareTo(c2.getNome());
	}

}
