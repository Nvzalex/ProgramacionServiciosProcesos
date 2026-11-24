package hilos;

public class CrearHilosJoin {
    public static void main(String[] args) {
        HiloJoin h1 = new HiloJoin("1", 5);
        HiloJoin h2 = new HiloJoin("2", 2);
        HiloJoin h3 = new HiloJoin("3", 10);

        h1.start();
        h2.start();
        h3.start();

        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("FIN DEL PROGRAMA");
    }
}