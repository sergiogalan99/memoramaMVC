package modelo;

import control.Comprobable;
import control.Desvelable;
import control.Jugable;
import control.Marcable;

public class Tablero implements Marcable, Comprobable, Desvelable, Jugable {

	private int dimension;
	private int cantidadParejas;
	private int cantidadCartas;
	private int jugadas;
	private Carta[][] cartas;
	private String[] imagenesCartas;

	public Tablero(int dimension) {
		this.dimension = dimension;
		this.cantidadCartas = (int) Math.pow(this.dimension, 2);
		this.cantidadParejas = this.cantidadCartas / 2;
		this.imagenesCartas = new String[this.cantidadParejas];
		this.cartas = new Carta[this.dimension][this.dimension];
		inicializarCartas();
		sortearValoresCartas();
		inicializarImagenesCartas();
	}
	
	@Override
	public boolean realizarJugada(Coordenada coordenada) {
		if (marcarCarta(coordenada, this.cartas)
				&& !comprobarMarcable(this.cartas)) {
			if (comprobarParejas(this.cartas)) {
				desvelarMarcadas(this.cartas);
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean comprobarParejas(Carta[][] cartas) {
		Carta[] marcadas = new Carta[2];

		for (Carta[] i : cartas) {
			for (Carta carta : i) {
				if (carta.isMarcada()) {
					if (marcadas[0] == null) {
						marcadas[0] = carta;
					} else {
						marcadas[1] = carta;
						break;
					}
				}
			}
			if (marcadas[1] != null) {
				break;
			}
		}

		return marcadas[0].getValor() == marcadas[1].getValor();
	}

	@Override
	public boolean comprobarMarcable(Carta[][] cartas) {
		int marcadas = 0;
		for (Carta[] i : cartas) {
			for (Carta carta : i) {
				if (carta.isMarcada()) {
					marcadas++;
				}
			}
		}

		return marcadas < 2;
	}

	@Override
	public boolean comprobarCompletado(Carta[][] cartas) {
		for (Carta[] i : cartas) {
			for (Carta carta : i) {
				if (carta.isVelada()) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public boolean comprobarDerrota(int valor) {
		return valor == 0;
	}

	@Override
	public boolean marcarCarta(Coordenada coordenadas, Carta[][] cartas) {
		Carta carta = cartas[coordenadas.getX()][coordenadas.getY()];

		if (carta.isVelada() && comprobarMarcable(cartas)) {
			cartas[coordenadas.getX()][coordenadas.getY()].setMarcada(true);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void desvelarMarcadas(Carta[][] cartas) {
		for (Carta[] i : cartas) {
			for (Carta carta : i) {
				if (carta.isMarcada()) {
					carta.setVelada(false);
				}
			}
		}
	}

	@Override
	public void desmarcarCartas(Carta[][] cartas) {
		for (Carta[] i : cartas) {
			for (Carta carta : i) {
				carta.setMarcada(false);
			}
		}
	}

	public void desvelar(Carta casilla) {
		casilla.setVelada(false);
	}

	public void reiniciar() {
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				this.cartas[i][j] = null;
			}
		}
		this.jugadas = 0;
		inicializarCartas();
		sortearValoresCartas();
	}

	private void inicializarCartas() {
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				cartas[i][j] = new Carta();
			}
		}
	}
	
	/**
	 * Inicializar el vector que contiene la direccion de las imagenes asociadas a cada carta
	 */
	private void inicializarImagenesCartas() {
		for (int i = 0; i < this.cantidadParejas; i++) {
			this.imagenesCartas[i] = "/assets/" + (i + 1) + ".png";
		}
	}

	/**
	 * Establece valores a cada instancia de la matriz de forma pareja.
	 */
	private void sortearValoresCartas() {
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

	/**
	 * Muestra el valor de las cartas contenidas en la matriz de tipo Carta
	 */
	private void mostrarTablero() {
		System.out.println("\n------------\n");

		for (Carta[] i : this.cartas) {
			for (Carta carta : i) {
				System.out.print(carta.getValor() + " ");
			}
			System.out.println();
		}

		System.out.println("\n------------\n");
	}

	/**
	 * Comprueba si el valor de la casilla especificada es cero.
	 * 
	 * @param casilla
	 * @return Retorna TRUE en caso de que el valor de la casilla especificada sea cero o FALSE en caso contrario.
	 */
	private boolean comprobarValorCero(Carta casilla) {
		return casilla.getValor() == 0;
	}

	/**
	 * Genera un numero aleatorio entre un minimo y un maximo
	 * 
	 * @param max
	 * @param min
	 * @return Retorna un valor de tipo Integer entre un minimo y un maximo
	 */
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

	public int getJugadas() {
		return jugadas;
	}

	public void setJugadas(int jugadas) {
		this.jugadas = jugadas;
	}

	public String[] getImagenesCartas() {
		return imagenesCartas;
	}

	public void setImagenesCartas(String[] imagenesCartas) {
		this.imagenesCartas = imagenesCartas;
	}

}
