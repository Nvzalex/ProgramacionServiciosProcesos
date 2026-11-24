package hilos;

public class MiHilo extends Thread {
    private double tiempo;

    public MiHilo(String nombre, double tiempo) {
        this.tiempo = tiempo;
        this.setName(nombre);
        System.out.println("Creando hilo: " + this.getName());
    }

    @Override
    public void run() {
        System.out.println("MiHilo: " + this.getName() + ", Tiempo: " + tiempo);
        try {
            Thread.sleep((long) tiempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MiHilo FIN: " + this.getName());
    }
}