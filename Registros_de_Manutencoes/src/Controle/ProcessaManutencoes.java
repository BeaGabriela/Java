package Controle;

import java.util.ArrayList;

import DAO.ManutencaoDAO;
import modelo.Manutencao;

public class ProcessaManutencoes {
	public static ArrayList<Manutencao>manutencao = new ArrayList<>();
	private static ManutencaoDAO md = new ManutencaoDAO();
	
	public static void abrir() {
		manutencao = md.ler();
		
	}
	
public static void salvar() {
	md.escrever(manutencao);
	
}


}
