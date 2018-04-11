package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Botonera extends JPanel {

	private JButton[][] botonera;
	private Color cartaVelada = new Color(202, 49, 49);

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
				this.add(botonera[i][j]);
			}
		}

	}
	
	private void establecerPropiedades(JButton boton) {
		boton.setBackground(this.cartaVelada);
		boton.setFont(new Font("Sans Serif", Font.BOLD, 18));
		boton.setFocusPainted(false);
		boton.setBorder(null);
	}
	
	public void deshabilitarBoton(JButton boton) {
		boton.setEnabled(false);
	}

	public JButton[][] getBotonera() {
		return botonera;
	}

	public Color getCartaVelada() {
		return cartaVelada;
	}

	public void setCartaVelada(Color cartaVelada) {
		this.cartaVelada = cartaVelada;
	}
}