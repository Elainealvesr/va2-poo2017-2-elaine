package br.unincor.controle;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Produto;
import br.unincor.model.Sanduiche;
import br.unincor.model.Sobremesa;
import br.unincor.view.Usuario;

public class Main {

	public static void main(String[] args) {
		
			Usuario view = new Usuario();
			CalculaPrecos calc = new CalculaPrecos();
			List<Produto> listProduto = new ArrayList<Produto>();
		
			Integer op = 0;
			while(op != -1 && op != 2) {
				op = view.exibeMenuPrincipal();
				
				try {
					if(op == 0) {
						//sanduiche
						Sanduiche sanduiche = new Sanduiche("Nome X ",
								 10.0, 
								 true, 
								 false);
						calc.calculaPrecoFinal(sanduiche);
						listProduto.add(sanduiche);
					} else if(op == 1) {
						//sobremesa
						Sobremesa sobremesa = new Sobremesa("Sobremesa X", 
								10.0, 
								true);
						calc.calculaPrecoFinal(sobremesa);
						listProduto.add(sobremesa);
					}
				} catch (PrecoZeradoException pze) {
					view.exibeMsg(pze.getMessage());
				}
			}
			
			Integer opPagto = view.exibeMenuPagamento();
			Double valorFinal = 0.0;
			if(opPagto == 1) {
				//Cartão
				valorFinal = calc.pagtoCartao(listProduto);
			} else {
				//Dinheiro
				valorFinal = calc.pagtoDinheiro(listProduto);
			}
			
			view.exibeMsg("Resumo do pedido");
			for (Produto produto : listProduto) {
				view.exibeMsg(produto.verDados());
			}
			DecimalFormat df = new DecimalFormat("0.00"); 
			view.exibeMsg("Valor final: R$" + df.format(valorFinal));
		
	}
}