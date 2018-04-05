package control;

import modelo.Carta;
import modelo.Coordenada;
import modelo.Tablero;

public class Accion implements Comprobable {
	
	private ParaUI paraui;
	private Tablero control;
	
	public Accion(ParaUI paraui, Tablero control) {
		this.paraui = paraui;
		this.control = control;
	}
	
	public Accion(ParaUI paraui) {
		this.paraui = paraui;
	}
	
	public void realizarJugada(Coordenada coordenada) {
		this.paraui.getBotonera().getBotonera()[coordenada.getX()][coordenada.getY()].setText(String.valueOf(this.control.getCartas()[coordenada.getX()][coordenada.getY()].getValor()));
		if(marcarCarta(coordenada, this.control.getCartas()) && !comprobarMarcable(this.control.getCartas())) {
			if(comprobarParejas(this.control.getCartas())) {
				System.out.println("Son parejas");
				desvelar();
				// No se hace nada en principio
				//TODO Hacer si son parejas pero no hay victoria ni derrota
			} else {
				//TODO Hacer si no son parejas
				System.out.println("No son parejas");
				borrarMarcadas();
				this.control.getFallos().aumentarFallos();
			}
			
			if(comprobarVictoria(this.control.getCartas())) {
				bloquearCartas();
				this.paraui.getTextoMensaje().setText("Has ganado");
			}
			
			if(comprobarDerrota(this.control.getFallos().getFallos(), this.control.getFallos().getLimiteFallos())) {
				bloquearCartas();
				this.paraui.getTextoMensaje().setText("Has perdido");
			}
			desmarcarCartas(this.control.getCartas()); // Cada vez que se marquen dos cartas, pase lo que pase, hay que desmarcar todas para la siguiente jugada
		}
	}
	
	@Override
	public boolean comprobarVictoria(Carta[][] cartas) {
		for (int i = 0; i < cartas.length; i++) {
			for (int j = 0; j < cartas.length; j++) {
				if(cartas[i][j].isVelada()) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean comprobarDerrota(int fallos, int limiteFallos) {
		assert fallos >= 0 && limiteFallos >= 0 : "Parametros negativos";
		return fallos > limiteFallos;
	}

	@Override
	public boolean comprobarParejas(Carta[][] cartas) {
		Carta cartaUno = null;
		Carta cartaDos = null;
		
		for (int i = 0; i < cartas.length; i++) {
			for (int j = 0; j < cartas.length; j++) {
				if(cartas[i][j].isMarcada()) {
					if(cartaUno == null) {
						cartaUno = cartas[i][j];
					} else {
						cartaDos = cartas[i][j];
					}
				}
			}
		}

		return cartaUno.getValor() == cartaDos.getValor();
	}
	
	@Override
	public boolean comprobarMarcable(Carta[][] cartas) {
		int marcadas = 0;
		for (int i = 0; i < cartas.length; i++) {
			for (int j = 0; j < cartas.length; j++) {
				if(cartas[i][j].isMarcada()) {
					marcadas++;
				}
			}
		}
		return marcadas < 2;
	}

	public boolean marcarCarta(Coordenada coordenadas, Carta[][] cartas) {
		Carta carta = cartas[coordenadas.getX()][coordenadas.getY()];

		if(carta.isVelada() && comprobarMarcable(cartas)) {
			cartas[coordenadas.getX()][coordenadas.getY()].setMarcada(true);
			return true;
		} else {
			return false;
		}
	}
	
	public void desmarcarCartas(Carta[][] cartas) {
		for (int i = 0; i < cartas.length; i++) {
			for (int j = 0; j < cartas.length; j++) {
				cartas[i][j].setMarcada(false);
			}
		}
	}
	
	public void bloquearCartas() {
		for (int i = 0; i < this.paraui.getDimension(); i++) {
			for (int j = 0; j < this.paraui.getDimension(); j++) {
				this.paraui.getBotonera().getBotonera()[i][j].setEnabled(false);
			}
		}
	}
	
	public void borrarMarcadas() {
		for (int i = 0; i < this.paraui.getDimension(); i++) {
			for (int j = 0; j < this.paraui.getDimension(); j++) {
				if(this.control.getCartas()[i][j].isMarcada())
				this.paraui.getBotonera().getBotonera()[i][j].setText("");
			}
		}
	}
	
	public void desvelar() {
		for (int i = 0; i < this.paraui.getDimension(); i++) {
			for (int j = 0; j < this.paraui.getDimension(); j++) {
				if(this.control.getCartas()[i][j].isMarcada()) {
					this.control.getCartas()[i][j].setVelada(false);
					this.paraui.getBotonera().getBotonera()[i][j].setEnabled(false);
				}
			}
		}
	}

	public ParaUI getParaui() {
		return paraui;
	}

	public Tablero getControl() {
		return control;
	}

	public void setParaui(ParaUI paraui) {
		this.paraui = paraui;
	}

	public void setControl(Tablero control) {
		this.control = control;
	}
	
}
