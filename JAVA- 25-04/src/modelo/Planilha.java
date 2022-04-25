package modelo;


static String entrada = "C:\\Users\\desenvolvimento\\Desktop\\Programas-em-Java\\JAVA- 25-04\\Arquivos\\arquivos.csv";
public class Planilha {
	private int v1;
	private int v2;
	
	Planilha(String entrada){
		v1 = Integer.parseInt(entrada.split(";") [0]);
		v2 = Integer.parseInt(entrada.split(";") [1]);
	}
	
	//Metodos para o  Processamento
	public int adicao() {
		return v1 + v2;
	}
	public int multiplicacao() {
		return v1 * v2;
	}
	public int subtracao() {
		return v1 - v2;
	}
	public int divisao() {
		return v1 / v2;
	}
}
