package controllers;

import java.util.ArrayList;

import dao.OrcamentoDAO;
import modelo.Orcamento;

public class OrcamentoProcess {
	public static ArrayList<Orcamento>orcamento= new ArrayList<>();
	private static OrcamentoDAO od = new OrcamentoDAO();
	
	public boolean comprarProdutos() {
		return false;
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
