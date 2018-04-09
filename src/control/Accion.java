package control;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import modelo.Carta;
import modelo.Coordenada;
import modelo.Tablero;

public class Accion implements Comprobable, Marcable {

	private ParaUI paraui;
	private Tablero control;
	private Timer timer;

	public Accion(ParaUI paraui, Timer timer) {
		this.paraui = paraui;
		this.timer = timer;
	}

	public boolean realizarJugada(Coordenada coordenada) {
		this.timer.start();
		establecerIcono(coordenada);
		
		if (marcarCarta(coordenada, this.control.getCartas()) && !comprobarMarcable(this.control.getCartas())) {
			this.control.aumentarJugada();
			this.paraui.getNumJugadas().setText(String.valueOf(this.control.getJugadas()));

			if (comprobarParejas(this.control.getCartas())) {
				desvelarMarcadas();
				desmarcarCartas(this.control.getCartas());
			} else {
				return false;
			}
		}
		
		if(comprobarCompletado(this.control.getCartas())) {
			this.paraui.getMensaje().setVisible(true);
		}
		
		return true;
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
	
	@Override
	public boolean comprobarDerrota(int valor) {
		return valor == 0;
	}
	
	@Override
	public boolean marcarCarta(Coordenada coordenadas, Carta[][] cartas) {
		Carta carta = cartas[coordenadas.getX()][coordenadas.getY()];

		if (carta.isVelada() && comprobarMarcable(cartas)) {
			cartas[coordenadas.getX()][coordenadas.getY()].setMarcada(true);
			return true;
		} else {
			return false;
		}
	}
	
	public void establecerIcono(Coordenada coordenada) {
		Carta carta = this.control.getCartas()[coordenada.getX()][coordenada.getY()];
		
		this.paraui.getBotonera().getBotonera()[coordenada.getX()][coordenada.getY()].setIcon(createScaledIcon(new ImageIcon(getClass().getResource(this.control.getImagenesCartas()[carta.getValor() - 1])), this.paraui.getBotonera().getBotonera()[0][0].getHeight()));
	}

	/**
	 * Cambia la propiedad -marcada- a FALSE
	 * 
	 * @param cartas
	 */
	public void desmarcarCartas(Carta[][] cartas) {
		assert cartas != null : "La matriz es nula";
		
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
		return new ImageIcon(Imagen.getImage().getScaledInstance(height - 5, height - 5, Image.SCALE_SMOOTH));
	}

	public void bloquearCartas() {
		for (int i = 0; i < this.paraui.getDimension(); i++) {
			for (int j = 0; j < this.paraui.getDimension(); j++) {
				this.paraui.getBotonera().getBotonera()[i][j].setEnabled(false);
			}
		}
	}

	/**
	 * Elimina el icono que contengan aquellas cartas, que en el momento de la llamada, se encuentren marcadas.
	 */
	public void borrarMarcadas() {
		for (int i = 0; i < this.paraui.getDimension(); i++) {
			for (int j = 0; j < this.paraui.getDimension(); j++) {
				if (this.control.getCartas()[i][j].isMarcada()) {
					this.paraui.getBotonera().getBotonera()[i][j].setIcon(null);
				}
			}
		}
	}

	/**
	 * Cambia la propiedad -velada- a FALSE en aquellas cartas que, en el momento de la llamada, se encuentren marcadas.
	 */
	public void desvelarMarcadas() {
		for (int i = 0; i < this.paraui.getDimension(); i++) {
			for (int j = 0; j < this.paraui.getDimension(); j++) {
				if (this.control.getCartas()[i][j].isMarcada()) {
					this.control.getCartas()[i][j].setVelada(false);
					this.paraui.getBotonera().getBotonera()[i][j].setVisible(false);
				}
			}
		}
	}
	
	public void reiniciar() {
		this.paraui.getMensaje().setVisible(false);
		this.paraui.getNumJugadas().setText(String.valueOf(this.control.getJugadas()));
		this.paraui.getProgressBar().setValue(100);
		this.paraui.getProgressBar().setString("100 segundos");
		this.timer.stop();
		for (int i = 0; i < this.control.getDimension(); i++) {
			for (int j = 0; j < this.control.getDimension(); j++) {
				this.paraui.getBotonera().getBotonera()[i][j].setIcon(null);
				this.paraui.getBotonera().getBotonera()[i][j].setVisible(true);
				this.paraui.getBotonera().getBotonera()[i][j].setEnabled(true);
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

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

}
