package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionProgreso implements ActionListener {
	
	private ParaUI paraUI;

	public ActionProgreso(ParaUI paraUI) {
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.disminuirTiempo();
		
		if(this.paraUI.getAcciones().comprobarDerrota(this.paraUI.getProgressBar().getValue())) {
			this.paraUI.getAcciones().bloquearCartas();
		}
	}

}
