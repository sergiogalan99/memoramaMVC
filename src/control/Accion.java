package control;

import java.awt.Image;
import javax.swing.ImageIcon;
import modelo.Carta;
import modelo.Coordenada;
import modelo.Tablero;

public class Accion implements Comprobable {

	private ParaUI paraui;
	private Tablero control;

	public Accion(ParaUI paraui, Tablero control) {
		this.paraui = paraui;
		this.control = control;
	}

	public Accion(ParaUI paraui) {
		this.paraui = paraui;
	}

	public void realizarJugada(Coordenada coordenada) {
		establecerIcono(coordenada);
		
		if (marcarCarta(coordenada, this.control.getCartas()) && !comprobarMarcable(this.control.getCartas())) {
			if (comprobarParejas(this.control.getCartas())) {
				System.out.println("Son parejas");
				desvelarMarcadas();
			} else {
				System.out.println("No son parejas");
				borrarMarcadas();
			}
			this.control.setJugadas(this.control.getJugadas() + 1);
			this.paraui.getNumJugadas().setText(String.valueOf(this.control.getJugadas()));
			desmarcarCartas(this.control.getCartas()); // Siempre hay que desmarcar todas para la siguiente jugada
		}
		
		if(comprobarCompletado(this.control.getCartas())) {
			this.paraui.getMensaje().setVisible(true);
		}
	}

	@Override
	public boolean comprobarParejas(Carta[][] cartas) {
		Carta cartaUno = null;
		Carta cartaDos = null;

		for (int i = 0; i < cartas.length; i++) {
			for (int j = 0; j < cartas.length; j++) {
				if (cartas[i][j].isMarcada()) {
					if (cartaUno == null) {
						cartaUno = cartas[i][j];
					} else {
						cartaDos = cartas[i][j];
					}
				}
			}
		}

		return cartaUno.getValor() == cartaDos.getValor();
	}

	@Override
	public boolean comprobarMarcable(Carta[][] cartas) {
		int marcadas = 0;
		for (int i = 0; i < cartas.length; i++) {
			for (int j = 0; j < cartas.length; j++) {
				if (cartas[i][j].isMarcada()) {
					marcadas++;
				}
			}
		}
		return marcadas < 2;
	}
	
	@Override
	public boolean comprobarCompletado(Carta[][] cartas) {
		for (int i = 0; i < cartas.length; i++) {
			for (int j = 0; j < cartas.length; j++) {
				if(cartas[i][j].isVelada()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void establecerIcono(Coordenada coordenada) {
		Carta carta = this.control.getCartas()[coordenada.getX()][coordenada.getY()];
		
		this.paraui.getBotonera().getBotonera()[coordenada.getX()][coordenada.getY()].setIcon(createScaledIcon(new ImageIcon(getClass().getResource(this.control.getImagenesCartas()[carta.getValor() - 1])), this.paraui.getBotonera().getBotonera()[0][0].getHeight()));
	}

	public boolean marcarCarta(Coordenada coordenadas, Carta[][] cartas) {
		Carta carta = cartas[coordenadas.getX()][coordenadas.getY()];

		if (carta.isVelada() && comprobarMarcable(cartas)) {
			cartas[coordenadas.getX()][coordenadas.getY()].setMarcada(true);
			return true;
		} else {
			return false;
		}
	}

	public void desmarcarCartas(Carta[][] cartas) {
		for (int i = 0; i < cartas.length; i++) {
			for (int j = 0; j < cartas.length; j++) {
				cartas[i][j].setMarcada(false);
			}
		}
	}
	
	/**
	 * Escala un icono en base a una medida
	 * 
	 * @param Imagen Icono a escalar
	 * @param height Medida con la que escalar
	 * @return Icono escalado
	 */
	public ImageIcon createScaledIcon(ImageIcon Imagen, int height) {
		return new ImageIcon(Imagen.getImage().getScaledInstance(height - 20, height - 20, Image.SCALE_SMOOTH));
	}

	public void bloquearCartas() {
		for (int i = 0; i < this.paraui.getDimension(); i++) {
			for (int j = 0; j < this.paraui.getDimension(); j++) {
				this.paraui.getBotonera().getBotonera()[i][j].setEnabled(false);
			}
		}
	}

	public void borrarMarcadas() {
		for (int i = 0; i < this.paraui.getDimension(); i++) {
			for (int j = 0; j < this.paraui.getDimension(); j++) {
				if (this.control.getCartas()[i][j].isMarcada()) {
					this.paraui.getBotonera().getBotonera()[i][j].setIcon(null);
				}
			}
		}
	}

	public void desvelarMarcadas() {
		for (int i = 0; i < this.paraui.getDimension(); i++) {
			for (int j = 0; j < this.paraui.getDimension(); j++) {
				if (this.control.getCartas()[i][j].isMarcada()) {
					this.control.getCartas()[i][j].setVelada(false);
				}
			}
		}
	}
	
	public void reiniciar() {
		this.paraui.getMensaje().setVisible(false);
		this.paraui.getNumJugadas().setText(String.valueOf(this.control.getJugadas()));
		for (int i = 0; i < this.control.getDimension(); i++) {
			for (int j = 0; j < this.control.getDimension(); j++) {
				this.paraui.getBotonera().getBotonera()[i][j].setIcon(null);
			}
		}
	}

	public ParaUI getParaui() {
		return paraui;
	}

	public Tablero getControl() {
		return control;
	}

	public void setParaui(ParaUI paraui) {
		this.paraui = paraui;
	}

	public void setControl(Tablero control) {
		this.control = control;
	}

}
