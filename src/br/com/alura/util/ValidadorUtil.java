package br.com.alura.util;

import br.com.alura.exception.SaldoInsuficienteException;
import br.com.alura.model.Cliente;
import br.com.alura.model.Endereco;

/**
 * Classe utilizada para realizar operações de validação
 * */
public class ValidadorUtil {
	
	//Métodos
		/**
		 * Método utilizado para verificar se determinado argumento é vazio ou nulo
		 * @param arg String que será verificada
		 * @return boolean Retorna 'true' caso o argumento não esteja vazio ou nulo e 'false' caso contrário.
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
		 * Método utilizado para validação de genero
		 * @param genero atributo do tipo char contendo o genero a ser validado
		 * @return boolean Retorna 'true' caso o genero esteja entre os considerador válidos ou 'false' caso contrário.
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
		 * Método utilizado para validar a senha
		 * @param senha
		 * @return 'true' caso a senha esteja de acordo com os parâmetros de validação, 'false' caso não os atenda e pode gerar exceção caso seja 
		 * preenchida com espaçõs ou valores nulos.
		 */
		public boolean validaSenha(String senha) {
			senha = senha.trim();
			if (senha.isBlank() || senha == null || senha.isEmpty()) {
				throw new NullPointerException("A senha não pode ser preenchida com valores nulos ou apenas espaços !");
			}
			if (senha.length() < 8) {
				System.out.println("A senha deve conter no mínimo 8 caracteres !");
				return false;
			}
			return true;
		}
		
		/***
		 * Método utilizado na validação de números inteiros para garantir que não sejam valores negativos.
		 * @param numero
		 * @return 'true' caso atenda as especificações, gera exceção do tipo NumberFormatException caso sejam inseridos números negativos. 
		 */
		public boolean validaNumero(int numero) {
			if(numero < 0 ) {
				throw new NumberFormatException("Para esta operação não são permitidos números negativos !");
			}
			return true;
		}
		/***
		 * Método utilizado na validação de valores do tipo double para garantir que não sejam números negativos.
		 * @param valor
		 * @return 'true' caso atenda as especificações, gera exceção do tipo NumberFormatException quando são inseridos valores negativos.
		 */
		public boolean validaValores(double valor) {
			if(valor < 0) {
				throw new NumberFormatException("Para esta operação não são permitidos valores negativos !");
			}
			return true;
		}
		/***
		 * Método utilizado paravalidação do saldo em operações que exijam a retirada de valores de uma conta.
		 * @param saldo
		 * @param valorSolicitado
		 * @return 'true' caso o saldo seja suficiente para a transação, gera exceção do tipo SaldoInsuficienteException quando o saldo é insuficiente
		 * para a operação.
		 * @throws SaldoInsuficienteException
		 */
		public boolean validaSaldo(double saldo, double valorSolicitado) throws SaldoInsuficienteException {
			if(saldo < valorSolicitado) {
				throw new SaldoInsuficienteException("\nSaldo insuficiente! \nDisponível: R$ " + saldo
					+ "\nSolicitado: R$" + valorSolicitado);
			}
			return true;
		}
		/***
		 * Método validador de String para garantir que o valor inserido não seja nulo ou esteja em branco.
		 * @param arg
		 * @return
		 */
		public boolean validaString(String arg) {
			arg = arg.trim();
			if (arg.isBlank() || arg == null || arg.isEmpty()) {
				throw new NullPointerException("Este campo não pode ser preenchido com valores nulos ou apenas espaços !");
			}
			return true;
		}
		/**
		 * Método que realiza varredura nos dados do endereço verificando se todos estão corretamente preenchidos.
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
		

		//Máscaras
			
}
