 package control;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;
import modelo.Carta;
import modelo.Coordenada;
import modelo.Tablero;
import vista.UI;

public class ParaUI extends UI {
	
	private int dimension;
	
	private Tablero control;
	private Accion acciones = new Accion(this);
	private ActionCasilla listenerCasilla= new ActionCasilla(this);
	private ActionReiniciar listenerReiniciar = new ActionReiniciar(this);
	private ActionProgreso listenerProgreso = new ActionProgreso(this);
	private ActionRedimension listenerRedimension = new ActionRedimension(this);
	private Timer timer = new Timer(1000, this.listenerProgreso);
	
	public ParaUI() {
		timer.setRepeats(true);
		establecerListenersDificultad();
	}
	
	public void establecerListenersDificultad() {
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarPartida(e);
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarPartida(e);
			}
		});
		
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarPartida(e);
			}
		});
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
	public ImageIcon createScaledIcon(ImageIcon Imagen, int height) {
		return new ImageIcon(Imagen.getImage().getScaledInstance(height - 15, height - 15, Image.SCALE_SMOOTH));
	}
	
	private void inicializarPartida(ActionEvent e) {
		dimension = crearJuego((((JButton) e.getSource()).getName()));
		setListeners(listenerCasilla, listenerReiniciar, listenerRedimension);
		control = new Tablero(dimension);
		timer.setDelay(getTiempo());
	}

	public int getDimension() {
		return dimension;
	}

	public Tablero getControl() {
		return control;
	}

	public Accion getAcciones() {
		return acciones;
	}

	public ActionCasilla getListenerCasilla() {
		return listenerCasilla;
	}

	public ActionProgreso getListenerProgreso() {
		return listenerProgreso;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public boolean comprobarParejas(Carta[][] cartas) {
		return control.comprobarParejas(cartas);
	}

	public boolean comprobarMarcable(Carta[][] cartas) {
		return control.comprobarMarcable(cartas);
	}

	public boolean comprobarCompletado(Carta[][] cartas) {
		return control.comprobarCompletado(cartas);
	}

	public boolean comprobarDerrota(int valor) {
		return control.comprobarDerrota(valor);
	}

	public void desvelarMarcadas(Carta[][] cartas) {
		control.desvelarMarcadas(cartas);
	}

	public void desmarcarCartas(Carta[][] cartas) {
		control.desmarcarCartas(cartas);
	}

	public void desvelar(Carta casilla) {
		control.desvelar(casilla);
	}

	public boolean realizarJugada(Coordenada coordenada) {
		return control.realizarJugada(coordenada);
	}

	public boolean marcarCarta(Coordenada coordenadas, Carta[][] cartas) {
		return control.marcarCarta(coordenadas, cartas);
	}

	public int getCantidadParejas() {
		return control.getCantidadParejas();
	}

	public int getCantidadCasillas() {
		return control.getCantidadCasillas();
	}

	public void setDimension(int dimension) {
		control.setDimension(dimension);
	}

	public void setCantidadParejas(int cantidadParejas) {
		control.setCantidadParejas(cantidadParejas);
	}

	public void setCantidadCasillas(int cantidadCasillas) {
		control.setCantidadCasillas(cantidadCasillas);
	}

	public Carta[][] getCartas() {
		return control.getCartas();
	}

	public void setCartas(Carta[][] cartas) {
		control.setCartas(cartas);
	}

	public int getCantidadCartas() {
		return control.getCantidadCartas();
	}

	public void setCantidadCartas(int cantidadCartas) {
		control.setCantidadCartas(cantidadCartas);
	}

	public int getJugadas() {
		return control.getJugadas();
	}

	public void setJugadas(int jugadas) {
		control.setJugadas(jugadas);
	}

	public String[] getImagenesCartas() {
		return control.getImagenesCartas();
	}

	public void setImagenesCartas(String[] imagenesCartas) {
		control.setImagenesCartas(imagenesCartas);
	}

	public void reiniciar() {
		acciones.reiniciar();
	}

}
