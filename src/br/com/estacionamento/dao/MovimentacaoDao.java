package br.com.estacionamento.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import br.com.estacionamento.model.Movimentacao;

public class MovimentacaoDao {

	private Movimentacao movimentacao;

	private static final String LOCAL_ARQUIVO = "C:/Users/Fernada/DS1M-FPOO/estacionamentoP/movimentacao.ds1";

	public MovimentacaoDao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public MovimentacaoDao() {

	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void salvarEntrada() {

		Path path = Paths.get(LOCAL_ARQUIVO);

		try {
			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("ISO-8859-1"),
					StandardOpenOption.WRITE, StandardOpenOption.APPEND);

			writer.write(movimentacao.toStringEntrada());
			writer.newLine();
			writer.close();

		} catch (Exception e) {
			System.out.println("ERRO!");
			e.printStackTrace();
		}
	} // end of salvarEntrada

	public void salvarSaida() {

		Path path = Paths.get(LOCAL_ARQUIVO);

		try {
			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("ISO-8859-1"),
					StandardOpenOption.WRITE, StandardOpenOption.APPEND);

			writer.write(movimentacao.toStringSaida());
			writer.newLine();
			writer.close();

		} catch (Exception e) {
			System.out.println("ERRO!");
			e.printStackTrace();
		}
	} // end of salvarSaida

	public ArrayList<Movimentacao> listarMovimentos() {
		Path path = Paths.get(LOCAL_ARQUIVO);

		try {

			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));

			String linha = reader.readLine();
			ArrayList<Movimentacao> movimentos = new ArrayList<>();

			while (linha != null) {
				String[] vetorMovimentos = linha.split(";");

				Movimentacao movimento = new Movimentacao();
				movimento.setCodigo(vetorMovimentos[0]);
				movimento.setPlaca(vetorMovimentos[1]);
				movimento.setModelo(vetorMovimentos[2]);
				movimento.setDataEntrada(vetorMovimentos[3]);
				movimento.setHoraEntrada(vetorMovimentos[4]);

				movimentos.add(movimento);

				linha = reader.readLine();
			}

			System.out.println(movimentacao);

			reader.close();

			return movimentos;

		} catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
			e.printStackTrace();
			return null;
		}
	}// end of listarClientes

	public Movimentacao buscarCarro(String placa) {
		Path path = Paths.get(LOCAL_ARQUIVO);

		try {

			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));

			String linha = reader.readLine();
			movimentacao = new Movimentacao();

			while (linha != null) {
				String[] vetorMovimentos = linha.split(";");

				if (vetorMovimentos[1].equals(placa)) {

					movimentacao.setCodigo(vetorMovimentos[0]);
					movimentacao.setPlaca(vetorMovimentos[1]);
					movimentacao.setModelo(vetorMovimentos[2]);
					movimentacao.setDataEntrada(vetorMovimentos[3]);
					movimentacao.setHoraEntrada(vetorMovimentos[4]);
					movimentacao.setDataSaida(vetorMovimentos[5]);
					movimentacao.setHoraSaida(vetorMovimentos[6]);
					movimentacao.setTempo(Double.parseDouble(vetorMovimentos[7]));
					movimentacao.setValor(Double.parseDouble(vetorMovimentos[8]));
					break;
				} 

				linha = reader.readLine();
			}

			System.out.println(movimentacao);

			reader.close();

			return movimentacao;

		} catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
			e.printStackTrace();
			return null;
		}
	}// end of buscarClientes

}
