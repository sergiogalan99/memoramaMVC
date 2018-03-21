package vista;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Botonera extends JPanel {

	private JButton[][] botonera;

	public Botonera(int dimension) {
		super();
		rellenarBotonera(dimension);
	}

	private void rellenarBotonera(int dimension) {
		botonera = new JButton[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				botonera[i][j] = new JButton();
				this.add(botonera[i][j]);
			}
		}
	}
}
