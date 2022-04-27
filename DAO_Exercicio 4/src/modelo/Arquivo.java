
	package modelo;

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.util.ArrayList;

	public class Arquivo {
		
		private String email;
		private String senha;
		
		
		private String entrada="C:\\Users\\desenvolvimento\\Desktop\\Programas-em-Java\\DAO_Exercicio 4\\dados\\usuarios.csv";
		public void cadastrar(String info) {
			email = entrada.split(";")[0];
			senha = entrada.split(";")[1];
			try {
				FileWriter fw = new FileWriter(entrada);
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(info);

				bw.close();
				fw.close();

			} catch (Exception e) {

			}
		}

		public ArrayList<String> ler(String fileNames) {
			ArrayList<String> aleatorios = new ArrayList<>();
			try {
				FileReader fr = new FileReader("Aleatorios.txt");
				BufferedReader br = new BufferedReader(fr);

				String linha = "";
				while ((linha = br.readLine()) != null) {
					aleatorios.add(linha);
				}
				br.close();
				fr.close();
			} catch (Exception e) {

			}
			return aleatorios;
		}

	}


