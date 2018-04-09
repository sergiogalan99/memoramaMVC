package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import modelo.Tablero;
import vista.UI;

public class ParaUI extends UI {
	
	private int dimension;
	private Tablero control;
	private ActionCasilla listenerCasilla= new ActionCasilla(this);
	private ActionReiniciar listenerReiniciar = new ActionReiniciar(this);
	private ActionProgreso listenerProgreso = new ActionProgreso(this);
	private Timer timer = new Timer(1000, this.listenerProgreso);
	private Accion acciones = new Accion(this, timer);
	
	public ParaUI() {
		timer.setRepeats(true);
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dimension = crearJuego();
				setListeners(listenerCasilla, listenerReiniciar);
				control = new Tablero(dimension);
				acciones.setControl(control);
				acciones.getTimer().setDelay(getTiempo());
			}
		});
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

}
