package br.com.alura.controller;

import java.util.ArrayList;

import br.com.alura.model.ContaPoupanca;
import br.com.alura.model.EntidadeDominio;

public class CContasPoupanca implements IControlador {

	ArrayList<ContaPoupanca> contas = new ArrayList<ContaPoupanca>();
	
	@Override
	public boolean alterar(EntidadeDominio conta) {
		
		ContaPoupanca cp = (ContaPoupanca) conta;
		for (ContaPoupanca c: contas) {
			if(cp.getNumero() == c.getNumero() ) {
				c = cp;
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean cadastrar(EntidadeDominio conta) {
		
		ContaPoupanca cp = (ContaPoupanca) conta;
		for (ContaPoupanca c: contas) {
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
		
		for (ContaPoupanca c: contas) {
			if(c.getNumero() == identificador) {
				consulta.add(c);
			}
		}
	
		return consulta;
	}

	@Override
	public boolean excluir(EntidadeDominio conta) {
		
		ContaPoupanca cp = (ContaPoupanca) conta;
		for (ContaPoupanca c: contas) {
			if(cp.getNumero() == c.getNumero() ) {
				contas.remove(c);
				return true;
			}
		}
		
		return false;
	}

}
