package modelo;

public class Fallo {

	private int fallos;
	private final int limiteFallos = 5;
	
	public Fallo() {
		this.fallos = 0;
	}
	
	public void aumentarFallos() {
		this.fallos++;
	}

	public int getFallos() {
		return fallos;
	}

	public int getLimiteFallos() {
		return limiteFallos;
	}

	public void setFallos(int fallos) {
		this.fallos = fallos;
	}

}
