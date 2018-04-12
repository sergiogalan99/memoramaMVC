package control;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import modelo.Carta;
import modelo.Coordenada;
import vista.Botonera;

public class Accion implements Jugable{

	private ParaUI paraui;

	public Accion(ParaUI paraui) {
		this.paraui = paraui;
	}

	@Override
	public boolean realizarJugada(Coordenada coordenada) {
		this.paraui.getTimer().start();
		establecerIcono(coordenada);
		this.paraui.getBotonera().getBotonera()[coordenada.getX()][coordenada.getY()].setBackground(Color.WHITE);
		
		if(this.paraui.realizarJugada(coordenada)) {
			if(!this.paraui.comprobarMarcable(this.paraui.getCartas())) {
				this.paraui.despenalizarTiempo();
				ocultarMarcadas();
				this.paraui.desmarcarCartas(this.paraui.getCartas());
			}
			
			if(this.paraui.comprobarCompletado(this.paraui.getCartas())) {
				this.paraui.getTimer().stop();
				this.paraui.getBotonera().setVisible(false);
				this.paraui.getPanel_1().setBackground(this.paraui.getColorProgreso());
			}

		} else {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Oculta los botones correspondientes a las cartas marcadas en el momento de la ejecucion
	 */
	public void ocultarMarcadas() {
		for (int i = 0; i < this.paraui.getDimension(); i++) {
			for (int j = 0; j < this.paraui.getDimension(); j++) {
				if(this.paraui.getCartas()[i][j].isMarcada()) {
					this.paraui.getBotonera().getBotonera()[i][j].setVisible(false);
				}
			}
		}
	}

	/**
	 * Establece un icono en un JButton a partir de una coordenada y dicho icono
	 * sera el especificado por el valor de la carta que ocupa su misma posicion en
	 * la matriz de las cartas.
	 * 
	 * @param coordenada
	 */
	private void establecerIcono(Coordenada coordenada) {
		Carta carta = this.paraui.getCartas()[coordenada.getX()][coordenada.getY()];

		this.paraui.getBotonera().getBotonera()[coordenada.getX()][coordenada.getY()].setIcon(this.paraui.createScaledIcon(
				new ImageIcon(getClass().getResource(this.paraui.getImagenesCartas()[carta.getValor() - 1])),
				this.paraui.getBotonera().getBotonera()[0][0].getHeight()));
	}

	public void bloquearCartas() {
		for (JButton[] i : this.paraui.getBotonera().getBotonera()) {
			for (JButton boton : i) {
				boton.setEnabled(false);
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
				if (this.paraui.getCartas()[i][j].isMarcada()) {
					this.paraui.getBotonera().getBotonera()[i][j].setIcon(null);
					this.paraui.getBotonera().getBotonera()[i][j].setBackground(this.paraui.getCartaVelada());
				}
			}
		}
	}

	public void reiniciar() {
		this.paraui.getTimer().stop();
		this.paraui.getContentPane().remove(this.paraui.getPanelJuego());
		this.paraui.crearPanelPrincipal();
		this.paraui.establecerListenersDificultad();
	}

	public ParaUI getParaui() {
		return paraui;
	}

	public void setParaui(ParaUI paraui) {
		this.paraui = paraui;
	}

}
