package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Orcamento;

public class OrcamentoDAO {
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo="C:\\Users\\desenvolvimento\\Desktop\\Programas-em-Java\\Registro_de_Orçamentos\\orcamentos\\orcamentos.csv";
	private ArrayList<Orcamento> orcamentos = new ArrayList<>();
	
	public ArrayList<Orcamento> ler(){
		Orcamento orc;
		try {
			br = new BufferedReader (new FileReader(arquivo));
			String linha = br.readLine();
			while(linha != null) {
				orc = new Orcamento(linha);
				orcamentos.add(orc);
				linha = br.readLine();
			}
			br.close();
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
		}
		return orcamentos;	
	}
	
	public void escrever(ArrayList<Orcamento> vs) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo));
			for(Orcamento or : vs) {
				bw.write(or.toCSV());
			}
			bw.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
