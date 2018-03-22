package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Coordenada;

public class ActionCasilla implements ActionListener {

	ParaUI paraui;
	Coordenada coordenada = new Coordenada();
	
	public ActionCasilla(ParaUI paraui) {
		this.paraui= paraui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.coordenada.setCoordenadas((((JButton) e.getSource()).getName()));
		paraui.getAcciones().realizarJugada(this.coordenada);
	}

}
