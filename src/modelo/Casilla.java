package modelo;

public class Casilla {
	private boolean velada;
	private int valor;

	public boolean isEstado() {
		return velada;
	}

	public void setEstado(boolean velada) {
		this.velada = velada;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
