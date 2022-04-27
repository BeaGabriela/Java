package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	// Espa�o de mem�ria din�mico para leitura(Abrir)
	static BufferedReader br;
	// Espa�o de mem�ria din�mico para escrita(Salvar)
	static BufferedWriter bw;
	// Endere�p do aquivo de entrada
	static String entrada = "C:\\Users\\desenvolvimento\\Desktop\\Programas-em-Java\\DAO_Exercicio 3\\dados\\numeros.txt";
	static String saida;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// Menu
		int opcao = 0;
		while (opcao != 3) {
			System.out.println("\n1. 1-Mostrar em ordem crescente.");
			opcao = scan.nextInt();

			// Abrir o arquivo tratando os poss�veis erros
			try {
				// Abre o arquivo
				br = new BufferedReader(new FileReader(entrada));
//				bw = new BufferedWriter(new FileWriter(entrada, false));
				String linha = br.readLine();// L� a primeira linha
				while (linha != null) {
					String[] vetor = linha.split(";");
					int v1 = Integer.parseInt(vetor[0]);
					int v2 = Integer.parseInt(vetor[1]);
					int primeiro = 0;
					int segundo = 1;
					while (segundo < vetor.length) {
						// na ordena��o crescente troca os valores quando o primeiro � maior que o
						// segundo
						if (v1 > v2) {
							int troca = v1;
							v1 = v2;
							v2 = troca;
							primeiro = 0;
							segundo = 1;
						} else {
							primeiro++;
							segundo++;
						}
						
					}
					System.out.println(linha);
				}
				
				bw.write(linha + "\r\n");
				linha = br.readLine();// L� a pr�xima linha

				// Fecha o arquivo
				br.close();
				bw.close();
			} catch (

			FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Adeus.");

	}
}
