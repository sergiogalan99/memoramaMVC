package control;

import modelo.Coordenada;

public interface Desvelable {
	
	/**
	 * Deshabilitar dos botones con el mismo valor
	 * 
	 * @param valor
	 */
	public boolean desvelar(Coordenada coordenada);
}
