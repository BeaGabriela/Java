package controle;

import java.util.ArrayList;
import DAO.Dao;

import modelo.Venda;

public class VendaProcess {
	
	public static ArrayList<Venda> vendas = new ArrayList<>();
	private static Dao dao = new Dao();
	
	public static void abrir() {
		vendas = dao.ler();
	}
	
	public static void salvar() {
		dao.escrever(vendas);
	}

}
