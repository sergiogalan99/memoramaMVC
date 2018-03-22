package modelo;

public class Carta {

	private boolean velada;
	private int valor;
	private boolean marcada;
	
	public Carta() {
		this.velada = true;
		this.marcada = false;
	}

	public boolean isVelada() {
		return velada;
	}

	public void setVelada(boolean velada) {
		this.velada = velada;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public boolean isMarcada() {
		return marcada;
	}

	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}

}
