package pingpong;

public class Productor extends Thread {
	private final Cola cola;
	private final int veces;

	public Productor(Cola cola, int veces) {
		this.cola = cola;
		this.veces = veces;
	}

	@Override
	public void run() {
		for (int i = 0; i < veces; i++) {
			String mensaje = (i % 2 == 0) ? "PING" : "PONG";
			cola.put(mensaje);
		}
	}
}