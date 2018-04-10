package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionReiniciar implements ActionListener {
	
	ParaUI paraUI;
	
	public ActionReiniciar(ParaUI paraUI) {
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.paraUI.getControl().reiniciar();
		this.paraUI.reiniciar();
	}

}
