package modelo;

public class Coordenada {

	private int coordX;
	private int coordY;
	
	public Coordenada() {}

	public Coordenada(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public int getCoordX() {
		return coordX;
	}
	
	public int getCoordY() {
		return coordY;
	}
	
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	
	public int[] extraerVector() {
		int coordenadas[] = {this.coordX, this.coordY}; 
		return coordenadas;
	}

}
