package br.com.estacionamento.app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.estacionamento.ui.FrameMovimentacao;

import javax.swing.UIManager.LookAndFeelInfo;

public class AppP {

public static void main(String[] args) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
			
//			UIManager.setLookAndFeel(
//		            UIManager.getSystemLookAndFeelClassName());
			
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
		} catch (ClassNotFoundException e) {
		    // handle exception
		} catch (InstantiationException e) {
		    // handle exception
		} catch (IllegalAccessException e) {
		    // handle exception
		}
		
		FrameMovimentacao telaMovimentacao = new FrameMovimentacao();
		telaMovimentacao.criarTela();

	}

}

