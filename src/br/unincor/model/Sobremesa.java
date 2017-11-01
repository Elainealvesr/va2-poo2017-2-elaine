package br.unincor.model;

/**
 * Implementar relacionamento de herança
 * com a classe "Produto"
 *
 */
public class Sobremesa extends Produto{
	
	private Boolean adicionais; //Define se adiciona mais alguns ingredientes - sem validação

	public Sobremesa(String nome, Double preco, Boolean adicionais) {
		super(nome, preco);
		this.adicionais = adicionais;
	}


	public Boolean getAdicionais() {
		return adicionais;
	}


	public void setAdicionais(Boolean adicionais) {
		this.adicionais = adicionais;
	}


	public String verDados() {
		return super.verDados() + "\nAdicionais: " + this.adicionais; 
	}
}
