package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.UI;

public class ParaUI extends UI {
	
	private Accion acciones;
	private ActionCasilla listenerCasilla= new ActionCasilla(this);
	
	public ParaUI() {
		acciones = new Accion();
		
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearJuego();
				setListeners(listenerCasilla);
			}
		});
	}

}
