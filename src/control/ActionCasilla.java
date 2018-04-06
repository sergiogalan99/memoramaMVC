package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Carta;
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
		Carta carta = this.paraui.getControl().getCartas()[this.coordenada.getX()][this.coordenada.getY()];
		if(carta.isVelada()) {
			paraui.getAcciones().realizarJugada(this.coordenada);
		}
	}

}
