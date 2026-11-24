package hilos;

public class PruebaMiHilo {
    public static void main(String[] args) {
        MiHilo h1 = new MiHilo("Hilo1", Math.random() * 1000);
        MiHilo h2 = new MiHilo("Hilo2", Math.random() * 1000);
        MiHilo h3 = new MiHilo("Hilo3", Math.random() * 1000);

        h1.start();
        h2.start();
        h3.start();
    }
}