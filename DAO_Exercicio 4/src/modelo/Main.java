package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int opcao = 0;
		Arquivo arq = new Arquivo();

		do {
			System.out.println("1 - Entrar ");
			System.out.println("0 - Sair");
			opcao = scan.nextInt();
			scan.nextLine();

			switch (opcao) {


			case 1:

				ArrayList<String> infoFile = arq.ler("Login");

				System.out.println("Insira o usu�rio: ");
				String b1 = scan.next();

				System.out.println("Insira a senha: ");
				String b2 = scan.next();

	
		
				for (String linha : infoFile) {
					String[] temp = linha.split(";");
					if ((temp[0].toLowerCase().contains(b1.toLowerCase()))
							&& (temp[1].toLowerCase().contains(b2.toLowerCase()))) {
						System.out.println("Acesso permitido.");
						
						

					}
				}

				break;
			case 0:
				System.out.println("At� mais.");
				break;

			}

		} while (opcao != 0);

	}
}
