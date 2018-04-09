package control;

import modelo.Coordenada;

public interface Jugable {

	/**
	 * Realiza una jugada a partir de las coordenadas pasadas por parametro.
	 * 
	 * @param coordenada
	 * @return Retorna TRUE si las cartas marcadas son pareja o si se han marcado
	 *         menos de 2 cartas o FALSE si las cartas marcadas no son parejas.
	 */
	public boolean realizarJugada(Coordenada coordenada);
}
