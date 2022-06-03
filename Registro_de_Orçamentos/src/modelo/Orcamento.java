package modelo;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;

public class Orcamento {
	private int id;
	private String fornecedor;
	private String produto;
	private double preco;
	private String maisBarato;

	private final Locale BRASIL = new Locale("pt", "BR");
	private DecimalFormat df = new DecimalFormat("#.00");

	public Orcamento(int id, String fornecedor, String produto, double preco, String maisBarato) {
		super();
		this.id = id;
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.preco = preco;
		this.maisBarato = maisBarato;
	}

	public Orcamento(int id) {
		this.id = id;
	}

	public Orcamento(String linha) {
		df.setCurrency(Currency.getInstance(BRASIL));
		this.id = Integer.parseInt(linha.split(";")[0]);
		this.fornecedor = linha.split(";")[1];
		this.produto = linha.split(";")[2];
		try {
			this.preco = Double.parseDouble(df.parse(linha.split(";")[3]).toString());
		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	public int getId() {
		return id;
	}
	
	public String getId(String s) {
		return String.format("%d", id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getPreco() {
		return preco;
	}
	
	public String getPreco(String s) {
		return String.format("%.2f", preco);
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getMaisBarato() {
		boolean b = false;
		int BARATO = 0;
		for(int i=0; i< preco;i++) {
			if(preco < BARATO) {
				b = true;
			}
			
			
		}
		return maisBarato;
		
		
	}

	public void setMaisBarato(String maisBarato) {
		this.maisBarato = maisBarato;

	}

	public double Equals(double preco) {
		double menor=0;
		if(preco < menor) {
			menor=preco;
			
		}
		return preco;
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orcamento other = (Orcamento) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return  id + "\t" + fornecedor + "\t" + produto + String.format("%.2f", preco) + "\t"
			 + maisBarato ;
	}

	public String toCSV() {
		return  id + ";" + fornecedor + ";" + produto + ";" + preco
				+ ";" + maisBarato+"\r\n";
	}

}
