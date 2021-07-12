package br.com.estacionamento.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.estacionamento.dao.MovimentacaoDao;
import br.com.estacionamento.model.Movimentacao;
import br.com.estacionamento.util.Util;

public class FrameMovimentacao {

	private JLabel labelEntrada;
	private JLabel labelPlaca;
	private JTextField textPlaca;
	private JLabel labelModelo;
	private JTextField textModelo;
	private JButton buttonEntrar;

	private JTable tabelaMovimentacao;
	private DefaultTableModel tabelaMovimentacaoModel;
	private JScrollPane scrollTabelaMovimentacao;

	private JLabel labelSaida;
	private JLabel labelBusca;
	private JTextField textBusca;
	private JButton buttonBuscar;
	private JLabel labelModeloBusca;
	private JTextField textModeloBusca;
	private JLabel labelDataEntrada;
	private JTextField textDataEntrada;
	private JLabel labelHoraEntrada;
	private JTextField textHoraEntrada;
	private JLabel labelDataSaida;
	private JTextField textDataSaida;
	private JLabel labelHoraSaida;
	private JTextField textHoraSaida;
	private JLabel labelTempo;
	private JTextField textTempo;
	private JLabel labelValor;
	private JTextField textValor;
	private JButton buttonEfetuaSaida;
	private JButton buttonFechaSistema;

	public void criarTela() {

		JFrame tela = new JFrame();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Movimentação Diária");
		tela.setSize(660, 570);
		tela.setLayout(null);
		tela.setResizable(false);

		labelEntrada = new JLabel("ENTRADA");
		labelEntrada.setBounds(20, 20, 70, 30);

		labelPlaca = new JLabel("Placa:");
		labelPlaca.setBounds(20, 50, 70, 30);
		textPlaca = new JTextField();
		textPlaca.setBounds(20, 80, 150, 30);

		labelModelo = new JLabel("Modelo:");
		labelModelo.setBounds(190, 50, 80, 30);
		textModelo = new JTextField();
		textModelo.setBounds(190, 80, 150, 30);

		buttonEntrar = new JButton("ENTRAR");
		buttonEntrar.setBounds(360, 75, 150, 35);

		// creating model of Table
		tabelaMovimentacaoModel = new DefaultTableModel();
		tabelaMovimentacaoModel.addColumn("Código");
		tabelaMovimentacaoModel.addColumn("Placa");
		tabelaMovimentacaoModel.addColumn("Modelo");
		tabelaMovimentacaoModel.addColumn("Data Entrada");

		// criaçãoVetor = each line in table
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao();
		ArrayList<Movimentacao> movimentos = movimentacaoDao.listarMovimentos();
		for (Movimentacao movimentacao : movimentos) {
			String[] vetorMovimentos = { movimentacao.getCodigo(), movimentacao.getPlaca(), movimentacao.getModelo(),
					movimentacao.getDataEntrada() };
			tabelaMovimentacaoModel.addRow(vetorMovimentos);
		}

		// creating table
		tabelaMovimentacao = new JTable(tabelaMovimentacaoModel);

		// define the large of the table
		tabelaMovimentacao.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaMovimentacao.getColumnModel().getColumn(1).setPreferredWidth(220);
		tabelaMovimentacao.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabelaMovimentacao.getColumnModel().getColumn(3).setPreferredWidth(90);

		// stop changing of columns
		tabelaMovimentacao.getTableHeader().setReorderingAllowed(false);

		// creating scroll and put in the table
		scrollTabelaMovimentacao = new JScrollPane(tabelaMovimentacao);
		scrollTabelaMovimentacao.setBounds(20, 130, 600, 100);

		labelSaida = new JLabel("SAÍDA");
		labelSaida.setBounds(20, 250, 60, 30);

		labelBusca = new JLabel("Placa:");
		labelBusca.setBounds(20, 280, 70, 30);
		textBusca = new JTextField();
		textBusca.setBounds(20, 310, 150, 30);

		buttonBuscar = new JButton("BUSCAR");
		buttonBuscar.setBounds(190, 305, 150, 35);

		labelModeloBusca = new JLabel("Modelo:");
		labelModeloBusca.setBounds(20, 360, 70, 30);
		textModeloBusca = new JTextField();
		textModeloBusca.setBounds(20, 390, 85, 30);

		labelDataEntrada = new JLabel("Data Entrada:");
		labelDataEntrada.setBounds(125, 360, 100, 30);
		textDataEntrada = new JTextField();
		textDataEntrada.setBounds(125, 390, 85, 30);

		labelHoraEntrada = new JLabel("Hora Entrada:");
		labelHoraEntrada.setBounds(230, 360, 100, 30);
		textHoraEntrada = new JTextField();
		textHoraEntrada.setBounds(230, 390, 85, 30);

		labelDataSaida = new JLabel("Data Saída:");
		labelDataSaida.setBounds(335, 360, 100, 30);
		textDataSaida = new JTextField();
		textDataSaida.setBounds(335, 390, 85, 30);

		labelHoraSaida = new JLabel("Hora Saída:");
		labelHoraSaida.setBounds(440, 360, 100, 30);
		textHoraSaida = new JTextField();
		textHoraSaida.setBounds(440, 390, 85, 30);

		labelTempo = new JLabel("Tempo:");
		labelTempo.setBounds(545, 360, 100, 30);
		textTempo = new JTextField();
		textTempo.setBounds(545, 390, 70, 30);

		labelValor = new JLabel("Valor a Pagar:");
		labelValor.setBounds(20, 460, 80, 30);
		textValor = new JTextField();
		textValor.setBounds(110, 450, 160, 50);

		buttonEfetuaSaida = new JButton("EFETUAR SAÍDA");
		buttonEfetuaSaida.setBounds(290, 450, 160, 50);

		buttonFechaSistema = new JButton("FECHAR SISTEMA");
		buttonFechaSistema.setBounds(460, 450, 160, 50);

		tela.getContentPane().add(labelEntrada);
		tela.getContentPane().add(labelPlaca);
		tela.getContentPane().add(textPlaca);
		tela.getContentPane().add(labelModelo);
		tela.getContentPane().add(textModelo);
		tela.getContentPane().add(buttonEntrar);
		tela.getContentPane().add(scrollTabelaMovimentacao);
		tela.getContentPane().add(labelSaida);
		tela.getContentPane().add(labelBusca);
		tela.getContentPane().add(textBusca);
		tela.getContentPane().add(buttonBuscar);
		tela.getContentPane().add(labelModeloBusca);
		tela.getContentPane().add(textModeloBusca);
		tela.getContentPane().add(labelDataEntrada);
		tela.getContentPane().add(textDataEntrada);
		tela.getContentPane().add(labelHoraEntrada);
		tela.getContentPane().add(textHoraEntrada);
		tela.getContentPane().add(labelDataSaida);
		tela.getContentPane().add(textDataSaida);
		tela.getContentPane().add(labelHoraSaida);
		tela.getContentPane().add(textHoraSaida);
		tela.getContentPane().add(labelTempo);
		tela.getContentPane().add(textTempo);
		tela.getContentPane().add(labelValor);
		tela.getContentPane().add(textValor);
		tela.getContentPane().add(buttonEfetuaSaida);
		tela.getContentPane().add(buttonFechaSistema);

		tela.setVisible(true);

		buttonEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (validarFormularioEnter()) {
					Movimentacao movimento = new Movimentacao();
					movimento.setCodigo(br.com.estacionamento.util.Util.gerarCodigo());
					movimento.setPlaca(textPlaca.getText().toUpperCase());
					movimento.setModelo(textModelo.getText().toUpperCase());
					movimento.setDataEntrada(Util.dataParaString(LocalDate.now()));
					movimento.setHoraEntrada(Util.horaParaString(LocalTime.now()));

					MovimentacaoDao dao = new MovimentacaoDao(movimento);
					dao.salvarEntrada();

					JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!", "Informação",
							JOptionPane.INFORMATION_MESSAGE);

					limparFormularioEntrada();

				} else {
					JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos", "Atenção!",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		}); // end ListenerButton

		buttonBuscar.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				String placa;
				placa = textBusca.getText().toUpperCase();

				MovimentacaoDao dao = new MovimentacaoDao();
				Movimentacao movimentacao = dao.buscarCarro(placa);

				textBusca.setText(movimentacao.getPlaca());
				textModeloBusca.setText(movimentacao.getModelo());
				textDataEntrada.setText(movimentacao.getDataEntrada());
				textHoraEntrada.setText(movimentacao.getHoraEntrada());
				movimentacao.setDataSaida(Util.dataParaString(LocalDate.now()));
				textDataSaida.setText(movimentacao.getDataSaida());
				movimentacao.setHoraSaida(Util.horaParaString(LocalTime.now()));
				textHoraSaida.setText(movimentacao.getHoraSaida());
				movimentacao.setTempo(Util.calcTempo(Util.horaParaLocaTime(movimentacao.getHoraEntrada()), Util.horaParaLocaTime(movimentacao.getHoraSaida()), movimentacao.getTempo()));
				textTempo.setText(String.valueOf(movimentacao.getTempo()));
				movimentacao.setValor(Util.calcValor(movimentacao.getTempo(), 0));
				textValor.setText(String.valueOf(movimentacao.getValor()));
			}

		});
		
		buttonEfetuaSaida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validarFormularioSaida()) {
					Movimentacao movimento = new Movimentacao();
					movimento.setCodigo(br.com.estacionamento.util.Util.gerarCodigo());
					movimento.setPlaca(textBusca.getText().toUpperCase());
					movimento.setModelo(textModeloBusca.getText().toUpperCase());
					movimento.setDataEntrada(textDataEntrada.getText().toUpperCase());
					movimento.setHoraEntrada(textHoraEntrada.getText().toUpperCase());
					movimento.setDataSaida(textDataSaida.getText().toUpperCase());
					movimento.setHoraSaida(textHoraSaida.getText().toUpperCase());
					
					MovimentacaoDao dao = new MovimentacaoDao(movimento);
					dao.salvarSaida();

					JOptionPane.showMessageDialog(null, "Saída efetuada com sucesso!", "Informação",
							JOptionPane.INFORMATION_MESSAGE);

					limparFormularioSaida();

				} else {
					JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos", "Atenção!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
				
		});

	} // end criarTela

	private boolean validarFormularioEnter() {

		boolean valido = true;

		if (textPlaca.getText().trim().length() == 0) {
			labelPlaca.setForeground(Color.RED);
			valido = false;
		} else if (textModelo.getText().trim().length() == 0) {
			labelModelo.setForeground(Color.RED);
			valido = false;
		}

		return valido;
	}

	private boolean validarFormularioSaida() {

		boolean valido = true;

		if (textPlaca.getText().trim().length() == 0) {
			labelPlaca.setForeground(Color.RED);
			valido = false;
		} else if (textModelo.getText().trim().length() == 0) {
			labelModelo.setForeground(Color.RED);
			valido = false;
		} else if (textDataEntrada.getText().trim().length() == 0) {
			labelDataEntrada.setForeground(Color.RED);
			valido = false;
		} else if (textHoraEntrada.getText().trim().length() == 0) {
			labelHoraEntrada.setForeground(Color.RED);
			valido = false;
		} else if (textDataSaida.getText().trim().length() == 0) {
			labelDataSaida.setForeground(Color.RED);
			valido = false;
		} else if (textHoraSaida.getText().trim().length() == 0) {
			labelHoraSaida.setForeground(Color.RED);
			valido = false;
		} else if (textTempo.getText().trim().length() == 0) {
			labelTempo.setForeground(Color.RED);
			valido = false;
		} else if (textValor.getText().trim().length() == 0) {
			labelValor.setForeground(Color.RED);
			valido = false;
		}

		return valido;
	}

	private void limparFormularioEntrada() {

		textPlaca.setText("");
		textModelo.setText("");
		textPlaca.requestFocus();
	}
	
	
	private void limparFormularioSaida() {

		textPlaca.setText("");
		textModelo.setText("");
		textDataEntrada.setText("");
		textHoraSaida.setText("");
		textDataSaida.setText("");
		textTempo.setText("");
		textValor.setText("");
		textPlaca.requestFocus();
	}

}
