package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.SwingWorker;
import modelo.Carta;
import modelo.Coordenada;

public class ActionCasilla implements ActionListener {

	private ParaUI paraui;
	private Coordenada coordenada = new Coordenada();
	
	public ActionCasilla(ParaUI paraui) {
		this.paraui= paraui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		final SwingWorker worker = new SwingWorker() {
			protected Object doInBackground() throws Exception {
				paraui.penalizarTiempo();
				Thread.sleep(900);
				paraui.getAcciones().borrarMarcadas();
				paraui.getControl().desmarcarCartas(paraui.getControl().getCartas());
				return null;
			};
		};
		
		this.coordenada.setCoordenadas((((JButton) e.getSource()).getName()));
		Carta carta = this.paraui.getControl().getCartas()[this.coordenada.getX()][this.coordenada.getY()];
		if(carta.isVelada() && this.paraui.getControl().comprobarMarcable(this.paraui.getControl().getCartas())) {
			if(!paraui.getAcciones().realizarJugada(this.coordenada)) {
				worker.execute();
			} else {
				
			}
		}
	}

}