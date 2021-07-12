package br.com.estacionamento.model;


public class Movimentacao {

	private String codigo;
	private String placa;
	private String modelo;
	private String dataEntrada;//For reference
	private String horaEntrada;
	private String dataSaida;//For reference
	private String horaSaida;
	private double tempo;
	private double valor;
	
		
	
	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String getDataEntrada() {
		return dataEntrada;
	}



	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}



	public String getHoraEntrada() {
		return horaEntrada;
	}



	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}



	public String getDataSaida() {
		return dataSaida;
	}



	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}



	public String getHoraSaida() {
		return horaSaida;
	}



	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}



	public double getTempo() {
		return tempo;
	}



	public void setTempo(double tempo) {
		this.tempo = tempo;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public String toStringEntrada(){
		return  codigo + ";" + placa + ";" + modelo + ";" + dataEntrada + ";"
				+ horaEntrada + ";" + "01/01/2000" + ";" + "00:00" + ";" + 0 + ";" + 00;
	}
	
	public String toStringSaida()  {
		return codigo + ";" + placa + ";" + modelo + ";" + dataEntrada + ";" + horaEntrada + 
				";" + dataSaida + ";" + horaSaida + ";" + tempo + ";" + valor;
		
	}
}
