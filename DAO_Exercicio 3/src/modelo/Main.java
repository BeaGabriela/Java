package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	// Espaço de memória dinâmico para leitura(Abrir)
	static BufferedReader br;
	// Espaço de memória dinâmico para escrita(Salvar)
	static BufferedWriter bw;
	// Endereçp do aquivo de entrada
	static String entrada = "C:\\Users\\desenvolvimento\\Desktop\\Programas-em-Java\\DAO_Exercicio 3\\dados\\numeros.txt";
	static String saida;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// Menu
		int opcao = 0;
		while (opcao != 3) {
			System.out.println("\n1. 1-Mostrar em ordem crescente.");
			opcao = scan.nextInt();

			// Abrir o arquivo tratando os possíveis erros
			try {
				// Abre o arquivo
				br = new BufferedReader(new FileReader(entrada));
//				bw = new BufferedWriter(new FileWriter(entrada, false));
				String linha = br.readLine();// Lê a primeira linha
				while (linha != null) {
					String[] vetor = linha.split(";");
					int v1 = Integer.parseInt(vetor[0]);
					int v2 = Integer.parseInt(vetor[1]);
					int primeiro = 0;
					int segundo = 1;
					while (segundo < vetor.length) {
						// na ordenação crescente troca os valores quando o primeiro é maior que o
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
				linha = br.readLine();// Lê a próxima linha

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
