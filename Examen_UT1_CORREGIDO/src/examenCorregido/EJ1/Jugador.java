package examenCorregido.EJ1;

public class Jugador extends Thread {
    private String nombre;
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println(nombre + " inicia su partida");
        long tiempo = (long) (Math.random() * 6000);
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nombre + " finaliza su partida");
    }
}