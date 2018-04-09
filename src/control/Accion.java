package control;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import modelo.Carta;
import modelo.Coordenada;
import modelo.Tablero;

public class Accion implements Jugable{

	private ParaUI paraui;
	private Tablero control;
	private Timer timer;

	public Accion(ParaUI paraui, Timer timer) {
		this.paraui = paraui;
		this.timer = timer;
	}

	@Override
	public boolean realizarJugada(Coordenada coordenada) {
		this.timer.start();
		establecerIcono(coordenada);
		
		if(!this.control.realizarJugada(coordenada)) {
			return false;
		}
		
		if(this.control.comprobarCompletado(this.control.getCartas())) {
			this.paraui.getMensaje().setVisible(true);
		}
		
		return true;
	}

	/**
	 * Establece un icono en un JButton a partir de una coordenada y dicho icono
	 * sera el especificado por el valor de la carta que ocupa su misma posicion en
	 * la matriz de las cartas.
	 * 
	 * @param coordenada
	 */
	private void establecerIcono(Coordenada coordenada) {
		Carta carta = this.control.getCartas()[coordenada.getX()][coordenada.getY()];

		this.paraui.getBotonera().getBotonera()[coordenada.getX()][coordenada.getY()].setIcon(createScaledIcon(
				new ImageIcon(getClass().getResource(this.control.getImagenesCartas()[carta.getValor() - 1])),
				this.paraui.getBotonera().getBotonera()[0][0].getHeight()));
	}

	/**
	 * Escala un icono en base a una medida
	 * 
	 * @param Imagen
	 *            Icono a escalar
	 * @param height
	 *            Medida con la que escalar
	 * @return Icono escalado
	 */
	private ImageIcon createScaledIcon(ImageIcon Imagen, int height) {
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
	 * Elimina el icono que contengan aquellas cartas, que en el momento de la
	 * llamada, se encuentren marcadas.
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

	public void reiniciar() {
		this.paraui.getMensaje().setVisible(false);
		this.paraui.getNumJugadas().setText(String.valueOf(this.control.getJugadas()));
		this.paraui.getProgressBar().setValue(100);
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
