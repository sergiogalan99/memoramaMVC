package control;

import java.awt.Color;
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
		
		if(this.paraUI.getControl().comprobarDerrota(this.paraUI.getProgressBar().getValue())) {
			this.paraUI.getBotonera().setVisible(false);
			this.paraUI.getPanel_1().setBackground(this.paraUI.getBotonera().getCartaVelada());
			this.paraUI.generarMensajeFinal("Derrota", false);
		}
	}

}
