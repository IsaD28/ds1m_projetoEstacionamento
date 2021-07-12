package br.com.estacionamento.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Util {

	public static String gerarCodigo() {

		return UUID.randomUUID().toString().substring(0, 8).toUpperCase();

	}// end gerarCodigo

	public static String dataParaString(LocalDate data) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return df.format(data);
	}

	public static LocalDate dataParaLocalDate(String data) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld = LocalDate.parse(data, df);
		return ld;
	}

	public static String horaParaString(LocalTime hora) {
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm");
		return dt.format(hora);
	}

	public static LocalTime horaParaLocaTime(String hora) {
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime lt = LocalTime.parse(hora, dt);
		return lt;
	}

	public static double calcTempo(LocalTime lt1, LocalTime lt2, double tempo) {
		Duration d = Duration.between(lt1, lt2);
		tempo = d.toHours();
		System.out.println(tempo);
		return tempo;
	}

	public static double calcValor(double tempo, double valor) {
		
		if (tempo > 0.15) {
			 valor = 15 + ((tempo - 1) * 5);
		} else {
			 valor = 0;
			System.out.println("tolerância não ultrapassada");
		}
		
		return valor;
	}

}