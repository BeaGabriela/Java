package modelo;

import java.util.Date;
import java.util.Objects;

public class Manutencao {
	private int id;
	private String data;
	private String equipamento;
	private double custoHora;
	private double tempoGasto;
	
	public Manutencao(int id, String data, String equipamento, double custoHora, double tempoGasto) {
		this.id = id;
		this.data = data;
		this.equipamento = equipamento;
		this.custoHora = custoHora;
		this.tempoGasto = tempoGasto;
	}
	public Manutencao(String manu) {
		this.id = Integer.parseInt(manu.split(";")[0]);
		this.data = manu.split(";")[1];
		this.equipamento =  manu.split(";")[2];
		this.custoHora = Double.parseDouble(manu.split(";")[3]);;
		this.tempoGasto = Double.parseDouble(manu.split(";")[4]);;
		
	}
	
	public int hashcode() {
		return Objects.hash(id);
	}
	public Manutencao(int id) {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
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
	public void setCustoHora(double custoHora) {
		this.custoHora = custoHora;
	}
	public double getTempoGasto() {
		return tempoGasto;
	}
	public void setTempoGasto(double tempoGasto) {
		this.tempoGasto = tempoGasto;
	}
	

	
	@Override
	public String toString() {
		return  id + "\t"+ data + ", equipamento=" + equipamento + "\t" + custoHora
				+ "\t" + tempoGasto;
	}
	public String toCSV() {
		return id + "\t" + data + "\t" + equipamento + "\t" + custoHora
				+ "\t" + tempoGasto;
	}
	public String getCustoHora(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getTempoGasto(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getId(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
