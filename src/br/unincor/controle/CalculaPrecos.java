package br.unincor.controle;

import java.util.List;

import javax.swing.text.html.MinimalHTMLWriter;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Produto;
import br.unincor.model.Sanduiche;
import br.unincor.model.Sobremesa;


public class CalculaPrecos {
	
	public void calculaPrecoFinal(Produto produto) throws PrecoZeradoException {
		if(produto.getPreco() != null && produto.getPreco() != 0) {
			
			
			if(produto instanceof Sanduiche) {
				Sanduiche sanduiche = (Sanduiche)produto;
				
				if(sanduiche.getTrio()) {
					sanduiche.setPreco(sanduiche.getPreco()+ 7.0);
				} else {
					sanduiche.setPreco(sanduiche.getPreco() + 0.5);
				}
				
			} else if(produto instanceof Sobremesa) {
				Sobremesa sobremesa = (Sobremesa)produto;
				
				if(sobremesa.getAdicionais()) {
					sobremesa.setPreco(sobremesa.getPreco() + 0.15);
				} else {
					
				}
			}
			
		} else {
		//produto zerado
			throw new PrecoZeradoException(produto);
		}
	}

	public Double pagtoDinheiro(List<Produto> listProduto) {
		Double somaPreco = 0.0;
		
		for (Produto produto : listProduto) {
			somaPreco += produto.getPreco();
		}
		
		return somaPreco - 0.15;
	}
	
	public Double pagtoCartao(List<Produto> listProduto) {
		Double somaPreco = 0.0;
		
		for (Produto produto : listProduto) {
			somaPreco += produto.getPreco();
		}
		
		return somaPreco * 0.07;
	}
}














