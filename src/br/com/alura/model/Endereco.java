package br.com.alura.model;

import br.com.alura.util.ValidadorUtil;

/**
 * Classe utilizada para estruturar o modelo de endereço a ser utilizado no projeto Bytebank.
 * */
public class Endereco extends EntidadeDominio {

	private String logradouro;
	private String estado;
	private String cidade;
	private String bairro;
	private String cep;
	private int numero;
	private String complemento;
	private ValidadorUtil validador = new ValidadorUtil();
		
	//Re-escrita
	/**
	 * Re-escrita do método toString() para exibição do endereço
	 * @return String Contendo o endereço formatado para exibição textual.
	 * */
	public String toString() {
		return "Endereço: " + logradouro + " , " + numero + " , " + cidade + " - " + estado + " , " 
	+ bairro + " CEP: " + cep;
	}
	
	//Getters e Setters
	/**
	 * Método para obtenção do logradouro registrado.
	 * @return logradouro String contendo o logradouro.
	 * */
	public String getLogradouro() {
		return logradouro;
	}
	/**
	 * Método para definição do logradouro.
	 * @param logradouro String contendo o logradouro.
	 * */
	public void setLogradouro(String logradouro) {
		if(validador.validaString(logradouro)) {
			this.logradouro = logradouro;
		}
	}
	/**
	 * Método para obtenção da cidade registrada.
	 * @return cidade String contendo a cidade.
	 * */
	public String getCidade() {
		return cidade;
	}
	/**
	 * Método para definir a cidade.
	 * @param cidade String contendo a cidade.
	 * */
	public void setCidade(String cidade) {
		if(validador.validaString(cidade)) {
			this.cidade = cidade;
		}
	}
	/**
	 * Método para obtenção do Estado registrado.
	 * @return estado String contendo o estado.
	 * */
	public String getEstado() {
		return estado;
	}
	/**
	 * Método para definição do Estado.
	 * @param estado String contendo o Estado.
	 * */
	public void setEstado(String estado) {
		if(validador.validaString(estado)) {
			this.estado = estado;
		}
	}
	/**
	 * Método para obtenção do bairro .
	 * @return bairro String contendo o bairro.
	 * */
	public String getBairro() {
		return bairro;
	}
	/**
	 * Método para definição do bairro.
	 * @param bairro String contendo o bairro.
	 * */
	public void setBairro(String bairro) {
		if(validador.validaString(bairro)) {
			this.bairro = bairro;
		}
	}
	/**
	 * Método para obtenção do cep.
	 * @return cep String contendo o CEP.
	 * */
	public String getCep() {
		return cep;
	}
	/**
	 * Método para definição do cep.
	 * @param cep String contendo o CEP.
	 * */
	public void setCep(String cep) {
		if(validador.validaString(cep)){
			this.cep = cep;
		}
	}
	/**
	 * Método para obtenção do número.
	 * @return numero Int contendo o número da residência.
	 * */
	public int getNumero() {
		return numero;
	}
	/**
	 * Método para definição do número.
	 * @param numero Int contendo o número da residência.
	 * */
	public void setNumero(int numero) {
		if(validador.validaNumero(numero)){
			this.numero = numero;
		}
			
	}
	/**
	 * Método para obtenção do Complemento do endereço.
	 * @return complemento String contendo o complemento do endereço.
	 * */
	public String getComplemento() {
		return complemento;
	}
	/**
	 * Método para definição do Complemento do endereço.
	 * @param complemento String contendo o complemento do endereço.
	 * */	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
