package controle;

import java.util.ArrayList;

import dao.ManutencaoDAO;
import modelo.Manutencao;

public class ProcessaManutencoes {

	public static ArrayList<Manutencao> manutencoes = new ArrayList<>();
	private static ManutencaoDAO md = new ManutencaoDAO();
	
	public static void abrir() {
		manutencoes=md.ler();
		if(manutencoes.size() ==0) {
			manutencoes.add(new Manutencao(1, "aro","20/02/2020",20,80));
		}
		
	}
	
	public static void salvar() {
		md.escrever(manutencoes);
//		manutencoes= md.ler();
	}
	
	public static void carregarTestes() {
		manutencoes = new ArrayList<>();
		manutencoes.add(new Manutencao(1,"motor", "20/02/2020",20,0.20));
		manutencoes.add(new Manutencao(2,"compressor","30/09/2021",60,60));
		manutencoes.add(new Manutencao(3,"carburador","01/12/2021",80,60));
	}
	
}
