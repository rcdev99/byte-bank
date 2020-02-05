package br.com.alura.controller;

import java.util.ArrayList;

import br.com.alura.model.ContaCorrente;
import br.com.alura.model.EntidadeDominio;

public class CContaCorrente implements IControlador {

ArrayList<ContaCorrente> contas = new ArrayList<ContaCorrente>();
	
	@Override
	public boolean alterar(EntidadeDominio conta) {
		
		ContaCorrente cp = (ContaCorrente) conta;
		for (ContaCorrente c: contas) {
			if(cp.getNumero() == c.getNumero() ) {
				c = cp;
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean cadastrar(EntidadeDominio conta) {
		
		ContaCorrente cp = (ContaCorrente) conta;
		for (ContaCorrente c: contas) {
			if(cp.getNumero() == c.getNumero() ) {
				return false;
			}
		}
		
		contas.add(cp);
		return true;
	}

	@Override
	public ArrayList<EntidadeDominio> consultar(int identificador) {
		
		ArrayList<EntidadeDominio> consulta  = new ArrayList<EntidadeDominio>();
		
		for (ContaCorrente c: contas) {
			if(c.getNumero() == identificador) {
				consulta.add(c);
			}
		}
	
		return consulta;
	}

	@Override
	public boolean excluir(EntidadeDominio conta) {
		
		ContaCorrente cp = (ContaCorrente) conta;
		for (ContaCorrente c: contas) {
			if(cp.getNumero() == c.getNumero() ) {
				contas.remove(c);
				return true;
			}
		}
		
		return false;
	}
}