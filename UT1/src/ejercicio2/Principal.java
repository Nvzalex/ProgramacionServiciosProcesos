package ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    // Lista de los ficheros que se van a procesar (uno por hilo)
    private static final String[] FICHEROS = {
        "harry_potter.txt",
        "el_código_da_vinci.txt",
        "el_caso_bourne.txt",
        "el_nombre_de_la_rosa.txt",
        "juego_de_tronos.txt",
        "palabras_en.txt",
        "palabras_es.txt"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

        // ---- Entrada de datos del usuario ----
        System.out.println("BUSCADOR EN FICHEROS");
        System.out.println("----------------");
        System.out.print("Introduce la longitud de la palabra (0 para todas): ");

        int longitud = 0;
        try {
            longitud = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            longitud = 0; // Si no introduce un número válido, se cuentan todas
        }

        System.out.print("Introduce texto a buscar (vacio para todos): ");
        String texto = sc.nextLine().trim();
        System.out.println("----------------");

        // Lista donde guardaremos todos los hilos creados
        List<Thread> hilos = new ArrayList<>();

        // ---- Creación y arranque de los hilos ----
        for (String fichero : FICHEROS) {
            // Variables finales para poder usarlas dentro de la expresión lambda
            final int len = longitud;
            final String txt = texto;

            // Creamos un hilo para cada fichero
            Thread hilo = new Thread(() -> {
                long inicio = System.currentTimeMillis();           // Tiempo de inicio
                int palabras = contarPalabras(fichero, len, txt);   // Contamos las palabras
                long tiempo = System.currentTimeMillis() - inicio;  // Tiempo total

                // Mostramos el resultado de este hilo
                System.out.println("Archivo " + fichero + ": " + palabras + " palabras.");
                System.out.println(fichero + ": " + tiempo + " milisegundos");
            });

            hilos.add(hilo);   // Guardamos el hilo en la lista
            hilo.start();      // Arrancamos el hilo (empieza a ejecutarse concurrentemente)
        }

        // ---- Esperamos a que todos los hilos terminen ----
        for (Thread h : hilos) {
            try {
                h.join();  // El hilo principal espera a que este hilo acabe
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        sc.close();
    }

    /**
     * Cuenta las palabras de un fichero que cumplen las condiciones.
     * @param nombreFichero nombre del archivo a leer
     * @param longitud      longitud exigida (0 = cualquier longitud)
     * @param texto         texto que debe contener la palabra (vacío = cualquiera)
     */
    private static int contarPalabras(String nombreFichero, int longitud, String texto) {
        int contador = 0;
        String textoLower = texto.toLowerCase();
        boolean filtrarLongitud = longitud > 0;
        boolean filtrarTexto = !texto.isEmpty();

        // Ruta relativa desde la raíz del proyecto hasta la carpeta ej2
        try (BufferedReader br = new BufferedReader(
                new FileReader("src/ejercicios/ej2/" + nombreFichero, StandardCharsets.UTF_8))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                // Separamos la línea en palabras usando espacios
                String[] tokens = linea.split("\\s+");

                for (String token : tokens) {
                    if (token.isEmpty()) continue;

                    // Quitamos signos de puntuación al principio y al final
                    String palabra = token.replaceAll("^[\\p{Punct}]+|[\\p{Punct}]+$", "");
                    if (palabra.isEmpty()) continue;

                    // Filtro por longitud
                    if (filtrarLongitud && palabra.length() != longitud) continue;

                    // Filtro por texto contenido (no distingue mayúsculas/minúsculas)
                    if (filtrarTexto && !palabra.toLowerCase().contains(textoLower)) continue;

                    contador++; // La palabra cumple las condiciones
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo " + nombreFichero + ": " + e.getMessage());
        }
        return contador;
    }
}