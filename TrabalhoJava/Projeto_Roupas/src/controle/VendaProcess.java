package controle;

import java.util.ArrayList;

import modelo.Venda;

public class VendaProcess {
	
	public static ArrayList<Venda> vendas = new ArrayList<>();
	private static DAO dao = new DAO();
	
	public static void abrir() {
		vendas = dao.ler();
	}
	
	public static void salvar() {
		dao.escrever(vendas);
	}

}
