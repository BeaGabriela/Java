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
			manutencoes.add(new Manutencao(1,"20/02/2020","aro",20,80));
		}
		
	}
	
	public static void salvar() {
		md.escrever(manutencoes);
//		manutencoes= md.ler();
	}
	
	public static void carregarTestes() {
		manutencoes = new ArrayList<>();
		manutencoes.add(new Manutencao(1, "20/02/2020","motor",20,20));
		manutencoes.add(new Manutencao(2,"30/09/2021","compressor",60,60));
		manutencoes.add(new Manutencao(3,"01/12/2021","carburador",80,60));
	}
	
}
