package br.com.alura.model;

import br.com.alura.util.ValidadorUtil;

/**
 * Classe utilizada para estruturar o modelo de endere�o a ser utilizado no projeto Bytebank.
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
	 * Re-escrita do m�todo toString() para exibi��o do endere�o
	 * @return String Contendo o endere�o formatado para exibi��o textual.
	 * */
	public String toString() {
		return "Endere�o: " + logradouro + " , " + numero + " , " + cidade + " - " + estado + " , " 
	+ bairro + " CEP: " + cep;
	}
	
	//Getters e Setters
	/**
	 * M�todo para obten��o do logradouro registrado.
	 * @return logradouro String contendo o logradouro.
	 * */
	public String getLogradouro() {
		return logradouro;
	}
	/**
	 * M�todo para defini��o do logradouro.
	 * @param logradouro String contendo o logradouro.
	 * */
	public void setLogradouro(String logradouro) {
		if(validador.validaString(logradouro)) {
			this.logradouro = logradouro;
		}
	}
	/**
	 * M�todo para obten��o da cidade registrada.
	 * @return cidade String contendo a cidade.
	 * */
	public String getCidade() {
		return cidade;
	}
	/**
	 * M�todo para definir a cidade.
	 * @param cidade String contendo a cidade.
	 * */
	public void setCidade(String cidade) {
		if(validador.validaString(cidade)) {
			this.cidade = cidade;
		}
	}
	/**
	 * M�todo para obten��o do Estado registrado.
	 * @return estado String contendo o estado.
	 * */
	public String getEstado() {
		return estado;
	}
	/**
	 * M�todo para defini��o do Estado.
	 * @param estado String contendo o Estado.
	 * */
	public void setEstado(String estado) {
		if(validador.validaString(estado)) {
			this.estado = estado;
		}
	}
	/**
	 * M�todo para obten��o do bairro .
	 * @return bairro String contendo o bairro.
	 * */
	public String getBairro() {
		return bairro;
	}
	/**
	 * M�todo para defini��o do bairro.
	 * @param bairro String contendo o bairro.
	 * */
	public void setBairro(String bairro) {
		if(validador.validaString(bairro)) {
			this.bairro = bairro;
		}
	}
	/**
	 * M�todo para obten��o do cep.
	 * @return cep String contendo o CEP.
	 * */
	public String getCep() {
		return cep;
	}
	/**
	 * M�todo para defini��o do cep.
	 * @param cep String contendo o CEP.
	 * */
	public void setCep(String cep) {
		if(validador.validaString(cep)){
			this.cep = cep;
		}
	}
	/**
	 * M�todo para obten��o do n�mero.
	 * @return numero Int contendo o n�mero da resid�ncia.
	 * */
	public int getNumero() {
		return numero;
	}
	/**
	 * M�todo para defini��o do n�mero.
	 * @param numero Int contendo o n�mero da resid�ncia.
	 * */
	public void setNumero(int numero) {
		if(validador.validaNumero(numero)){
			this.numero = numero;
		}
			
	}
	/**
	 * M�todo para obten��o do Complemento do endere�o.
	 * @return complemento String contendo o complemento do endere�o.
	 * */
	public String getComplemento() {
		return complemento;
	}
	/**
	 * M�todo para defini��o do Complemento do endere�o.
	 * @param complemento String contendo o complemento do endere�o.
	 * */	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
