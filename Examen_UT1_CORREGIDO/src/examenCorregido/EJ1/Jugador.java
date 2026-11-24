package examenCorregido.EJ1;

public class Jugador extends Thread {
    private String nombre;
    private double puntuacion;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        System.out.println(nombre + " inicia su partida");
        try {
            int tiempo = (int) (Math.random() * 5) + 1;
            Thread.sleep(tiempo * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        puntuacion = Math.random() * 9 + 1;
        System.out.println(nombre + " finaliza su partida!!");
    }

    public String getNombre() {
        return nombre;
    }

    public double getPuntuacion() {
        return puntuacion;
    }
}