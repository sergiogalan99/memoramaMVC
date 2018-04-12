package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import control.Comprobable;
import modelo.Carta;
import modelo.Tablero;

class ComprobableTest {

	Comprobable instancia = new Tablero(4);

	@Ignore
	void testComprobarParejas() {
		Carta[][][] cartas = { { { new Carta(), new Carta() }, { new Carta(), new Carta() }},
				{{ new Carta(), new Carta() }, { new Carta(), new Carta() } } };
		for (int i = 0; i < cartas.length; i++) {
			for (int j = 0; j < cartas.length; j++) {
				for (int j2 = 0; j2 < cartas.length; j2++) {
					cartas[i][j][j2].setValor(j2);
				}

			}
		}
		cartas[0][0][0].setMarcada(true);
		cartas[0][1][0].setMarcada(true);

		cartas[1][0][0].setMarcada(true);
		cartas[1][0][1].setMarcada(true);

		assertTrue(this.instancia.comprobarParejas(cartas[0]));
		assertFalse(this.instancia.comprobarParejas(cartas[1]));
	}

	@Ignore
	void testComprobarMarcable() {
		//this.instancia.comprobarMarcable(cartas);
		
	}

	@Test
	void testComprobarCompletado() {
		Carta[][][] cartas = { { { new Carta(), new Carta() }, { new Carta(), new Carta() }},
				{{ new Carta(), new Carta() }, { new Carta(), new Carta() } } };
			for (int j = 0; j < cartas.length; j++) {
				for (int j2 = 0; j2 < cartas.length; j2++) {
					cartas[0][j][j2].setVelada(false);
				}

			}
		
		
		assertTrue(this.instancia.comprobarCompletado(cartas[0]));
		
			for (int j = 0; j < cartas.length; j++) {
				for (int j2 = 0; j2 < cartas.length; j2++) {
					cartas[1][j][j2].setVelada(true);
				}

			}
		
		assertFalse(this.instancia.comprobarCompletado(cartas[1]));
	
	}

	@Ignore
	void testComprobarDerrota() {
	}
	

}
