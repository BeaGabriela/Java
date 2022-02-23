package classicos;

import java.util.Random;
import java.util.Scanner;

public class Acumula {
	public static Random rand;
	public static Scanner acumula;
	public static void main(String[] args) {
		System.out.println("Acumulador Simples: ");
		System.out.println("      ");  
		System.out.println("O algoritimo de acumula��o: ");
		System.out.print("Simples, retornou = ");
		System.out.println(simples(345));
		
		System.out.println("-----------------------------");
		
		System.out.println("Acumulador Aleatorio:");
		System.out.println("          ");
		System.out.println("Total = " + aleatorio(345));
		
		System.out.println("-----------------------------");
		System.out.println("Fatorial: ");
		System.out.println("     ");
		
		
		System.out.println("\nTotal fatorial: " + fatorial());
		
		emprestimo(1000,10000,0.1);
		
	} //Acumula��o.
		public static int simples(int interacoes) {
			int x= 0;
			for(int i = 0; i < interacoes; i++)
			x+=i;
			
			return x;
}
		// Acumua��o aleat�ria;
		public static int aleatorio(int interacoes) {
			rand = new Random();
			int x= 0;
			int r=0;
			for(int i = 0; i < interacoes; i++) {
				r = rand.nextInt(100);
				System.out.println("Aleat�rio = " + r);
				x+=r;
				System.out.println("Acumulado = " + x);
			}
			
			return x;
}
		//Fatorial;
		public static int fatorial () {
			acumula = new Scanner(System.in);
			System.out.println("Digite um n�mero para saber o fatorial: ");
			int numero = acumula.nextInt();
			int f = 1;
			for (int i =1; i <= numero; i++) {
				f *= i;
				System.out.println("O fatorial de " + numero + " = " + f);
				
				
			}
			return f;
				
		}
		
		

