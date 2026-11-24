package examenCorregido.EJ2;

public class Examen extends Thread {
    private Cola cola;
    private int totalAlumnos;

    public Examen(Cola cola, int totalAlumnos) {
        this.cola = cola;
        this.totalAlumnos = totalAlumnos;
    }

    @Override
    public void run() {
        for (int i = 0; i < totalAlumnos; i++) {
            String nombre = cola.get();

            try {
                long tiempo = (long) (Math.random() * 1500) + 500;
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Examen de " + nombre + " recogido y validado");
        }
        System.out.println("Proceso finalizado");
    }
}