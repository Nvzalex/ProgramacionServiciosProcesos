package ejercicio1;

public class PrincipalMultiplo {
    private static int suma1 = 0;
    private static int suma2 = 0;
    private static int suma3 = 0;

    public static void main(String[] args) {

        Thread h1 = new Thread(() -> {
        	int acumulador = 0;
            for (int i = 1; i <= 100000; i++) {
                acumulador += (int) i * 3;
            }
            suma1 = acumulador;
        });

        Thread h2 = new Thread(() -> {
            int acumulador = 0;
            for (int i = 1; i <= 10000; i++) {
                acumulador += (int) i * 2;
            }
            suma2 = acumulador;
        });

        Thread h3 = new Thread(() -> {
        	int acumulador = 0;
            for (int i = 1; i <= 50000; i++) {
                acumulador += (int) i * 4;
            }
            suma3 = acumulador;
        });

        h1.start();
        h2.start();
        h3.start();


        while (h1.isAlive() || h2.isAlive() || h3.isAlive()) {
            System.out.println("Calculando resultado…");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("El hilo principal fue interrumpido.");
            }
        }

        double resultadoFinal = (double) (suma1 - suma2) / suma3;

        System.out.println("\n--- RESULTADOS FINALES ---");
        System.out.println("Suma 1 (Múltiplos de 3): " + suma1);
        System.out.println("Suma 2 (Múltiplos de 2): " + suma2);
        System.out.println("Suma 3 (Múltiplos de 4): " + suma3);
        System.out.println("Resultado de la fórmula ((Hilo1 - Hilo2) / Hilo3): " + resultadoFinal);
    }
}