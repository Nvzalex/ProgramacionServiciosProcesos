package repaso1;

public class Consumidor extends Thread {
	private Cola cola;
	private int n;
	private int maxPila;

	public Consumidor(Cola cola, int n, int maxPila) {
		this.cola = cola;
		this.n = n;
		this.maxPila = maxPila;
	}

	public void run() {
		int valor = 0;
		for (int i = 0; i < 5; i++) {
			valor = cola.get();
			System.out.println(i + " Consumidor: " + n + " consume el número " + valor);
		}
	}
}
