package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Tablero;
import vista.UI;

public class ParaUI extends UI {
	
	private int dimension;
	private Tablero control = new Tablero(dimension);
	private Accion acciones = new Accion();
	private ActionCasilla listenerCasilla= new ActionCasilla(this);
	
	public ParaUI() {
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dimension = crearJuego();
				setListeners(listenerCasilla);
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
