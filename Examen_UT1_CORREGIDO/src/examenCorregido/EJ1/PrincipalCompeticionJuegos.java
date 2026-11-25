package examenCorregido.EJ1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalCompeticionJuegos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de jugadores: ");
        int numJugadores = sc.nextInt();
        sc.nextLine();

        String[] nombresBase = {
            "JESÚS", "ALEJANDRO", "LARA", "JOSÉ", "ADRIÁN",
            "ÁGATA", "JAVIER", "DANIEL", "ARTURO", "HERNÁN",
            "MANUEL", "ALVAR", "MARTÍN", "SEBASTIÁN", "NACHO"
        };
        	
        List<Jugador> jugadores = new ArrayList<>();

        for (int i = 0; i < numJugadores; i++) {
            String nombre = (i < nombresBase.length) ? nombresBase[i] : "Jugador" + (i + 1);
            jugadores.add(new Jugador(nombre));
        }

        for (Jugador j : jugadores) {
            j.start();
        }

        for (Jugador j : jugadores) {
            try {
                j.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nTABLA DE PUNTUACIÓN:");
        Jugador ganador = jugadores.get(0);

        for (Jugador j : jugadores) {
            System.out.printf("La puntuación de %s es %.15f%n", j.getNombre(), j.getPuntuacion());
            if (j.getPuntuacion() > ganador.getPuntuacion()) {
                ganador = j;
            }
        }

        System.out.println("\nFELICIDADES " + ganador.getNombre() + " HAS GANADO!!!!");
        sc.close();
    }
}