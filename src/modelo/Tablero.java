package modelo;

public class Tablero {
	
	private int dimension;
	private Casilla[][] casillero;
	
	public Tablero(int dimension) {
		this.dimension=dimension;
		inicializar();
	}

	private void inicializar() {
		casillero= new Casilla[dimension][dimension];
		for (int i = 0; i < casillero.length; i++) {
			for (int j = 0; j < casillero.length; j++) {
				casillero[i][j]= new Casilla();
			}
		}
	}
	private void sortearValores(int dimension) {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < 2; j++) {
				
			}
		}
	}
	
	private boolean comprobarValor(Casilla casilla){
		boolean comprobacion=true;
		if (casilla.getValor())==0) {
			comprobacion=false;
		}
		return comprobacion;
	}
	
	private void desvelar(Casilla casilla) {
		casilla.setVelada()=true;
	}
	
}
