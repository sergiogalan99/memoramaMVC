package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.UI;

public class ParaUI extends UI {
	
	private Accion acciones;
	
	public ParaUI() {
		acciones = new Accion();
		
		btnBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}

}
