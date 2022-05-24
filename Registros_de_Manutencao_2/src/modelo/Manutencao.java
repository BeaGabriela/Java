package modelo;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Manutencao {
	private int id;
	private Date data;
	private  String equipamento;
	private double custoHora;
	private double tempoGasto;
	
	private final Locale BRASIL = new Locale("pt", "BR");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private DecimalFormat df = new DecimalFormat("#.00");
	
	public Manutencao(int id, String data, String equipamento, double custoHora, double tempoGasto) {
		this.id = id;
		try {
		this.data = sdf.parse(data);
		}catch (ParseException e) {
			System.out.println(e);
		}
		this.equipamento = equipamento;
		this.custoHora = custoHora;
		this.tempoGasto = tempoGasto;
	}
	public Manutencao(int id) {
		this.id=id;	
	}
	
	public Manutencao(String Linha) {
		df.setCurrency(Currency.getInstance(BRASIL));
		this.id = Integer.parseInt(Linha.split(";")[0]);
		try {
			this.data = sdf.parse(Linha.split(";")[1]);
			this.custoHora = Double.parseDouble(df.parse(Linha.split(";")[3]).toString());
			this.tempoGasto = Double.parseDouble(df.parse(Linha.split(";")[4]).toString());	
		}catch(ParseException e) {
			System.out.println(e);
		}
		this.equipamento = Linha.split(";")[2];	
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
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

	public Date getData() {
		return data;
	}
	
	public String getData(String s) {
		return sdf.format(data);
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public double getCustoHora() {
		return custoHora;
	}
	public String getCustoHora(String s) {
		return String.format(".2f", custoHora);
	}

	public void setCustoHora(double custoHora) {
		this.custoHora = custoHora;
	}

	public double getTempoGasto() {
		return tempoGasto;
	}
	
	public String getTempoGasto(String s) {
		return String.format(".2f", tempoGasto);
	}

	public void setTempoGasto(double tempoGasto) {
		this.tempoGasto = tempoGasto;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manutencao other = (Manutencao) obj;
		return Double.doubleToLongBits(custoHora) == Double.doubleToLongBits(other.custoHora)
				&& Objects.equals(data, other.data) && Objects.equals(equipamento, other.equipamento) && id == other.id
				&& Double.doubleToLongBits(tempoGasto) == Double.doubleToLongBits(other.tempoGasto);
	}
	
	public double getTotal() {
		return  tempoGasto*custoHora;
	}

	@Override
	public String toString() {
		return  id + "\t" + data + "\t" + equipamento + "\t" + String.format("%.2f",custoHora)
				+ "\t" + String.format("%.2f",tempoGasto) + getTotal();
	}
	
	
	public String toCSV() {
		return  id + ";" + sdf.format(data) + ";" + equipamento + ";" + String.format("%.2f",custoHora)
				+ ";" + String.format("%.2f",tempoGasto)+ ";" + getTotal() + "\r\n";
	}
	

	
}
