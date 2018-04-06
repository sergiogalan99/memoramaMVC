package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Tablero;
import vista.UI;

public class ParaUI extends UI {
	
	private int dimension;
	private Tablero control;
	private Accion acciones = new Accion(this);
	private ActionCasilla listenerCasilla= new ActionCasilla(this);
	private ActionReiniciar listenerReiniciar = new ActionReiniciar(this);
	
	public ParaUI() {
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dimension = crearJuego();
				setListeners(listenerCasilla, listenerReiniciar);
				control = new Tablero(dimension);
				acciones.setControl(control);
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

}
