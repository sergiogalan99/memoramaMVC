package control;

import modelo.Carta;

public interface Comprobable {

	/**
	 * Comprueba si todas las cartas estan desveladas
	 * 
	 * @param tablero
	 * @return Retorna TRUE si todas las cartas estan desveladas o FALSE en caso contrario
	 */
	public boolean comprobarVictoria(Carta[][] carta);
	
	/**
	 * Comprueba si el numero de fallos supera un maximo
	 * 
	 * @param fallos
	 * @param limiteFallos
	 * @return Retorna TRUE si el numero de fallos supera dicho maximo o FALSE en caso contrario
	 */
	public boolean comprobarDerrota(int fallos, int limiteFallos);
	
	
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
