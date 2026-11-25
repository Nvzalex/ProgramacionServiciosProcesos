package pingpong;

public class Cola {
	private String cadena;
	private boolean disponible = false;

	public synchronized String get() {
		while (!disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		disponible = false;
		notifyAll();
		return cadena;
	}

	public synchronized void put(String valor) {
		while (disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		cadena = valor;
		disponible = true;
		notifyAll();
	}
}