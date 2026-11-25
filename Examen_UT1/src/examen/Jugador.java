package examen;

import java.util.ArrayList;

public class Jugador extends Thread {
	static ArrayList<String> jugador = new ArrayList<String>();

	public void run() {
		for (int i = 0; i <= PrincipalCompeticiónJuegos.jugadores; i++) {
			jugador.add("JUGADOR" + i);
			System.out.println(jugador + " inicia su partida");
		}
	}

}
