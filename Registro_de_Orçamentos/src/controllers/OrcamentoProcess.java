package controllers;

import java.util.ArrayList;

import dao.OrcamentoDAO;
import modelo.Orcamento;

public class OrcamentoProcess {
	public static ArrayList<Orcamento>orcamento= new ArrayList<>();
	private static OrcamentoDAO od = new OrcamentoDAO();
	
	public static void compararProdutos(String produto) {
			int b = 0;
			double pb = 9999999;
			for (Orcamento orc : orcamento) {
				if (orc.getProduto().equals(produto) && orc.getPreco() < pb) {
					b = orcamento.indexOf(orc);
					pb = orc.getPreco();
				}
			}
			
			for (Orcamento orc : orcamento) {
				if (orcamento.indexOf(orc) == b) {
					orc.setMaisBarato(true);
				} else if(orc.getProduto() == produto) {
					orc.setMaisBarato(false);
				}
			}
			
		}
		
	
	public static boolean salvar() {
		od.escrever(orcamento);
		return true;
	}
	
	public static void abrir() {
		orcamento = od.ler();
		if(orcamento.size() == 0) {
			orcamento.add(new Orcamento(1, "Mario", "Caixa", 50, true));
			
		}
		
	}
	
}
