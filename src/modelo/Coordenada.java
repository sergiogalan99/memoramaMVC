package modelo;

public class Coordenada {

	private int x;
	private int y;
	
	public Coordenada() {}
	
	public Coordenada(String coordenada) {
		convertirCoordenadas(coordenada);
	}

	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int[] extraerVector() {
		int coordenadas[] = {this.x, this.y}; 
		return coordenadas;
	}
	
	public void setCoordenadas(String coordenadas) {
		convertirCoordenadas(coordenadas);
	}
	
	private void convertirCoordenadas(String coordenadas) {
		this.x = Integer.parseInt(coordenadas.substring(0, 1));
		this.y = Integer.parseInt(coordenadas.substring(1, 2));
	}

}
