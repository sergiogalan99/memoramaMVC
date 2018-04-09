package control;

import modelo.Carta;
import modelo.Coordenada;

public interface Marcable {
	
	/**
	 * Comprueba si puede ser marcada una carta a partir de una coordenada.
	 * 
	 * @param coordenadas Coordenadas donde se encuentra un objeto Carta en la matriz.
	 * @param cartas Matriz con las instancias de la clase Carta.
	 * @return Retorna TRUE si en la matriz hay menos de 2 cartas marcadas o FALSE en caso contrario.
	 */
	public boolean marcarCarta(Coordenada coordenadas, Carta[][] cartas);
	
	/**
	 * Cambia la propiedad -marcada- a FALSE de todas las instancias contenidas en una matriz de tipo Carta
	 * 
	 * @param cartas
	 */
	public void desmarcarCartas(Carta[][] cartas);
}
