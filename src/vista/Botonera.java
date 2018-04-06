package vista;

import java.awt.Color;
import java.awt.Font;

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
				botonera[i][j].setName(String.valueOf(i) + String.valueOf(j));
				establecerPropiedades(botonera[i][j]);
				System.out.print(botonera[i][j].getName() + " ");
				this.add(botonera[i][j]);
			}
			System.out.println();
		}
	}
	
	private void establecerPropiedades(JButton boton) {
		boton.setBackground(Color.WHITE);
		boton.setFont(new Font("Sans Serif", Font.BOLD, 18));
		boton.setFocusPainted(false);
	}
	
	public void deshabilitarBoton(JButton boton) {
		boton.setEnabled(false);
	}

	public JButton[][] getBotonera() {
		return botonera;
	}
}