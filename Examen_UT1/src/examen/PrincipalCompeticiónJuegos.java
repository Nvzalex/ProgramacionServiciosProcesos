package examen;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PrincipalCompeticiónJuegos {
	public static int jugadores;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
		System.out.print("Introduce el numero de jugadores: ");
		jugadores = sc.nextInt();

		for (int i = 0; i <= jugadores; i++) {
			System.out.println(Jugador.jugador + " inicia su partida");
			long tiempo = (long) (Math.random() * 6);
			try {
				Thread.sleep(tiempo);
				System.out.println(Jugador.jugador + " finaliza su partida");

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("TABLA DE PUNTUACION");

		for (int i = 0; i <= jugadores; i++) {
			double puntos = (double) (Math.random() * 11);
			System.out.println("La puntuacion de " + Jugador.jugador + " es " + puntos);
		}

	}
}
