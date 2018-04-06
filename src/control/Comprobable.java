package control;

import modelo.Carta;

public interface Comprobable {
	
	/**
	 * Comprueba si los valores de las cartas son iguales
	 * 
	 * @param cartaUno
	 * @param cartaDos
	 * @return Retorna TRUE en caso de que ambos valores sean iguales o FALSE en caso contrario
	 */
	public boolean comprobarParejas(Carta[][] cartas);
	
	/**
	 * Comprueba si hay menos de 2 cartas marcadas
	 * 
	 * @param cartas
	 * @return Retorna TRUE si se puede marcar una carta o FALSE en caso contrario
	 */
	public boolean comprobarMarcable(Carta[][] cartas);

}
