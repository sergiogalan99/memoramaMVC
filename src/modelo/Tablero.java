package modelo;

public class Tablero {

	private int dimension;
	private int cantidadParejas;
	private int cantidadCartas;
	private int intentos;
	private Carta[][] cartas;

	public Tablero(int dimension) {
		this.dimension = dimension;
		this.cantidadCartas = (int) Math.pow(this.dimension, 2);
		this.cantidadParejas = this.cantidadCartas / 2;
		inicializar();
		sortearValores();
	}

	public void desvelar(Carta casilla) {
		casilla.setVelada(false);
	}

	private void inicializar() {
		cartas = new Carta[dimension][dimension];
		for (int i = 0; i < cartas.length; i++) {
			for (int j = 0; j < cartas.length; j++) {
				cartas[i][j] = new Carta();
			}
		}
	}

	private void sortearValores() {
		int valorEstablecido;
		Coordenada coordenada;
		for (int i = 1; i <= this.cantidadParejas; i++) {
			valorEstablecido = 0;
			do {
				coordenada = new Coordenada(generarNumeroAleatorio(this.dimension, 0),
						generarNumeroAleatorio(this.dimension, 0));

				if (comprobarValorCero(cartas[coordenada.getX()][coordenada.getY()])) {
					this.cartas[coordenada.getX()][coordenada.getY()].setValor(i);
					valorEstablecido++;
				}

			} while (valorEstablecido < 2);
		}
		mostrarTablero();
	}
	
	private void mostrarTablero() {
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				System.out.print(this.cartas[i][j].getValor() + " ");
			}
			System.out.println();
		}
	}

	private boolean comprobarValorCero(Carta casilla) {
		if (casilla.getValor() == 0) {
			return true;
		}
		return false;
	}

	private int generarNumeroAleatorio(int max, int min) {
		return (int) (Math.random() * (max - min)) + min;
	}

	public int getDimension() {
		return dimension;
	}

	public int getCantidadParejas() {
		return cantidadParejas;
	}

	public int getCantidadCasillas() {
		return cantidadCartas;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public void setCantidadParejas(int cantidadParejas) {
		this.cantidadParejas = cantidadParejas;
	}

	public void setCantidadCasillas(int cantidadCasillas) {
		this.cantidadCartas = cantidadCasillas;
	}

	public Carta[][] getCartas() {
		return cartas;
	}

	public void setCartas(Carta[][] cartas) {
		this.cartas = cartas;
	}

	public int getCantidadCartas() {
		return cantidadCartas;
	}

	public void setCantidadCartas(int cantidadCartas) {
		this.cantidadCartas = cantidadCartas;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

}
