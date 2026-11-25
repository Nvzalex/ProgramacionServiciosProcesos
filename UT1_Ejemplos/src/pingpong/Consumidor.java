package pingpong;

public class Consumidor extends Thread {
	private final Cola cola;
	private final int veces;

	public Consumidor(Cola cola, int veces) {
		this.cola = cola;
		this.veces = veces;
	}

	@Override
	public void run() {
		for (int i = 0; i < veces; i++) {
			String mensaje = cola.get();
			System.out.print(mensaje + " ");
		}
		System.out.println();
	}
}