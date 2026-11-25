package examenCorregido.EJ1;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalCompeticiónJuegos {
    public static int jugadores;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        System.out.print("Introduce el numero de jugadores: ");
        jugadores = sc.nextInt();

        for (int i = 0; i < jugadores; i++) {
            String nombre = "Jugador " + (i + 1);
            listaJugadores.add(new Jugador(nombre));
        }

        for (int i = 0; i < listaJugadores.size(); i++) {
            listaJugadores.get(i).start();
        }

        for (int i = 0; i < listaJugadores.size(); i++) {
            try {
                listaJugadores.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("\nTABLA DE PUNTUACION");
        for (int i = 0; i < listaJugadores.size(); i++) {
            double puntos = (double) (Math.random() * 11);
            System.out.println("La puntuacion de Jugador " + (i + 1) + " es " + puntos);
        }
        sc.close();
    }
}