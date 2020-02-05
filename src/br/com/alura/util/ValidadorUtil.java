package br.com.alura.util;

import br.com.alura.exception.SaldoInsuficienteException;
import br.com.alura.model.Cliente;
import br.com.alura.model.Endereco;

/**
 * Classe utilizada para realizar opera��es de valida��o
 * */
public class ValidadorUtil {
	
	//M�todos
		/**
		 * M�todo utilizado para verificar se determinado argumento � vazio ou nulo
		 * @param arg String que ser� verificada
		 * @return boolean Retorna 'true' caso o argumento n�o esteja vazio ou nulo e 'false' caso contr�rio.
		 * */
		public boolean naoNulo(String arg) {
			arg = arg.trim();
			if(arg.isBlank() || arg.isEmpty() || arg == null) {
				return false;
			}else {
				return true;
			}
		}
		/**
		 * M�todo utilizado para valida��o de genero
		 * @param genero atributo do tipo char contendo o genero a ser validado
		 * @return boolean Retorna 'true' caso o genero esteja entre os considerador v�lidos ou 'false' caso contr�rio.
		 * */
		public boolean validaGenero(char genero) {
			genero = Character.toUpperCase(genero);
			if(genero == 'F' || genero == 'M') {
				return true;
			}else {
				return false;
			}
		}
		/***
		 * M�todo utilizado para validar a senha
		 * @param senha
		 * @return 'true' caso a senha esteja de acordo com os par�metros de valida��o, 'false' caso n�o os atenda e pode gerar exce��o caso seja 
		 * preenchida com espa��s ou valores nulos.
		 */
		public boolean validaSenha(String senha) {
			senha = senha.trim();
			if (senha.isBlank() || senha == null || senha.isEmpty()) {
				throw new NullPointerException("A senha n�o pode ser preenchida com valores nulos ou apenas espa�os !");
			}
			if (senha.length() < 8) {
				System.out.println("A senha deve conter no m�nimo 8 caracteres !");
				return false;
			}
			return true;
		}
		
		/***
		 * M�todo utilizado na valida��o de n�meros inteiros para garantir que n�o sejam valores negativos.
		 * @param numero
		 * @return 'true' caso atenda as especifica��es, gera exce��o do tipo NumberFormatException caso sejam inseridos n�meros negativos. 
		 */
		public boolean validaNumero(int numero) {
			if(numero < 0 ) {
				throw new NumberFormatException("Para esta opera��o n�o s�o permitidos n�meros negativos !");
			}
			return true;
		}
		/***
		 * M�todo utilizado na valida��o de valores do tipo double para garantir que n�o sejam n�meros negativos.
		 * @param valor
		 * @return 'true' caso atenda as especifica��es, gera exce��o do tipo NumberFormatException quando s�o inseridos valores negativos.
		 */
		public boolean validaValores(double valor) {
			if(valor < 0) {
				throw new NumberFormatException("Para esta opera��o n�o s�o permitidos valores negativos !");
			}
			return true;
		}
		/***
		 * M�todo utilizado paravalida��o do saldo em opera��es que exijam a retirada de valores de uma conta.
		 * @param saldo
		 * @param valorSolicitado
		 * @return 'true' caso o saldo seja suficiente para a transa��o, gera exce��o do tipo SaldoInsuficienteException quando o saldo � insuficiente
		 * para a opera��o.
		 * @throws SaldoInsuficienteException
		 */
		public boolean validaSaldo(double saldo, double valorSolicitado) throws SaldoInsuficienteException {
			if(saldo < valorSolicitado) {
				throw new SaldoInsuficienteException("\nSaldo insuficiente! \nDispon�vel: R$ " + saldo
					+ "\nSolicitado: R$" + valorSolicitado);
			}
			return true;
		}
		/***
		 * M�todo validador de String para garantir que o valor inserido n�o seja nulo ou esteja em branco.
		 * @param arg
		 * @return
		 */
		public boolean validaString(String arg) {
			arg = arg.trim();
			if (arg.isBlank() || arg == null || arg.isEmpty()) {
				throw new NullPointerException("Este campo n�o pode ser preenchido com valores nulos ou apenas espa�os !");
			}
			return true;
		}
		/**
		 * M�todo que realiza varredura nos dados do endere�o verificando se todos est�o corretamente preenchidos.
		 * @param endereco
		 */
		public void validaEndereco(Endereco endereco) {
			
			this.validaString(endereco.getBairro());
			this.validaString(endereco.getCep());
			this.validaString(endereco.getCidade());
			this.validaString(endereco.getEstado());
			this.validaString(endereco.getLogradouro());
			this.validaNumero(endereco.getNumero());
			
		}
		public void validaCliente(Cliente cliente) {
			
			this.validaString(cliente.getNome());
			this.validaString(cliente.getSobrenome());
			this.validaString(cliente.getCpf());
			this.validaString(cliente.getRg());
			this.validaGenero(cliente.getGenero());
			this.validaEndereco(cliente.getEndereco());
			
		}
		

		//M�scaras
			
}
