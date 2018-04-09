package control;

import modelo.Carta;

public interface Desvelable {

	/**
	 * Cambia la propiedad -velada- a FALSE en aquellas cartas que, en el momento de la llamada, se encuentren marcadas.
	 */
	public void desvelarMarcadas(Carta[][] cartas);
}
