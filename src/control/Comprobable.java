package control;

import modelo.Carta;

public interface Comprobable {
	
	/**
	 * Comprueba si los valores de las cartas marcadas son iguales
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
	
	/**
	 * Comprueba si se han desvelado todas las cartas
	 * 
	 * @param cartas
	 * @return Retorna TRUE en caso de que se hayan desvelado todas las cartas o FALSE en caso contrario
	 */
	public boolean comprobarCompletado(Carta[][] cartas);
	
	/**
	 * Comprueba si el valor es igual a 0.
	 * 
	 * @param valor
	 * @return Retorna TRUE en caso de que el valor sea igual a 0 o FALSE en caso contrario.
	 */
	public boolean comprobarDerrota(int valor);

}
