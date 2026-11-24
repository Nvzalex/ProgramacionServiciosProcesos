package examenCorregido.EJ2;

public class Alumno extends Thread {
    private String nombre;
    private Cola cola;

    public static String[] nombres = {
        "ÁGATA", "JERÓNIMO", "HERNÁN", "ARTURO", "JOSUÉ",
        "JESÚS", "FERNANDO", "NACHO", "DANIEL", "MARTÍN"
    };

    public Alumno(String nombre, Cola cola) {
        this.nombre = nombre;
        this.cola = cola;
    }

    @Override
    public void run() {
        System.out.println(nombre + " inicia su examen");

        try {
            long tiempo = (long) (Math.random() * 5) + 1;
            Thread.sleep(tiempo * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(nombre + " finaliza su examen!!");

        cola.put(nombre);
        System.out.println("Examen de " + nombre + " entregado");
    }
}