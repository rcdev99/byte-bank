package br.com.alura.controller;

import java.util.ArrayList;
import br.com.alura.model.*;
/**
 * Classe criada para implementação de métodos controladores para a Classe Gerente
 * @author RicardoJunior
 *
 */
public class CGerente implements IControlador {
	
	ArrayList<Gerente> gerentes = new ArrayList<Gerente>();

	@Override
	public boolean alterar(EntidadeDominio funcionario) {
		Gerente ger = (Gerente) funcionario;
		
		for (Gerente gerente : gerentes) {
			if(gerente.getMatricula() == ger.getMatricula()) {
				
				gerente = ger;
				return true;
			}
		}
			return false;
		
	}

	@Override
	public boolean cadastrar(EntidadeDominio funcionario) {
		Gerente ger = (Gerente) funcionario;
		
		for (Gerente gerente : gerentes) {
			if(gerente.getMatricula() == ger.getMatricula()) {
				return false;
			}
			gerentes.add(ger);
		}
		
		return true;
	}

	@Override
	public ArrayList<EntidadeDominio> consultar(int matricula) {
		
		ArrayList<EntidadeDominio> consulta = new ArrayList<EntidadeDominio>();  
		for (Gerente gerente : gerentes) {
			if(gerente.getMatricula() == matricula) {
				consulta.add(gerente);
			}
		}
		
		return consulta;
	}

	@Override
	public boolean excluir(EntidadeDominio funcionario) {
		
		Gerente ger = (Gerente) funcionario;
		
		for (Gerente gerente : gerentes) {
			if(gerente.getMatricula() == ger.getMatricula()) {
				
				gerentes.remove(gerente);
				return false;
			}
			
		}
		
		return true;
	}



}
