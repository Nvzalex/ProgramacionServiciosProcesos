package examen;

public class Cola {
	private int num;
	private boolean disponible = false;
	
	public synchronized int get() {
		while (disponible == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		disponible = false;
		notifyAll();
		return num;
	}

	public synchronized void put(int valor) {
		while (disponible == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		num = valor;
		disponible = true;
		notifyAll();
	}

}