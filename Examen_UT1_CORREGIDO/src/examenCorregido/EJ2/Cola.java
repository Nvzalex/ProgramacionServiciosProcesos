package examenCorregido.EJ2;

public class Cola {
    private String cadena;
    private boolean disponible = false;

    public synchronized String get() {
        while (disponible == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        disponible = false;
        notifyAll();
        return cadena;
    }

    public synchronized void put(String valor) {
        while (disponible == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cadena = valor;
        disponible = true;
        notifyAll();
    }
}